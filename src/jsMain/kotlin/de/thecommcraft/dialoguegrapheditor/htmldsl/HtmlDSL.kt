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



fun HTMLElement.aElm(block: HTMLAnchorElement.() -> Unit) = appendChild((document.createElement("a") as HTMLAnchorElement).apply(block))

fun HTMLElement.abbrElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("abbr")).apply(block))

fun HTMLElement.addressElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("address")).apply(block))

fun HTMLElement.areaElm(block: HTMLAreaElement.() -> Unit) = appendChild((document.createElement("area") as HTMLAreaElement).apply(block))

fun HTMLElement.articleElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("article")).apply(block))

fun HTMLElement.asideElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("aside")).apply(block))

fun HTMLElement.audioElm(block: HTMLAudioElement.() -> Unit) = appendChild((document.createElement("audio") as HTMLAudioElement).apply(block))

fun HTMLElement.bElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("b")).apply(block))

fun HTMLElement.baseElm(block: HTMLBaseElement.() -> Unit) = appendChild((document.createElement("base") as HTMLBaseElement).apply(block))

fun HTMLElement.bdiElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("bdi")).apply(block))

fun HTMLElement.bdoElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("bdo")).apply(block))

fun HTMLElement.blockquoteElm(block: HTMLQuoteElement.() -> Unit) = appendChild((document.createElement("blockquote") as HTMLQuoteElement).apply(block))

fun HTMLElement.bodyElm(block: HTMLBodyElement.() -> Unit) = appendChild((document.createElement("body") as HTMLBodyElement).apply(block))

fun HTMLElement.brElm(block: HTMLBRElement.() -> Unit) = appendChild((document.createElement("br") as HTMLBRElement).apply(block))

fun HTMLElement.buttonElm(block: HTMLButtonElement.() -> Unit) = appendChild((document.createElement("button") as HTMLButtonElement).apply(block))

fun HTMLElement.canvasElm(block: HTMLCanvasElement.() -> Unit) = appendChild((document.createElement("canvas") as HTMLCanvasElement).apply(block))

fun HTMLElement.captionElm(block: HTMLTableCaptionElement.() -> Unit) = appendChild((document.createElement("caption") as HTMLTableCaptionElement).apply(block))

fun HTMLElement.citeElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("cite")).apply(block))

fun HTMLElement.codeElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("code")).apply(block))

fun HTMLElement.colElm(block: HTMLTableColElement.() -> Unit) = appendChild((document.createElement("col") as HTMLTableColElement).apply(block))

fun HTMLElement.colgroupElm(block: HTMLTableColElement.() -> Unit) = appendChild((document.createElement("colgroup") as HTMLTableColElement).apply(block))

fun HTMLElement.dataElm(block: HTMLDataElement.() -> Unit) = appendChild((document.createElement("data") as HTMLDataElement).apply(block))

fun HTMLElement.datalistElm(block: HTMLDataListElement.() -> Unit) = appendChild((document.createElement("datalist") as HTMLDataListElement).apply(block))

fun HTMLElement.ddElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("dd")).apply(block))

fun HTMLElement.delElm(block: HTMLModElement.() -> Unit) = appendChild((document.createElement("del") as HTMLModElement).apply(block))

fun HTMLElement.detailsElm(block: HTMLDetailsElement.() -> Unit) = appendChild((document.createElement("details") as HTMLDetailsElement).apply(block))

fun HTMLElement.dfnElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("dfn")).apply(block))

fun HTMLElement.dialogElm(block: HTMLDialogElement.() -> Unit) = appendChild((document.createElement("dialog") as HTMLDialogElement).apply(block))

fun HTMLElement.divElm(block: HTMLDivElement.() -> Unit) = appendChild((document.createElement("div") as HTMLDivElement).apply(block))

fun HTMLElement.dlElm(block: HTMLDListElement.() -> Unit) = appendChild((document.createElement("dl") as HTMLDListElement).apply(block))

fun HTMLElement.dtElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("dt")).apply(block))

fun HTMLElement.emElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("em")).apply(block))

fun HTMLElement.embedElm(block: HTMLEmbedElement.() -> Unit) = appendChild((document.createElement("embed") as HTMLEmbedElement).apply(block))

fun HTMLElement.fieldsetElm(block: HTMLFieldSetElement.() -> Unit) = appendChild((document.createElement("fieldset") as HTMLFieldSetElement).apply(block))

fun HTMLElement.figcaptionElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("figcaption")).apply(block))

fun HTMLElement.figureElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("figure")).apply(block))

fun HTMLElement.footerElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("footer")).apply(block))

fun HTMLElement.formElm(block: HTMLFormElement.() -> Unit) = appendChild((document.createElement("form") as HTMLFormElement).apply(block))

