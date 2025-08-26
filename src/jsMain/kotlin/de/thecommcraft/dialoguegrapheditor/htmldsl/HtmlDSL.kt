package de.thecommcraft.dialoguegrapheditor.htmldsl

import web.html.*
import web.dom.document
import web.components.HTMLSlotElement
import web.components.HTMLTemplateElement
import web.cssom.ClassName

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



fun HTMLElement.aElmAdd(block: HTMLAnchorElement.() -> Unit) = appendChild((document.createElement("a") as HTMLAnchorElement).apply(block))

fun HTMLElement.abbrElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("abbr")).apply(block))

fun HTMLElement.addressElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("address")).apply(block))

fun HTMLElement.areaElmAdd(block: HTMLAreaElement.() -> Unit) = appendChild((document.createElement("area") as HTMLAreaElement).apply(block))

fun HTMLElement.articleElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("article")).apply(block))

fun HTMLElement.asideElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("aside")).apply(block))

fun HTMLElement.audioElmAdd(block: HTMLAudioElement.() -> Unit) = appendChild((document.createElement("audio") as HTMLAudioElement).apply(block))

fun HTMLElement.bElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("b")).apply(block))

fun HTMLElement.baseElmAdd(block: HTMLBaseElement.() -> Unit) = appendChild((document.createElement("base") as HTMLBaseElement).apply(block))

fun HTMLElement.bdiElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("bdi")).apply(block))

fun HTMLElement.bdoElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("bdo")).apply(block))

fun HTMLElement.blockquoteElmAdd(block: HTMLQuoteElement.() -> Unit) = appendChild((document.createElement("blockquote") as HTMLQuoteElement).apply(block))

fun HTMLElement.bodyElmAdd(block: HTMLBodyElement.() -> Unit) = appendChild((document.createElement("body") as HTMLBodyElement).apply(block))

fun HTMLElement.brElmAdd(block: HTMLBRElement.() -> Unit) = appendChild((document.createElement("br") as HTMLBRElement).apply(block))

fun HTMLElement.buttonElmAdd(block: HTMLButtonElement.() -> Unit) = appendChild((document.createElement("button") as HTMLButtonElement).apply(block))

fun HTMLElement.canvasElmAdd(block: HTMLCanvasElement.() -> Unit) = appendChild((document.createElement("canvas") as HTMLCanvasElement).apply(block))

fun HTMLElement.captionElmAdd(block: HTMLTableCaptionElement.() -> Unit) = appendChild((document.createElement("caption") as HTMLTableCaptionElement).apply(block))

fun HTMLElement.citeElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("cite")).apply(block))

fun HTMLElement.codeElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("code")).apply(block))

fun HTMLElement.colElmAdd(block: HTMLTableColElement.() -> Unit) = appendChild((document.createElement("col") as HTMLTableColElement).apply(block))

fun HTMLElement.colgroupElmAdd(block: HTMLTableColElement.() -> Unit) = appendChild((document.createElement("colgroup") as HTMLTableColElement).apply(block))

fun HTMLElement.dataElmAdd(block: HTMLDataElement.() -> Unit) = appendChild((document.createElement("data") as HTMLDataElement).apply(block))

fun HTMLElement.datalistElmAdd(block: HTMLDataListElement.() -> Unit) = appendChild((document.createElement("datalist") as HTMLDataListElement).apply(block))

fun HTMLElement.ddElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("dd")).apply(block))

fun HTMLElement.delElmAdd(block: HTMLModElement.() -> Unit) = appendChild((document.createElement("del") as HTMLModElement).apply(block))

fun HTMLElement.detailsElmAdd(block: HTMLDetailsElement.() -> Unit) = appendChild((document.createElement("details") as HTMLDetailsElement).apply(block))

fun HTMLElement.dfnElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("dfn")).apply(block))

fun HTMLElement.dialogElmAdd(block: HTMLDialogElement.() -> Unit) = appendChild((document.createElement("dialog") as HTMLDialogElement).apply(block))

fun HTMLElement.divElmAdd(block: HTMLDivElement.() -> Unit) = appendChild((document.createElement("div") as HTMLDivElement).apply(block))

fun HTMLElement.dlElmAdd(block: HTMLDListElement.() -> Unit) = appendChild((document.createElement("dl") as HTMLDListElement).apply(block))

fun HTMLElement.dtElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("dt")).apply(block))

fun HTMLElement.emElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("em")).apply(block))

fun HTMLElement.embedElmAdd(block: HTMLEmbedElement.() -> Unit) = appendChild((document.createElement("embed") as HTMLEmbedElement).apply(block))

fun HTMLElement.fieldsetElmAdd(block: HTMLFieldSetElement.() -> Unit) = appendChild((document.createElement("fieldset") as HTMLFieldSetElement).apply(block))

fun HTMLElement.figcaptionElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("figcaption")).apply(block))

fun HTMLElement.figureElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("figure")).apply(block))

fun HTMLElement.footerElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("footer")).apply(block))

