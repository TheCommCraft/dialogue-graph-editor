package de.thecommcraft.dialoguegrapheditor.htmldsl

import web.html.*
import web.dom.document
import web.components.HTMLSlotElement
import web.components.HTMLTemplateElement

fun aElm(block: HTMLAnchorElement.() -> Unit) = (document.createElement("a") as HTMLAnchorElement).apply(block)

fun abbrElm(block: HTMLElement.() -> Unit) = (document.createElement("abbr")).apply(block)

fun addressElm(block: HTMLElement.() -> Unit) = (document.createElement("address")).apply(block)

fun areaElm(block: HTMLAreaElement.() -> Unit) = (document.createElement("area") as HTMLAreaElement).apply(block)

fun articleElm(block: HTMLElement.() -> Unit) = (document.createElement("article")).apply(block)

fun asideElm(block: HTMLElement.() -> Unit) = (document.createElement("aside")).apply(block)

fun audioElm(block: HTMLAudioElement.() -> Unit) = (document.createElement("audio") as HTMLAudioElement).apply(block)

fun bElm(block: HTMLElement.() -> Unit) = (document.createElement("b")).apply(block)

fun baseElm(block: HTMLBaseElement.() -> Unit) = (document.createElement("base") as HTMLBaseElement).apply(block)

fun bdiElm(block: HTMLElement.() -> Unit) = (document.createElement("bdi")).apply(block)

fun bdoElm(block: HTMLElement.() -> Unit) = (document.createElement("bdo")).apply(block)

fun blockquoteElm(block: HTMLQuoteElement.() -> Unit) = (document.createElement("blockquote") as HTMLQuoteElement).apply(block)

fun bodyElm(block: HTMLBodyElement.() -> Unit) = (document.createElement("body") as HTMLBodyElement).apply(block)

fun brElm(block: HTMLBRElement.() -> Unit) = (document.createElement("br") as HTMLBRElement).apply(block)

fun buttonElm(block: HTMLButtonElement.() -> Unit) = (document.createElement("button") as HTMLButtonElement).apply(block)

fun canvasElm(block: HTMLCanvasElement.() -> Unit) = (document.createElement("canvas") as HTMLCanvasElement).apply(block)

fun captionElm(block: HTMLTableCaptionElement.() -> Unit) = (document.createElement("caption") as HTMLTableCaptionElement).apply(block)

fun citeElm(block: HTMLElement.() -> Unit) = (document.createElement("cite")).apply(block)

fun codeElm(block: HTMLElement.() -> Unit) = (document.createElement("code")).apply(block)

fun colElm(block: HTMLTableColElement.() -> Unit) = (document.createElement("col") as HTMLTableColElement).apply(block)

fun colgroupElm(block: HTMLTableColElement.() -> Unit) = (document.createElement("colgroup") as HTMLTableColElement).apply(block)

fun dataElm(block: HTMLDataElement.() -> Unit) = (document.createElement("data") as HTMLDataElement).apply(block)

fun datalistElm(block: HTMLDataListElement.() -> Unit) = (document.createElement("datalist") as HTMLDataListElement).apply(block)

fun ddElm(block: HTMLElement.() -> Unit) = (document.createElement("dd")).apply(block)

fun delElm(block: HTMLModElement.() -> Unit) = (document.createElement("del") as HTMLModElement).apply(block)

fun detailsElm(block: HTMLDetailsElement.() -> Unit) = (document.createElement("details") as HTMLDetailsElement).apply(block)

fun dfnElm(block: HTMLElement.() -> Unit) = (document.createElement("dfn")).apply(block)

fun dialogElm(block: HTMLDialogElement.() -> Unit) = (document.createElement("dialog") as HTMLDialogElement).apply(block)

fun divElm(block: HTMLDivElement.() -> Unit) = (document.createElement("div") as HTMLDivElement).apply(block)

fun dlElm(block: HTMLDListElement.() -> Unit) = (document.createElement("dl") as HTMLDListElement).apply(block)

fun dtElm(block: HTMLElement.() -> Unit) = (document.createElement("dt")).apply(block)

fun emElm(block: HTMLElement.() -> Unit) = (document.createElement("em")).apply(block)

fun embedElm(block: HTMLEmbedElement.() -> Unit) = (document.createElement("embed") as HTMLEmbedElement).apply(block)

fun fieldsetElm(block: HTMLFieldSetElement.() -> Unit) = (document.createElement("fieldset") as HTMLFieldSetElement).apply(block)

fun figcaptionElm(block: HTMLElement.() -> Unit) = (document.createElement("figcaption")).apply(block)

fun figureElm(block: HTMLElement.() -> Unit) = (document.createElement("figure")).apply(block)

