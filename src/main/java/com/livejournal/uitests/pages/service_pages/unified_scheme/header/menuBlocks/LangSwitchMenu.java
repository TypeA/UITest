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

    @FindBy(xpath = ".//*[@data-lang='en_LJ'][2]")
    public Link langEn;

    @FindBy(xpath = ".//*[@data-lang='ru'][2]")
    public Link langRu;

    @FindBy(xpath = ".//*[@data-lang='uk'][2]")
    public Link langUk;

    @FindBy(xpath = ".//*[@data-lang='fr'][2]")
    public Link langFr;

    @FindBy(xpath = ".//*[@data-lang='pt'][2]")
    public Link langPt;

    @FindBy(xpath = ".//*[@data-lang='es'][2]")
    public Link langEs;

    @FindBy(xpath = ".//*[@data-lang='de'][2]")
    public Link langDe;

    @FindBy(xpath = ".//*[@data-lang='it'][2]")
    public Link langIt;

    @FindBy(xpath = ".//*[@data-lang='be'][2]")
    public Link langBe;

    public Class<ServicePageUnlogged> switchLang(String language) {
        switch (language.toUpperCase()) {
            case "EN":
                langEn.click();
                return(ServicePageUnlogged.class);
            case "RU":
                langRu.click();
                return(ServicePageUnlogged.class);
            case "UK":
                langUk.click();
                return(ServicePageUnlogged.class);
            case "FR":
                langFr.click();
                return(ServicePageUnlogged.class);
            case "PT":
                langPt.click();
                return(ServicePageUnlogged.class);
            case "ES":
                langEs.click();
                return(ServicePageUnlogged.class);
            case "DE":
                langDe.click();
                return(ServicePageUnlogged.class);
            case "IT":
                langIt.click();
                return(ServicePageUnlogged.class);
            case "BE":
                langBe.click();
                return(ServicePageUnlogged.class);
        }
        return(ServicePageUnlogged.class);
    }

}
