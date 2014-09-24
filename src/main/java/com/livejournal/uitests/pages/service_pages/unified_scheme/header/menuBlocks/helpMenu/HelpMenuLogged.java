package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.helpMenu;

import com.livejournal.uitests.pages.service_pages.search.SearchPageLogged;
import com.livejournal.uitests.pages.service_pages.support_faq.logged.AboutMainPageLogged;
import com.livejournal.uitests.pages.service_pages.support_faq.logged.DMCAPageLogged;
import com.livejournal.uitests.pages.service_pages.support_faq.logged.FaqMainPageLogged;
import com.livejournal.uitests.pages.service_pages.support_faq.logged.PrivacyRusPageLogged;
import com.livejournal.uitests.pages.service_pages.support_faq.logged.SupportMainPageLogged;
import com.livejournal.uitests.pages.service_pages.support_faq.logged.TosRusPageLogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */@Block(
        @FindBy(css = HelpMenu.CSS))
public class HelpMenuLogged extends HelpMenu {
     
    @StepGroup
    public SupportMainPageLogged clickOnHelp() {
        help.click();
        return on(SupportMainPageLogged.class);
    }

    @StepGroup
    public AboutMainPageLogged clickOnAbout() {
        about.click();
        return on(AboutMainPageLogged.class);
    }

    @StepGroup
    public FaqMainPageLogged clickOnFaq() {
        faq.click();
        return on(FaqMainPageLogged.class);
    }

    @StepGroup
    public TosRusPageLogged clickOnTos() {
        tos.click();
        return on(TosRusPageLogged.class);
    }

    @StepGroup
    public PrivacyRusPageLogged clickOnPrivacy() {
        privacy.click();
        return on(PrivacyRusPageLogged.class);
    }

    @StepGroup
    public DMCAPageLogged clickOnDmca() {
        dmca.click();
        return on(DMCAPageLogged.class);
    }

    @StepGroup
    public SearchPageLogged search(String text) {
        searchLine.enter(text);
        Actions actions = new Actions(this.getDriver());
        actions.keyDown(Keys.ENTER).build().perform();
        return on(SearchPageLogged.class);

    }
    
}