fun HTMLElement.formElmAdd(block: HTMLFormElement.() -> Unit) = appendChild((document.createElement("form") as HTMLFormElement).apply(block))

fun HTMLElement.h1ElmAdd(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h1") as HTMLHeadingElement).apply(block))

fun HTMLElement.h2ElmAdd(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h2") as HTMLHeadingElement).apply(block))

fun HTMLElement.h3ElmAdd(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h3") as HTMLHeadingElement).apply(block))

fun HTMLElement.h4ElmAdd(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h4") as HTMLHeadingElement).apply(block))

fun HTMLElement.h5ElmAdd(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h5") as HTMLHeadingElement).apply(block))

fun HTMLElement.h6ElmAdd(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h6") as HTMLHeadingElement).apply(block))

fun HTMLElement.headElmAdd(block: HTMLHeadElement.() -> Unit) = appendChild((document.createElement("head") as HTMLHeadElement).apply(block))

fun HTMLElement.headerElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("header")).apply(block))

fun HTMLElement.hgroupElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("hgroup")).apply(block))

fun HTMLElement.hrElmAdd(block: HTMLHRElement.() -> Unit) = appendChild((document.createElement("hr") as HTMLHRElement).apply(block))

fun HTMLElement.htmlElmAdd(block: HTMLHtmlElement.() -> Unit) = appendChild((document.createElement("html") as HTMLHtmlElement).apply(block))

fun HTMLElement.iElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("i")).apply(block))

fun HTMLElement.iframeElmAdd(block: HTMLIFrameElement.() -> Unit) = appendChild((document.createElement("iframe") as HTMLIFrameElement).apply(block))

fun HTMLElement.imgElmAdd(block: HTMLImageElement.() -> Unit) = appendChild((document.createElement("img") as HTMLImageElement).apply(block))

fun HTMLElement.inputElmAdd(block: HTMLInputElement.() -> Unit) = appendChild((document.createElement("input") as HTMLInputElement).apply(block))

fun HTMLElement.insElmAdd(block: HTMLModElement.() -> Unit) = appendChild((document.createElement("ins") as HTMLModElement).apply(block))

fun HTMLElement.kbdElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("kbd")).apply(block))

fun HTMLElement.labelElmAdd(block: HTMLLabelElement.() -> Unit) = appendChild((document.createElement("label") as HTMLLabelElement).apply(block))

fun HTMLElement.legendElmAdd(block: HTMLLegendElement.() -> Unit) = appendChild((document.createElement("legend") as HTMLLegendElement).apply(block))

fun HTMLElement.liElmAdd(block: HTMLLIElement.() -> Unit) = appendChild((document.createElement("li") as HTMLLIElement).apply(block))

fun HTMLElement.linkElmAdd(block: HTMLLinkElement.() -> Unit) = appendChild((document.createElement("link") as HTMLLinkElement).apply(block))

fun HTMLElement.mainElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("main")).apply(block))

fun HTMLElement.mapElmAdd(block: HTMLMapElement.() -> Unit) = appendChild((document.createElement("map") as HTMLMapElement).apply(block))

fun HTMLElement.markElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("mark")).apply(block))

fun HTMLElement.menuElmAdd(block: HTMLMenuElement.() -> Unit) = appendChild((document.createElement("menu") as HTMLMenuElement).apply(block))

fun HTMLElement.metaElmAdd(block: HTMLMetaElement.() -> Unit) = appendChild((document.createElement("meta") as HTMLMetaElement).apply(block))

fun HTMLElement.meterElmAdd(block: HTMLMeterElement.() -> Unit) = appendChild((document.createElement("meter") as HTMLMeterElement).apply(block))

fun HTMLElement.navElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("nav")).apply(block))

fun HTMLElement.noscriptElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("noscript")).apply(block))

fun HTMLElement.objectElmAdd(block: HTMLObjectElement.() -> Unit) = appendChild((document.createElement("object") as HTMLObjectElement).apply(block))

fun HTMLElement.olElmAdd(block: HTMLOListElement.() -> Unit) = appendChild((document.createElement("ol") as HTMLOListElement).apply(block))

fun HTMLElement.optgroupElmAdd(block: HTMLOptGroupElement.() -> Unit) = appendChild((document.createElement("optgroup") as HTMLOptGroupElement).apply(block))

fun HTMLElement.optionElmAdd(block: HTMLOptionElement.() -> Unit) = appendChild((document.createElement("option") as HTMLOptionElement).apply(block))

fun HTMLElement.outputElmAdd(block: HTMLOutputElement.() -> Unit) = appendChild((document.createElement("output") as HTMLOutputElement).apply(block))

fun HTMLElement.pElmAdd(block: HTMLParagraphElement.() -> Unit) = appendChild((document.createElement("p") as HTMLParagraphElement).apply(block))

fun HTMLElement.pictureElmAdd(block: HTMLPictureElement.() -> Unit) = appendChild((document.createElement("picture") as HTMLPictureElement).apply(block))

