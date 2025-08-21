package de.thecommcraft.dialoguegrapheditor
import js.array.JsArray
import js.array.asList
import js.iterable.iterator
import js.uri.encodeURIComponent
//import kotlinx.browser.window
//import kotlinx.browser.localStorage
import kotlinx.html.*
import kotlinx.html.InputType
//import org.w3c.dom.
//import org.w3c.dom.events.MouseEvent
//import org.w3c.dom.svg.*
import org.w3c.dom.HTMLElement as HTMLElementB
import kotlinx.html.js.onMouseDownFunction
import kotlinx.html.js.input
import kotlinx.html.dom.append
import web.blob.Blob
//import org.w3c.dom.events.KeyboardEvent
//import org.w3c.dom.clipboard.ClipboardEvent
//import org.w3c.dom.events.KeyboardEvent
import kotlin.math.abs
import web.mouse.*
import web.crypto.crypto
import web.dom.document
import web.encoding.*
import web.events.*
import web.file.FileReader
import web.file.loadEvent
import web.svg.*
import web.html.*
import web.keyboard.KEY_DOWN
import web.keyboard.KeyboardEvent
import web.pointer.CLICK
import web.pointer.POINTER_MOVE
import web.pointer.PointerEvent
import web.prompts.confirm
import web.storage.localStorage
import web.timers.*

fun HTMLElement.append(builder: TagConsumer<HTMLElementB>.() -> Unit): List<HTMLElement> {
//    val shadowHost = document.querySelector("#transfer-shadow-host")
    val elmB = this.unsafeCast<HTMLElementB>()
    return elmB.append { builder() }.unsafeCast<List<HTMLElement>>()
}

fun download(filename: String, text: String) {
    val element = document.createElement("a")
    element.setAttribute("href", "data:text/plain;charset=utf-8," + encodeURIComponent(text))
    element.setAttribute("download", filename)

    element.style.display = "none"
    document.body.appendChild(element)

    element.click()

    document.body.removeChild(element)
}

fun uploadFiles(acceptedFileTypes: String, callback: (String) -> Unit) {
    val element = document.body.append {
        input {
            type = InputType.file
            accept = acceptedFileTypes
        }.style.display = "none"
    }
    element as HTMLInputElement
    element.changeEvent.addHandler { _ ->
        element.files?.iterator()?.forEach { file ->
            val fileReader = FileReader()
            fileReader.loadEvent.addHandler { _ ->
                callback(fileReader.result as String)
            }
            fileReader.readAsText(file as Blob)
        }
        Unit
    }
    element.click()
    document.body.removeChild(element)
}

object GraphEditor {
    private const val BOX_WIDTH = 128.0
    private const val BOX_HEIGHT = 80.0
    private const val ARROW_SIDE_LENGTH = 12.0
    private const val OPTION_INPUT_DISTANCE = 8.0
    private const val OPTION_INPUT_WIDTH = 87.2
    private const val OPTION_INPUT_HEIGHT = 21.2

    private val outSvg = document.querySelector("svg#out-svg") as? SVGSVGElement
        ?: error("SVG element with id 'out-svg' not found")

    private val connections = mutableListOf<Triple<HTMLDivElement, HTMLDivElement, HTMLInputElement>>()

    private var currentlyClicked: HTMLDivElement? = null
    private var currentlyConnecting: HTMLDivElement? = null
    private var mouseEvent: MouseEvent? = null
    private var saveInterval: Interval? = null
    private var sessionId: String = ""

