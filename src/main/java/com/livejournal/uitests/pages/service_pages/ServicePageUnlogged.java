package com.livejournal.uitests.pages.service_pages;

import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.error_strip.ErrorStrip;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.unlogged.ShopPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.SupportMainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeaderUnlogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.LangSwitchMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.findMoreMenu.FindMoreMenuUnlogged;
import net.thucydides.core.annotations.StepGroup;

/**
 *
 * @author m.prytkova
 */
public class ServicePageUnlogged extends ServicePage {

    private FullscreenHeaderUnlogged fullscreenHeaderUnlogged;

    private ErrorStrip errorStrip;

    @Override
    public FullscreenHeaderUnlogged getFullscreenHeader() {
        return fullscreenHeaderUnlogged;
    }

    @Override
    public ErrorStrip getErrorStrip() {
        return errorStrip;
    }

    @StepGroup
    public MainPageUnlogged clickOnLogo() {
        return getFullscreenHeader().clickOnLogo();
    }

    @StepGroup
    public LJMagazinePageUnlogged clickOnLjMagazineMenuItem() {
        return getFullscreenHeader().clickOnLjMagazineMenuItem();
    }

    @StepGroup
    public FindMoreMenuUnlogged moveMouseOverInterestingMenuItem() {
        return getFullscreenHeader().moveMouseOverInterestingMenuItem();
    }

    @StepGroup
    public LoginForm clickOnLoginMenuItem() {
        return getFullscreenHeader().clickOnLoginMenuItem();
    }

    @StepGroup
    public ShopPageUnlogged clickOnShopMenuItem() {
        return getFullscreenHeader().clickOnShopMenuItem();
    }
    
    @StepGroup
    public SupportMainPageUnlogged clickOnHelpMenuItem() {
        return getFullscreenHeader().clickOnHelpMenuItem();
    }

    @StepGroup
    public LangSwitchMenu moveMouseOverLangSwitch() {
        return getFullscreenHeader().moveMouseOverLangSwitch();
    }

    @StepGroup
    public CreateAccountPage clicOnSignUpMenuItem() {
        return getFullscreenHeader().clicOnSignUpMenuItem();
    }

}
