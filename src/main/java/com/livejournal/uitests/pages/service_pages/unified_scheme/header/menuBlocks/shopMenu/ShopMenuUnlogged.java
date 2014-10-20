package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.shopMenu;

import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.unlogged.PaidAccountPageUnlogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.unlogged.PromoPageUnlogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.unlogged.ShopPageUnlogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */@Block(
        @FindBy(css = ShopMenu.CSS))
public class ShopMenuUnlogged  extends ShopMenu{


    @StepGroup
    public ShopPageUnlogged clickOnShop() {
        shop.click();
        return onOpened(ShopPageUnlogged.class);
    }

    @StepGroup
    public PaidAccountPageUnlogged clickOnPaid() {
        paid.click();
        return onOpened(PaidAccountPageUnlogged.class);
    }

    @StepGroup
    public PromoPageUnlogged clickOnPromo() {
        promo.click();
        return onOpened(PromoPageUnlogged.class);
    }

    @StepGroup
    public LoginPageUnlogged clickOnTokensLink() {
        tokens.click();
        return onOpened(LoginPageUnlogged.class);
    }

}