    private fun pathData(
        prevPosX_: Double,
        prevPosY_: Double,
        posX_: Double,
        posY_: Double,
        secWidth: Double,
        secHeight: Double
    ): String {
        var prevPosX = prevPosX_
        var prevPosY = prevPosY_
        var posX = posX_
        var posY = posY_

        if (abs(posX - prevPosX) < (BOX_WIDTH + secWidth) / 2.0 &&
            abs(posY - prevPosY) < (BOX_HEIGHT + secHeight) / 2.0
        ) return ""

        var dir = -1
        if (abs(posX - prevPosX) - (BOX_WIDTH + secWidth) / 2.0 <
            abs(posY - prevPosY) - (BOX_HEIGHT + secHeight) / 2.0
        ) {
            if (posY > prevPosY) {
                dir = 1
                posY -= secHeight / 2.0
                prevPosY += BOX_HEIGHT / 2.0
            } else {
                posY += secHeight / 2.0
                prevPosY -= BOX_HEIGHT / 2.0
            }
            return """
                M $prevPosX $prevPosY
                Q $prevPosX ${(posY + prevPosY) / 2} ${(posX + prevPosX) / 2} ${(posY + prevPosY) / 2}
                Q $posX ${(posY + prevPosY) / 2} $posX $posY
                L ${posX - ARROW_SIDE_LENGTH * dir} ${posY - ARROW_SIDE_LENGTH * dir}
                M $posX $posY
                L ${posX + ARROW_SIDE_LENGTH * dir} ${posY - ARROW_SIDE_LENGTH * dir}
            """.trimIndent()
        }

        if (posX > prevPosX) {
            dir = 1
            posX -= secWidth / 2.0
            prevPosX += BOX_WIDTH / 2.0
        } else {
            posX += secWidth / 2.0
            prevPosX -= BOX_WIDTH / 2.0
        }

        return """
            M $prevPosX $prevPosY
            Q ${(posX + prevPosX) / 2} $prevPosY ${(posX + prevPosX) / 2} ${(posY + prevPosY) / 2}
            Q ${(posX + prevPosX) / 2} $posY $posX $posY
            L ${posX - ARROW_SIDE_LENGTH * dir} ${posY - ARROW_SIDE_LENGTH * dir}
            M $posX $posY
            L ${posX - ARROW_SIDE_LENGTH * dir} ${posY + ARROW_SIDE_LENGTH * dir}
        """.trimIndent()
    }

    private fun positionConnInput(nodeA: HTMLDivElement, nodeB: HTMLDivElement, connInput: HTMLInputElement) {
        var prevPosX = nodeA.style.left.pixels + BOX_WIDTH / 2.0
        var prevPosY = nodeA.style.top.pixels + BOX_HEIGHT / 2.0
        val posX = nodeB.style.left.pixels + BOX_WIDTH / 2.0
        val posY = nodeB.style.top.pixels + BOX_HEIGHT / 2.0

        if (abs(posX - prevPosX) - BOX_WIDTH < abs(posY - prevPosY) - BOX_HEIGHT) {
            if (posX <= prevPosX) prevPosX -= OPTION_INPUT_WIDTH
            prevPosY += if (posY > prevPosY) BOX_HEIGHT / 2.0 + OPTION_INPUT_DISTANCE
            else -(BOX_HEIGHT / 2.0 + OPTION_INPUT_DISTANCE + OPTION_INPUT_HEIGHT)
        } else {
            if (posY <= prevPosY) prevPosY -= OPTION_INPUT_HEIGHT
            prevPosX += if (posX > prevPosX) BOX_WIDTH / 2.0 + OPTION_INPUT_DISTANCE
            else -(BOX_WIDTH / 2.0 + OPTION_INPUT_DISTANCE + OPTION_INPUT_WIDTH)
        }

        connInput.style.left = prevPosX.pixels
        connInput.style.top = prevPosY.pixels
    }

