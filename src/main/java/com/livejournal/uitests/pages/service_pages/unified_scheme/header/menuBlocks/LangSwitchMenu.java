package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".s-nav-item-lang .s-nav-sub.s-drop"))
public class LangSwitchMenu extends UIBlock {

    @FindBy(css = ".s-header-sub-list__item[data-lang='en_LJ'] a")
    public Link langEn;

    @FindBy(css = ".s-header-sub-list__item[data-lang='ru'] a")
    public Link langRu;

    @FindBy(css = ".s-header-sub-list__item[data-lang='uk'] a")
    public Link langUk;

    @FindBy(css = ".s-header-sub-list__item[data-lang='fr'] a")
    public Link langFr;

    @FindBy(css = ".s-header-sub-list__item[data-lang='pt'] a")
    public Link langPt;

    @FindBy(css = ".s-header-sub-list__item[data-lang='es'] a")
    public Link langEs;

    @FindBy(css = ".s-header-sub-list__item[data-lang='de'] a")
    public Link langDe;

    @FindBy(css = ".s-header-sub-list__item[data-lang='it'] a")
    public Link langIt;

    @FindBy(css = ".s-header-sub-list__item[data-lang='be'] a")
    public Link langBe;

    public Class<ServicePageUnlogged> switchLang(String language) {
        Link lang = null;
        switch (language.toUpperCase()) {
            case "EN":
                lang = langEn;
                break;
            case "RU":
                lang = langRu;
                break;
            case "UK":
                lang = langUk;
                break;
            case "FR":
                lang = langFr;
                break;
            case "PT":
                lang = langPt;
                break;
            case "ES":
                lang = langEs;
                break;
            case "DE":
                lang = langDe;
                break;
            case "IT":
                lang = langIt;
                break;
            case "BE":
                lang = langBe;
                break;
        }
        lang.click();
        return(ServicePageUnlogged.class);
    }

}
