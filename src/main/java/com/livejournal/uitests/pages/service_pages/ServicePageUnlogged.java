package com.livejournal.uitests.pages.service_pages;

import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeaderUnlogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.LangSwitchMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.helpMenu.HelpMenuUnlogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.shopMenu.ShopMenuUnlogged;
import net.thucydides.core.annotations.StepGroup;

/**
 *
 * @author m.prytkova
 */
public class ServicePageUnlogged extends ServicePage {

    private FullscreenHeaderUnlogged fullscreenHeaderUnlogged;

    @Override
    public FullscreenHeaderUnlogged getFullscreenHeader() {
        return fullscreenHeaderUnlogged;
    }

    @StepGroup
    public MainPageUnlogged clickOnLogo() {
        return getFullscreenHeader().clickOnLogo();
    }

    @StepGroup
    public void clickOnLjMagazineMenuItem() {
        getFullscreenHeader().clickOnLjMagazineMenuItem();
    }

    @StepGroup
    public LoginForm clickOnLoginMenuItem() {
        return getFullscreenHeader().clickOnLoginMenuItem();
    }

    @StepGroup
    public ShopMenuUnlogged moveMouseOverShopMenuItem() {
        return getFullscreenHeader().moveMouseOverShopMenuItem();
    }

    @StepGroup
    public HelpMenuUnlogged moveMouseOverHelpMenuItem() {
        return getFullscreenHeader().moveMouseOverHelpMenuItem();
    }

    @StepGroup
    public LangSwitchMenu moveMouseOverLangSwitch() {
        return getFullscreenHeader().moveMouseOverLangSwitch();
    }
}