    private fun regenSvg() {
        while (outSvg.firstChild != null) outSvg.removeChild(outSvg.lastChild!!)

        for ((nodeA, nodeB, connInput) in connections) {
            positionConnInput(nodeA, nodeB, connInput)

            val prevPosX = nodeA.style.left.pixels + BOX_WIDTH / 2.0
            val prevPosY = nodeA.style.top.pixels + BOX_HEIGHT / 2.0
            val posX = nodeB.style.left.pixels + BOX_WIDTH / 2.0
            val posY = nodeB.style.top.pixels + BOX_HEIGHT / 2.0

            val newPath = document.createElementNS("http://www.w3.org/2000/svg", "path") as SVGPathElement
            newPath.setAttribute("d", pathData(prevPosX, prevPosY, posX, posY, BOX_WIDTH, BOX_HEIGHT))
            outSvg.appendChild(newPath)
        }

        currentlyConnecting?.let { node ->
            val prevPosX = node.style.left.pixels + BOX_WIDTH / 2.0
            val prevPosY = node.style.top.pixels + BOX_HEIGHT / 2.0
            mouseEvent?.let { me ->
                val newPath = document.createElementNS("http://www.w3.org/2000/svg", "path") as SVGPathElement
                newPath.setAttribute("d", pathData(prevPosX, prevPosY, me.pageX, me.pageY, 0.0, 0.0))
                outSvg.appendChild(newPath)
            }
        }
    }

    private fun HTMLElement.myBox(atX: Double, atY: Double): HTMLDivElement {
        return this.append {
            val divElm = div(classes = "draggable-box") {
                textArea {
                    placeholder = "text"
                    onMouseDownFunction = { e ->
                        if ((e.unsafeCast<MouseEvent>()).button != MouseButton.AUXILIARY) e.stopPropagation()
                    }
                }
                style = "left:${atX.pixels};top:${atY.pixels};"
            }
            divElm.unsafeCast<HTMLDivElement>().attachBoxHandlers()
        }[0] as HTMLDivElement
    }

    private fun HTMLDivElement.attachBoxHandlers() {

        addEventListener(MouseEvent.MOUSE_DOWN, { event ->
            if (event.button == MouseButton.AUXILIARY) {
                connections.removeAll {(a, b, c) ->
                    if (a == this || b == this) {
                        c.remove()
                        return@removeAll true
                    }
                    return@removeAll false
                }
                this.remove()
                event.preventDefault()
                regenSvg()
            }
            if (event.button == MouseButton.MAIN) {
                event.preventDefault()
                if (event.shiftKey) currentlyConnecting = this else currentlyClicked = this
            }
        })

        addEventListener(MouseEvent.MOUSE_UP, { _ ->
            val target = this
            currentlyConnecting?.let { startNode ->
                if (target != startNode) {
                    val existingIdx = connections.indexOfFirst { it.first == startNode && it.second == target }
                    if (existingIdx != -1) {
                        connections[existingIdx].third.remove()
                        connections.removeAt(existingIdx)
                    } else {
                        document.body.append {
                            val inputNode = input(classes = "connection-label") {
                                placeholder = "option"
                            }
                            connections.add(Triple(startNode, target, inputNode.unsafeCast<HTMLInputElement>()))
                        }
                    }
                }
            }
        })
    }

    var graphData: GraphData
        get() {
            val htmlNodes = document.querySelectorAll(".draggable-box").asList()
            val htmlNodeToNode = mutableMapOf<HTMLDivElement, GraphNode>()
            val nodes = htmlNodes.mapIndexed { idx, node ->
                node as HTMLDivElement
                val text = (node.querySelector("textarea") as HTMLTextAreaElement).value
                val posX = node.style.left.pixels
                val posY = node.style.top.pixels
                val graphNode = GraphNode(text, posX, posY, idx)
                htmlNodeToNode[node] = graphNode
                graphNode
            }
            val edges: List<GraphEdge> = connections.map { (a, b, c) ->
                val text = c.value
                val first = htmlNodeToNode[a] ?: throw IllegalArgumentException("no first node")
                val second = htmlNodeToNode[b] ?: throw IllegalArgumentException("no second node")
                return@map GraphEdge(text, first, second)
            }
            return GraphData(nodes, edges)
        }
        set(value) {
            document.querySelectorAll(".draggable-box").asDynamic().forEach { node ->
                node.remove()
            }
            connections.removeAll { (_, _, c) ->
                c.remove()
                true
            }
            addGraphData(value)
        }