fun HTMLElement.h1Elm(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h1") as HTMLHeadingElement).apply(block))

fun HTMLElement.h2Elm(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h2") as HTMLHeadingElement).apply(block))

fun HTMLElement.h3Elm(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h3") as HTMLHeadingElement).apply(block))

fun HTMLElement.h4Elm(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h4") as HTMLHeadingElement).apply(block))

fun HTMLElement.h5Elm(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h5") as HTMLHeadingElement).apply(block))

fun HTMLElement.h6Elm(block: HTMLHeadingElement.() -> Unit) = appendChild((document.createElement("h6") as HTMLHeadingElement).apply(block))

fun HTMLElement.headElm(block: HTMLHeadElement.() -> Unit) = appendChild((document.createElement("head") as HTMLHeadElement).apply(block))

fun HTMLElement.headerElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("header")).apply(block))

fun HTMLElement.hgroupElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("hgroup")).apply(block))

fun HTMLElement.hrElm(block: HTMLHRElement.() -> Unit) = appendChild((document.createElement("hr") as HTMLHRElement).apply(block))

fun HTMLElement.htmlElm(block: HTMLHtmlElement.() -> Unit) = appendChild((document.createElement("html") as HTMLHtmlElement).apply(block))

fun HTMLElement.iElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("i")).apply(block))

fun HTMLElement.iframeElm(block: HTMLIFrameElement.() -> Unit) = appendChild((document.createElement("iframe") as HTMLIFrameElement).apply(block))

fun HTMLElement.imgElm(block: HTMLImageElement.() -> Unit) = appendChild((document.createElement("img") as HTMLImageElement).apply(block))

fun HTMLElement.inputElm(block: HTMLInputElement.() -> Unit) = appendChild((document.createElement("input") as HTMLInputElement).apply(block))

fun HTMLElement.insElm(block: HTMLModElement.() -> Unit) = appendChild((document.createElement("ins") as HTMLModElement).apply(block))

fun HTMLElement.kbdElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("kbd")).apply(block))

fun HTMLElement.labelElm(block: HTMLLabelElement.() -> Unit) = appendChild((document.createElement("label") as HTMLLabelElement).apply(block))

fun HTMLElement.legendElm(block: HTMLLegendElement.() -> Unit) = appendChild((document.createElement("legend") as HTMLLegendElement).apply(block))

fun HTMLElement.liElm(block: HTMLLIElement.() -> Unit) = appendChild((document.createElement("li") as HTMLLIElement).apply(block))

fun HTMLElement.linkElm(block: HTMLLinkElement.() -> Unit) = appendChild((document.createElement("link") as HTMLLinkElement).apply(block))

fun HTMLElement.mainElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("main")).apply(block))

fun HTMLElement.mapElm(block: HTMLMapElement.() -> Unit) = appendChild((document.createElement("map") as HTMLMapElement).apply(block))

fun HTMLElement.markElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("mark")).apply(block))

fun HTMLElement.menuElm(block: HTMLMenuElement.() -> Unit) = appendChild((document.createElement("menu") as HTMLMenuElement).apply(block))

fun HTMLElement.metaElm(block: HTMLMetaElement.() -> Unit) = appendChild((document.createElement("meta") as HTMLMetaElement).apply(block))

fun HTMLElement.meterElm(block: HTMLMeterElement.() -> Unit) = appendChild((document.createElement("meter") as HTMLMeterElement).apply(block))

fun HTMLElement.navElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("nav")).apply(block))

fun HTMLElement.noscriptElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("noscript")).apply(block))

fun HTMLElement.objectElm(block: HTMLObjectElement.() -> Unit) = appendChild((document.createElement("object") as HTMLObjectElement).apply(block))

fun HTMLElement.olElm(block: HTMLOListElement.() -> Unit) = appendChild((document.createElement("ol") as HTMLOListElement).apply(block))

fun HTMLElement.optgroupElm(block: HTMLOptGroupElement.() -> Unit) = appendChild((document.createElement("optgroup") as HTMLOptGroupElement).apply(block))

fun HTMLElement.optionElm(block: HTMLOptionElement.() -> Unit) = appendChild((document.createElement("option") as HTMLOptionElement).apply(block))

fun HTMLElement.outputElm(block: HTMLOutputElement.() -> Unit) = appendChild((document.createElement("output") as HTMLOutputElement).apply(block))

fun HTMLElement.pElm(block: HTMLParagraphElement.() -> Unit) = appendChild((document.createElement("p") as HTMLParagraphElement).apply(block))

fun HTMLElement.pictureElm(block: HTMLPictureElement.() -> Unit) = appendChild((document.createElement("picture") as HTMLPictureElement).apply(block))

