package com.livejournal.uitests.pages;

import com.livejournal.uisteps.thucydides.Root;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
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

    public void regionSwitch(String reg) {
        switch (reg) {
            case "cyr":
                addCookie("fake_ipclass", "russia");
                open(MainPageUnlogged.class);
                break;
            case "noncyr":
                addCookie("fake_ipclass", "US");
                open(MainPageUnlogged.class);
                break;
        }
    }
}