fun footerElm(block: HTMLElement.() -> Unit) = (document.createElement("footer")).apply(block)

fun formElm(block: HTMLFormElement.() -> Unit) = (document.createElement("form") as HTMLFormElement).apply(block)

fun h1Elm(block: HTMLHeadingElement.() -> Unit) = (document.createElement("h1") as HTMLHeadingElement).apply(block)

fun h2Elm(block: HTMLHeadingElement.() -> Unit) = (document.createElement("h2") as HTMLHeadingElement).apply(block)

fun h3Elm(block: HTMLHeadingElement.() -> Unit) = (document.createElement("h3") as HTMLHeadingElement).apply(block)

fun h4Elm(block: HTMLHeadingElement.() -> Unit) = (document.createElement("h4") as HTMLHeadingElement).apply(block)

fun h5Elm(block: HTMLHeadingElement.() -> Unit) = (document.createElement("h5") as HTMLHeadingElement).apply(block)

fun h6Elm(block: HTMLHeadingElement.() -> Unit) = (document.createElement("h6") as HTMLHeadingElement).apply(block)

fun headElm(block: HTMLHeadElement.() -> Unit) = (document.createElement("head") as HTMLHeadElement).apply(block)

fun headerElm(block: HTMLElement.() -> Unit) = (document.createElement("header")).apply(block)

fun hgroupElm(block: HTMLElement.() -> Unit) = (document.createElement("hgroup")).apply(block)

fun hrElm(block: HTMLHRElement.() -> Unit) = (document.createElement("hr") as HTMLHRElement).apply(block)

fun htmlElm(block: HTMLHtmlElement.() -> Unit) = (document.createElement("html") as HTMLHtmlElement).apply(block)

fun iElm(block: HTMLElement.() -> Unit) = (document.createElement("i")).apply(block)

fun iframeElm(block: HTMLIFrameElement.() -> Unit) = (document.createElement("iframe") as HTMLIFrameElement).apply(block)

fun imgElm(block: HTMLImageElement.() -> Unit) = (document.createElement("img") as HTMLImageElement).apply(block)

fun inputElm(block: HTMLInputElement.() -> Unit) = (document.createElement("input") as HTMLInputElement).apply(block)

fun insElm(block: HTMLModElement.() -> Unit) = (document.createElement("ins") as HTMLModElement).apply(block)

fun kbdElm(block: HTMLElement.() -> Unit) = (document.createElement("kbd")).apply(block)

fun labelElm(block: HTMLLabelElement.() -> Unit) = (document.createElement("label") as HTMLLabelElement).apply(block)

fun legendElm(block: HTMLLegendElement.() -> Unit) = (document.createElement("legend") as HTMLLegendElement).apply(block)

fun liElm(block: HTMLLIElement.() -> Unit) = (document.createElement("li") as HTMLLIElement).apply(block)

fun linkElm(block: HTMLLinkElement.() -> Unit) = (document.createElement("link") as HTMLLinkElement).apply(block)

fun mainElm(block: HTMLElement.() -> Unit) = (document.createElement("main")).apply(block)

fun mapElm(block: HTMLMapElement.() -> Unit) = (document.createElement("map") as HTMLMapElement).apply(block)

fun markElm(block: HTMLElement.() -> Unit) = (document.createElement("mark")).apply(block)

fun menuElm(block: HTMLMenuElement.() -> Unit) = (document.createElement("menu") as HTMLMenuElement).apply(block)

fun metaElm(block: HTMLMetaElement.() -> Unit) = (document.createElement("meta") as HTMLMetaElement).apply(block)

fun meterElm(block: HTMLMeterElement.() -> Unit) = (document.createElement("meter") as HTMLMeterElement).apply(block)

fun navElm(block: HTMLElement.() -> Unit) = (document.createElement("nav")).apply(block)

fun noscriptElm(block: HTMLElement.() -> Unit) = (document.createElement("noscript")).apply(block)

fun objectElm(block: HTMLObjectElement.() -> Unit) = (document.createElement("object") as HTMLObjectElement).apply(block)

fun olElm(block: HTMLOListElement.() -> Unit) = (document.createElement("ol") as HTMLOListElement).apply(block)

fun optgroupElm(block: HTMLOptGroupElement.() -> Unit) = (document.createElement("optgroup") as HTMLOptGroupElement).apply(block)

fun optionElm(block: HTMLOptionElement.() -> Unit) = (document.createElement("option") as HTMLOptionElement).apply(block)

fun outputElm(block: HTMLOutputElement.() -> Unit) = (document.createElement("output") as HTMLOutputElement).apply(block)

fun pElm(block: HTMLParagraphElement.() -> Unit) = (document.createElement("p") as HTMLParagraphElement).apply(block)

