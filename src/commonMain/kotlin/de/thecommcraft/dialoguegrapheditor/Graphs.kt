package de.thecommcraft.dialoguegrapheditor

data class GraphNode(val text: String, val posX: Double, val posY: Double, val index: Int) {
    fun encode(): String {
        return "$index $posX $posY ${JSON.stringify(text)}"
    }

    companion object {
        fun decode(line: String): GraphNode {
            var indexString = ""
            val stringIter = line.iterator()
            while (true) {
                if (!stringIter.hasNext()) throw IllegalArgumentException("ran out of line at index")
                val nextChar = stringIter.next()
                if (nextChar == ' ') break
                indexString += nextChar
            }
            val index = try {
                indexString.toInt()
            } catch (_: NumberFormatException) {
                throw IllegalArgumentException("index is not an Int")
            }
            var posXString = ""
            while (true) {
                if (!stringIter.hasNext()) throw IllegalArgumentException("ran out of line at posX")
                val nextChar = stringIter.next()
                if (nextChar == ' ') break
                posXString += nextChar
            }
            val posX = try {
                posXString.toDouble()
            } catch (_: NumberFormatException) {
                throw IllegalArgumentException("posX is not a Double")
            }
            var posYString = ""
            while (true) {
                if (!stringIter.hasNext()) throw IllegalArgumentException("ran out of line at posY")
                val nextChar = stringIter.next()
                if (nextChar == ' ') break
                posYString += nextChar
            }
            val posY = try {
                posYString.toDouble()
            } catch (_: NumberFormatException) {
                throw IllegalArgumentException("posY is not a Double")
            }
            var textString = ""
            while (true) {
                if (!stringIter.hasNext()) break
                val nextChar = stringIter.next()
                textString += nextChar
            }
            val text = JSON.parse<String>(textString)
            return GraphNode(text, posX, posY, index)
        }
    }
}

data class GraphEdge(val text: String, val first: GraphNode, val second: GraphNode) {
    fun encode(): String {
        return "${first.index} ${second.index} ${JSON.stringify(text)}"
    }

    companion object {
        fun decode(line: String, nodes: List<GraphNode>): GraphEdge {
            var firstString = ""
            val stringIter = line.iterator()
            while (true) {
                if (!stringIter.hasNext()) throw IllegalArgumentException("ran out of line at index")
                val nextChar = stringIter.next()
                if (nextChar == ' ') break
                firstString += nextChar
            }
            val first = try {
                nodes.getOrNull(firstString.toInt())
            } catch (_: NumberFormatException) {
                throw IllegalArgumentException("first is not an Int")
            }
            if (first == null) throw IllegalArgumentException("first is an invalid index")
            var secondString = ""
            while (true) {
                if (!stringIter.hasNext()) throw IllegalArgumentException("ran out of line at posX")
                val nextChar = stringIter.next()
                if (nextChar == ' ') break
                secondString += nextChar
            }
            val second = try {
                nodes.getOrNull(secondString.toInt())
            } catch (_: NumberFormatException) {
                throw IllegalArgumentException("second is not an Int")
            }
            if (second == null) throw IllegalArgumentException("second is an invalid index")
            var textString = ""
            while (true) {
                if (!stringIter.hasNext()) break
                val nextChar = stringIter.next()
                textString += nextChar
            }
            val text = JSON.parse<String>(textString)
            return GraphEdge(text, first, second)
        }
    }
}

data class GraphData(val nodes: List<GraphNode>, val edges: List<GraphEdge>) {
    fun encode(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(nodes.size.toString()+"\n")
        nodes.forEach { stringBuilder.append(it.encode()+"\n") }
        stringBuilder.append(edges.size.toString()+"\n")
        edges.forEach { stringBuilder.append(it.encode()+"\n") }
        return stringBuilder.toString()
    }

    companion object {
        fun decode(string: String): GraphData {
            val lines = string.lines()
            val nodesAmount = try {
                lines[0].toInt()
            } catch (_: NumberFormatException) {
                throw IllegalArgumentException("nodesAmount is not an Int")
            }
            val nodes = lines.subList(1, 1 + nodesAmount).map(GraphNode::decode)
            val edgesAmount = try {
                lines[1 + nodesAmount].toInt()
            } catch (_: NumberFormatException) {
                throw IllegalArgumentException("edgesAmount is not an Int")
            }
            val edges = lines.subList(2 + nodesAmount, 2 + nodesAmount + edgesAmount).map { GraphEdge.decode(it, nodes) }
            return GraphData(nodes, edges)
        }
    }
}