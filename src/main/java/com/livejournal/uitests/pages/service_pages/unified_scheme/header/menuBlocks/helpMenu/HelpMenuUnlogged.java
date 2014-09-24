package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.helpMenu;

import com.livejournal.uitests.pages.service_pages.search.SearchPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.AboutMainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.DMCAPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.FaqMainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.PrivacyRusPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.SupportMainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.TosRusPageUnlogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = HelpMenu.CSS))
public class HelpMenuUnlogged extends HelpMenu {

    @StepGroup
    public SupportMainPageUnlogged clickOnHelp() {
        help.click();
        return on(SupportMainPageUnlogged.class);
    }

    @StepGroup
    public AboutMainPageUnlogged clickOnAbout() {
        about.click();
        return on(AboutMainPageUnlogged.class);
    }

    @StepGroup
    public FaqMainPageUnlogged clickOnFaq() {
        faq.click();
        return on(FaqMainPageUnlogged.class);
    }

    @StepGroup
    public TosRusPageUnlogged clickOnTos() {
        tos.click();
        return on(TosRusPageUnlogged.class);
    }

    @StepGroup
    public PrivacyRusPageUnlogged clickOnPrivacy() {
        privacy.click();
        return on(PrivacyRusPageUnlogged.class);
    }

    @StepGroup
    public DMCAPageUnlogged clickOnDmca() {
        dmca.click();
        return on(DMCAPageUnlogged.class);
    }

    @StepGroup
    public SearchPageUnlogged search(String text) {
        searchLine.enter(text);
        Actions actions = new Actions(this.getDriver());
        actions.keyDown(Keys.ENTER).build().perform();
        return on(SearchPageUnlogged.class);

    }
}