    var graphDataEncoded: String
        get() = graphData.encode()
        set(value) {
            graphData = GraphData.decode(value)
        }

    fun saveData() {
        if (sessionId == "") sessionId = "dgetool-session-"+crypto.randomUUID()
        localStorage.setItem(sessionId, btoa(graphDataEncoded))
    }

    fun addGraphData(data: GraphData) {
        val htmlDivNodes = data.nodes.map { node ->
            val htmlDivNode = document.body.myBox(node.posX, node.posY)
            (htmlDivNode.querySelector("textarea") as? HTMLTextAreaElement)?.value = node.text
            htmlDivNode
        }
        data.edges.forEach { edge ->
            val startNode = htmlDivNodes[edge.first.index]
            val target = htmlDivNodes[edge.second.index]
            document.body.append {
                val inputNode = input(classes = "connection-label") {
                    placeholder = "option"
                    value = edge.text
                }
                connections.add(Triple(startNode, target, inputNode.unsafeCast<HTMLInputElement>()))
            }
        }
        regenSvg()
    }

    fun init() {
        var keyIdx = 0
        while (localStorage.key(keyIdx) != null) {
            val previousSessionId = localStorage.key(keyIdx)
            if (previousSessionId != null && previousSessionId.startsWith("dgetool-session-")) {
                localStorage.getItem(previousSessionId)?.let { previousSession ->
                    localStorage.removeItem(previousSessionId)
                    val restore = confirm("There was a previous session found. Restore it?")
                    if (restore) {
                        graphDataEncoded = atob(previousSession)
                    } else {
                        localStorage.setItem("deleted-$previousSessionId", previousSession)
                    }
                }
                break
            }
            keyIdx += 1
        }

        document.querySelectorAll(".draggable-box").asDynamic().forEach { node ->
            (node as? HTMLDivElement)?.attachBoxHandlers()
        }

        document.addEventListener(MouseEvent.MOUSE_UP, {
            currentlyClicked = null
            currentlyConnecting = null
            regenSvg()
            saveData()
        })

        document.addEventListener(PointerEvent.CLICK, { event ->
            if (event.ctrlKey) {
                document.body.myBox(event.pageX, event.pageY)
            }
        })

        document.addEventListener(PointerEvent.POINTER_MOVE, { e ->
            mouseEvent = e
            currentlyClicked?.let { node ->
                node.style.left = (node.style.left.pixels + (e.asDynamic().movementX as Double)).pixels
                node.style.top = (node.style.top.pixels + (e.asDynamic().movementY as Double)).pixels
                regenSvg()
            }
            if (currentlyConnecting != null) regenSvg()
        })

        document.addEventListener(KeyboardEvent.KEY_DOWN, { event ->
            if (event.key == "s" && event.ctrlKey) {
                event.preventDefault()
                download("$sessionId.dgegraph", graphDataEncoded)
            }
            if (event.key == "o" && event.ctrlKey) {
                event.preventDefault()
                var cleared = false
                uploadFiles(".dgegraph") {
                    if (!cleared) {
                        cleared = true
                        graphDataEncoded = it
                    } else {
                        addGraphData(GraphData.decode(it))
                    }
                }
            }
        })
//        document.addEventListener("paste", { e ->
//            val event = e as ClipboardEvent
//            val encodedData = event.clipboardData?.getData("Text")
//            encodedData?.let {
//                graphDataEncoded = it
//            }
//        })
        saveData()
        saveInterval = setInterval(::saveData, 10000)
    }
}

val String.pixels get() = this.removeSuffix("px").toDouble()

val Double.pixels get() = this.toString() + "px"

fun main() {
    GraphEditor.init()
}
