package com.livejournal.uitests.pages;

import com.livejournal.uisteps.thucydides.Root;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.databases_data.DatabasesData;
import junit.framework.Assert;

/**
 *
 * @author ASolyankin
 */
@Root
public class LJPage extends Page {

    public LJPage() {
        getUrl().setUser("ljdev9c")
                .setPassword("Ivie6oovai");
    }

    public <T extends Object> T elem(T element) {
        if (element == null) {
            Assert.fail("Cannot get element!");
        }
        return element;
    }

    public DatabasesData getDBDate() {
        return new DatabasesData();
    }

    public DefaultSettings setDefault() {
        return onOpened(DefaultSettings.class);
    }

    public Style style() {
        return onOpened(Style.class);
    }

    public Region region() {
        return onOpened(Region.class);
    }
    

}
