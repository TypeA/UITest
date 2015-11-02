package com.livejournal.uitests.pages.service_pages.friends_feed_pages.filters;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageGroupsPage;
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
}