fun HTMLElement.preElm(block: HTMLPreElement.() -> Unit) = appendChild((document.createElement("pre") as HTMLPreElement).apply(block))

fun HTMLElement.progressElm(block: HTMLProgressElement.() -> Unit) = appendChild((document.createElement("progress") as HTMLProgressElement).apply(block))

fun HTMLElement.qElm(block: HTMLQuoteElement.() -> Unit) = appendChild((document.createElement("q") as HTMLQuoteElement).apply(block))

fun HTMLElement.rpElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("rp")).apply(block))

fun HTMLElement.rtElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("rt")).apply(block))

fun HTMLElement.rubyElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("ruby")).apply(block))

fun HTMLElement.sElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("s")).apply(block))

fun HTMLElement.sampElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("samp")).apply(block))

fun HTMLElement.scriptElm(block: HTMLScriptElement.() -> Unit) = appendChild((document.createElement("script") as HTMLScriptElement).apply(block))

fun HTMLElement.sectionElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("section")).apply(block))

fun HTMLElement.selectElm(block: HTMLSelectElement.() -> Unit) = appendChild((document.createElement("select") as HTMLSelectElement).apply(block))

fun HTMLElement.slotElm(block: HTMLSlotElement.() -> Unit) = appendChild((document.createElement("slot") as HTMLSlotElement).apply(block))

fun HTMLElement.smallElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("small")).apply(block))

fun HTMLElement.sourceElm(block: HTMLSourceElement.() -> Unit) = appendChild((document.createElement("source") as HTMLSourceElement).apply(block))

fun HTMLElement.spanElm(block: HTMLSpanElement.() -> Unit) = appendChild((document.createElement("span") as HTMLSpanElement).apply(block))

fun HTMLElement.strongElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("strong")).apply(block))

fun HTMLElement.styleElm(block: HTMLStyleElement.() -> Unit) = appendChild((document.createElement("style") as HTMLStyleElement).apply(block))

fun HTMLElement.subElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("sub")).apply(block))

fun HTMLElement.summaryElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("summary")).apply(block))

fun HTMLElement.supElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("sup")).apply(block))

fun HTMLElement.tableElm(block: HTMLTableElement.() -> Unit) = appendChild((document.createElement("table") as HTMLTableElement).apply(block))

fun HTMLElement.tbodyElm(block: HTMLTableSectionElement.() -> Unit) = appendChild((document.createElement("tbody") as HTMLTableSectionElement).apply(block))

fun HTMLElement.tdElm(block: HTMLTableCellElement.() -> Unit) = appendChild((document.createElement("td") as HTMLTableCellElement).apply(block))

fun HTMLElement.templateElm(block: HTMLTemplateElement.() -> Unit) = appendChild((document.createElement("template") as HTMLTemplateElement).apply(block))

fun HTMLElement.textareaElm(block: HTMLTextAreaElement.() -> Unit) = appendChild((document.createElement("textarea") as HTMLTextAreaElement).apply(block))

fun HTMLElement.tfootElm(block: HTMLTableSectionElement.() -> Unit) = appendChild((document.createElement("tfoot") as HTMLTableSectionElement).apply(block))

fun HTMLElement.thElm(block: HTMLTableCellElement.() -> Unit) = appendChild((document.createElement("th") as HTMLTableCellElement).apply(block))

fun HTMLElement.theadElm(block: HTMLTableSectionElement.() -> Unit) = appendChild((document.createElement("thead") as HTMLTableSectionElement).apply(block))

fun HTMLElement.timeElm(block: HTMLTimeElement.() -> Unit) = appendChild((document.createElement("time") as HTMLTimeElement).apply(block))

fun HTMLElement.titleElm(block: HTMLTitleElement.() -> Unit) = appendChild((document.createElement("title") as HTMLTitleElement).apply(block))

fun HTMLElement.trElm(block: HTMLTableRowElement.() -> Unit) = appendChild((document.createElement("tr") as HTMLTableRowElement).apply(block))

fun HTMLElement.trackElm(block: HTMLTrackElement.() -> Unit) = appendChild((document.createElement("track") as HTMLTrackElement).apply(block))

fun HTMLElement.uElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("u")).apply(block))

fun HTMLElement.ulElm(block: HTMLUListElement.() -> Unit) = appendChild((document.createElement("ul") as HTMLUListElement).apply(block))

fun HTMLElement.varElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("var")).apply(block))

fun HTMLElement.videoElm(block: HTMLVideoElement.() -> Unit) = appendChild((document.createElement("video") as HTMLVideoElement).apply(block))

fun HTMLElement.wbrElm(block: HTMLElement.() -> Unit) = appendChild((document.createElement("wbr")).apply(block))