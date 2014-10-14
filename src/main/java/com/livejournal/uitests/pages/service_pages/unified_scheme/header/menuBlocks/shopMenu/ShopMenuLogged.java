package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.shopMenu;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.service_pages.shop_pages.logged.OrderHistoryLoggedPage;
import com.livejournal.uitests.pages.service_pages.shop_pages.logged.PaidAccountPageLogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.logged.PromoPageLogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.logged.ShopPageLogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.logged.TokensPageLogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ShopMenu.CSS))
public class ShopMenuLogged extends ShopMenu {

    @FindBy(css = ".s-nav-item-paid-history a")
    public Link orderHistory;

    @StepGroup
    public void clickOnShop() {
        shop.click();
        //return on(ShopPageLogged.class);
    }

    @StepGroup
    public void clickOnPaid() {
        paid.click();
        //return on(PaidAccountPageLogged.class);
    }

    @StepGroup
    public void clickOnPromo() {
        promo.click();
        //return on(PromoPageLogged.class);
    }

    @StepGroup
    public void clickOnOrderHistory() {
        orderHistory.click();
        //return on(OrderHistoryLoggedPage.class);
    }

    @StepGroup
    public void clickOnTokensLink() {
        tokens.click();
        //return on(TokensPageLogged.class);
    }

}
