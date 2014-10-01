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
    public void clickOnShop() {
        shop.click();
        //return on(ShopPageUnlogged.class);
    }

    @StepGroup
    public void clickOnPaid() {
        paid.click();
        //return on(PaidAccountPageUnlogged.class);
    }

    @StepGroup
    public void clickOnPromo() {
        promo.click();
        //return on(PromoPageUnlogged.class);
    }

    @StepGroup
    public void clickOnTokensLink() {
        tokens.click();
        //return on(LoginPageUnlogged.class);
    }

}
