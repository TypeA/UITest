package com.livejournal.uitests.pages.service_pages.lj_magazine_page;

import net.thucydides.core.annotations.DefaultUrl;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/magazine")
public class LJMagazinePageUnlogged extends ServicePageUnlogged {

    public LJMagazinePageUnlogged openRandomPost() {
        Integer rnd = (int) (Math.random() * 19);
        startScript("jQuery('.entryunit__title a')[" + rnd + "].click()");
        return this;
    }
}