fun pictureElm(block: HTMLPictureElement.() -> Unit) = (document.createElement("picture") as HTMLPictureElement).apply(block)

fun preElm(block: HTMLPreElement.() -> Unit) = (document.createElement("pre") as HTMLPreElement).apply(block)

fun progressElm(block: HTMLProgressElement.() -> Unit) = (document.createElement("progress") as HTMLProgressElement).apply(block)

fun qElm(block: HTMLQuoteElement.() -> Unit) = (document.createElement("q") as HTMLQuoteElement).apply(block)

fun rpElm(block: HTMLElement.() -> Unit) = (document.createElement("rp")).apply(block)

fun rtElm(block: HTMLElement.() -> Unit) = (document.createElement("rt")).apply(block)

fun rubyElm(block: HTMLElement.() -> Unit) = (document.createElement("ruby")).apply(block)

fun sElm(block: HTMLElement.() -> Unit) = (document.createElement("s")).apply(block)

fun sampElm(block: HTMLElement.() -> Unit) = (document.createElement("samp")).apply(block)

fun scriptElm(block: HTMLScriptElement.() -> Unit) = (document.createElement("script") as HTMLScriptElement).apply(block)

fun sectionElm(block: HTMLElement.() -> Unit) = (document.createElement("section")).apply(block)

fun selectElm(block: HTMLSelectElement.() -> Unit) = (document.createElement("select") as HTMLSelectElement).apply(block)

fun slotElm(block: HTMLSlotElement.() -> Unit) = (document.createElement("slot") as HTMLSlotElement).apply(block)

fun smallElm(block: HTMLElement.() -> Unit) = (document.createElement("small")).apply(block)

fun sourceElm(block: HTMLSourceElement.() -> Unit) = (document.createElement("source") as HTMLSourceElement).apply(block)

fun spanElm(block: HTMLSpanElement.() -> Unit) = (document.createElement("span") as HTMLSpanElement).apply(block)

fun strongElm(block: HTMLElement.() -> Unit) = (document.createElement("strong")).apply(block)

fun styleElm(block: HTMLStyleElement.() -> Unit) = (document.createElement("style") as HTMLStyleElement).apply(block)

fun subElm(block: HTMLElement.() -> Unit) = (document.createElement("sub")).apply(block)

fun summaryElm(block: HTMLElement.() -> Unit) = (document.createElement("summary")).apply(block)

fun supElm(block: HTMLElement.() -> Unit) = (document.createElement("sup")).apply(block)

fun tableElm(block: HTMLTableElement.() -> Unit) = (document.createElement("table") as HTMLTableElement).apply(block)

fun tbodyElm(block: HTMLTableSectionElement.() -> Unit) = (document.createElement("tbody") as HTMLTableSectionElement).apply(block)

fun tdElm(block: HTMLTableCellElement.() -> Unit) = (document.createElement("td") as HTMLTableCellElement).apply(block)

fun templateElm(block: HTMLTemplateElement.() -> Unit) = (document.createElement("template") as HTMLTemplateElement).apply(block)

fun textareaElm(block: HTMLTextAreaElement.() -> Unit) = (document.createElement("textarea") as HTMLTextAreaElement).apply(block)

fun tfootElm(block: HTMLTableSectionElement.() -> Unit) = (document.createElement("tfoot") as HTMLTableSectionElement).apply(block)

fun thElm(block: HTMLTableCellElement.() -> Unit) = (document.createElement("th") as HTMLTableCellElement).apply(block)

fun theadElm(block: HTMLTableSectionElement.() -> Unit) = (document.createElement("thead") as HTMLTableSectionElement).apply(block)

fun timeElm(block: HTMLTimeElement.() -> Unit) = (document.createElement("time") as HTMLTimeElement).apply(block)

fun titleElm(block: HTMLTitleElement.() -> Unit) = (document.createElement("title") as HTMLTitleElement).apply(block)

fun trElm(block: HTMLTableRowElement.() -> Unit) = (document.createElement("tr") as HTMLTableRowElement).apply(block)

fun trackElm(block: HTMLTrackElement.() -> Unit) = (document.createElement("track") as HTMLTrackElement).apply(block)

fun uElm(block: HTMLElement.() -> Unit) = (document.createElement("u")).apply(block)

fun ulElm(block: HTMLUListElement.() -> Unit) = (document.createElement("ul") as HTMLUListElement).apply(block)

fun varElm(block: HTMLElement.() -> Unit) = (document.createElement("var")).apply(block)

fun videoElm(block: HTMLVideoElement.() -> Unit) = (document.createElement("video") as HTMLVideoElement).apply(block)

fun wbrElm(block: HTMLElement.() -> Unit) = (document.createElement("wbr")).apply(block)