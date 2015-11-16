package com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageGroupsPage;
import java.util.List;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".l-flatslide-menu-items"))
public class FiltersBlock extends UIBlock {

    @FindBy(css = ".l-flatslide-menu-item-settings a[href*='/friends/editgroups.bml']")
    private Link manageFilters;

    public ManageGroupsPage openManageFilters() {
        manageFilters.click();
        return onOpened(ManageGroupsPage.class);
    }

    public FriendsFeedLogged openDefaultFilter(String filter) {
        startScript("jQuery(\"li[data-filter*='" + filter + "']:not([style='display: none;']) a\")[0].click()");
        return onOpened(FriendsFeedLogged.class);
    }

        @StepGroup
    public String getGroups() {
        List<WebElement> list = getDriver()
                .findElements(By.xpath("//ul[@class='l-flatslide-menu-items l-flatslide-menu-items-active']//li//a"));
        StringBuilder filresFeed = new StringBuilder();
        for (WebElement list1 : list) {
            String filter = list1.getAttribute("text");
            filresFeed.append(filter);
        }
        return filresFeed.toString();
    }
}
