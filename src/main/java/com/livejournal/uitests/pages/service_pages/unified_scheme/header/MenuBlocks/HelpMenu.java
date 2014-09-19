package com.livejournal.uitests.pages.service_pages.unified_scheme.header.MenuBlocks;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.search.SearchPage;
import com.livejournal.uitests.pages.service_pages.support_faq.AboutMainPage;
import com.livejournal.uitests.pages.service_pages.support_faq.DMCAPage;
import com.livejournal.uitests.pages.service_pages.support_faq.FaqMainPage;
import com.livejournal.uitests.pages.service_pages.support_faq.PrivacyRusPage;
import com.livejournal.uitests.pages.service_pages.support_faq.SupportMainPage;
import com.livejournal.uitests.pages.service_pages.support_faq.TosRusPage;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
@FindBy(css = ".s-nav-item-help .s-drop")
public class HelpMenu extends UIBlock {

    @FindBy(css = ".s-nav-item-mobile.s-nav-rootlink-support")
    private Link help;

    @FindBy(css = ".s-nav-item-about")
    private Link about;

    @FindBy(css = ".s-nav-item-faq")
    private Link faq;

    @FindBy(css = ".s-nav-item-legal")
    private Link tos;

    @FindBy(css = ".s-nav-item-privacy")
    private Link privacy;

    @FindBy(css = ".s-nav-item-dmca")
    private Link dmca;

    @FindBy(css = ".s-nav-item-search #SearchText")
    private TextField searchLine;

    @StepGroup
    public SupportMainPage clickOnHelp() {
        help.click();
        return on(SupportMainPage.class);
    }

    @StepGroup
    public AboutMainPage clickOnAbout() {
        about.click();
        return on(AboutMainPage.class);
    }

    @StepGroup
    public FaqMainPage clickOnFaq() {
        faq.click();
        return on(FaqMainPage.class);
    }

    @StepGroup
    public TosRusPage clickOnTos() {
        tos.click();
        return on(TosRusPage.class);
    }

    @StepGroup
    public PrivacyRusPage clickOnPrivacy() {
        privacy.click();
        return on(PrivacyRusPage.class);
    }

    @StepGroup
    public DMCAPage clickOnDmca() {
        dmca.click();
        return on(DMCAPage.class);
    }

    @StepGroup
    public SearchPage search(String text) {
        searchLine.enter(text);
        Actions actions = new Actions(this.getDriver());
        actions.keyDown(Keys.ENTER).build().perform();
        return on(SearchPage.class);
    }
}