fun HTMLElement.preElmAdd(block: HTMLPreElement.() -> Unit) = appendChild((document.createElement("pre") as HTMLPreElement).apply(block))

fun HTMLElement.progressElmAdd(block: HTMLProgressElement.() -> Unit) = appendChild((document.createElement("progress") as HTMLProgressElement).apply(block))

fun HTMLElement.qElmAdd(block: HTMLQuoteElement.() -> Unit) = appendChild((document.createElement("q") as HTMLQuoteElement).apply(block))

fun HTMLElement.rpElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("rp")).apply(block))

fun HTMLElement.rtElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("rt")).apply(block))

fun HTMLElement.rubyElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("ruby")).apply(block))

fun HTMLElement.sElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("s")).apply(block))

fun HTMLElement.sampElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("samp")).apply(block))

fun HTMLElement.scriptElmAdd(block: HTMLScriptElement.() -> Unit) = appendChild((document.createElement("script") as HTMLScriptElement).apply(block))

fun HTMLElement.sectionElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("section")).apply(block))

fun HTMLElement.selectElmAdd(block: HTMLSelectElement.() -> Unit) = appendChild((document.createElement("select") as HTMLSelectElement).apply(block))

fun HTMLElement.slotElmAdd(block: HTMLSlotElement.() -> Unit) = appendChild((document.createElement("slot") as HTMLSlotElement).apply(block))

fun HTMLElement.smallElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("small")).apply(block))

fun HTMLElement.sourceElmAdd(block: HTMLSourceElement.() -> Unit) = appendChild((document.createElement("source") as HTMLSourceElement).apply(block))

fun HTMLElement.spanElmAdd(block: HTMLSpanElement.() -> Unit) = appendChild((document.createElement("span") as HTMLSpanElement).apply(block))

fun HTMLElement.strongElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("strong")).apply(block))

fun HTMLElement.styleElmAdd(block: HTMLStyleElement.() -> Unit) = appendChild((document.createElement("style") as HTMLStyleElement).apply(block))

fun HTMLElement.subElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("sub")).apply(block))

fun HTMLElement.summaryElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("summary")).apply(block))

fun HTMLElement.supElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("sup")).apply(block))

fun HTMLElement.tableElmAdd(block: HTMLTableElement.() -> Unit) = appendChild((document.createElement("table") as HTMLTableElement).apply(block))

fun HTMLElement.tbodyElmAdd(block: HTMLTableSectionElement.() -> Unit) = appendChild((document.createElement("tbody") as HTMLTableSectionElement).apply(block))

fun HTMLElement.tdElmAdd(block: HTMLTableCellElement.() -> Unit) = appendChild((document.createElement("td") as HTMLTableCellElement).apply(block))

fun HTMLElement.templateElmAdd(block: HTMLTemplateElement.() -> Unit) = appendChild((document.createElement("template") as HTMLTemplateElement).apply(block))

fun HTMLElement.textareaElmAdd(block: HTMLTextAreaElement.() -> Unit) = appendChild((document.createElement("textarea") as HTMLTextAreaElement).apply(block))

fun HTMLElement.tfootElmAdd(block: HTMLTableSectionElement.() -> Unit) = appendChild((document.createElement("tfoot") as HTMLTableSectionElement).apply(block))

fun HTMLElement.thElmAdd(block: HTMLTableCellElement.() -> Unit) = appendChild((document.createElement("th") as HTMLTableCellElement).apply(block))

fun HTMLElement.theadElmAdd(block: HTMLTableSectionElement.() -> Unit) = appendChild((document.createElement("thead") as HTMLTableSectionElement).apply(block))

fun HTMLElement.timeElmAdd(block: HTMLTimeElement.() -> Unit) = appendChild((document.createElement("time") as HTMLTimeElement).apply(block))

fun HTMLElement.titleElmAdd(block: HTMLTitleElement.() -> Unit) = appendChild((document.createElement("title") as HTMLTitleElement).apply(block))

fun HTMLElement.trElmAdd(block: HTMLTableRowElement.() -> Unit) = appendChild((document.createElement("tr") as HTMLTableRowElement).apply(block))

fun HTMLElement.trackElmAdd(block: HTMLTrackElement.() -> Unit) = appendChild((document.createElement("track") as HTMLTrackElement).apply(block))

fun HTMLElement.uElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("u")).apply(block))

fun HTMLElement.ulElmAdd(block: HTMLUListElement.() -> Unit) = appendChild((document.createElement("ul") as HTMLUListElement).apply(block))

fun HTMLElement.varElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("var")).apply(block))

fun HTMLElement.videoElmAdd(block: HTMLVideoElement.() -> Unit) = appendChild((document.createElement("video") as HTMLVideoElement).apply(block))

fun HTMLElement.wbrElmAdd(block: HTMLElement.() -> Unit) = appendChild((document.createElement("wbr")).apply(block))



fun HTMLElement.clazz(name: String) = classList.add(ClassName(name))