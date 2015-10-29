package com.livejournal.uitests.pages.service_pages.lj_magazine_page;

import net.thucydides.core.annotations.DefaultUrl;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import net.thucydides.core.annotations.StepGroup;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/magazine")
public class LJMagazinePageUnlogged extends ServicePageUnlogged {

    @StepGroup
    public LJMagazinePageUnlogged openRandomPost(String authorOfPost) {
        boolean flag = true;
        int page = 1;
        while (flag) {
            try {
                if (authorOfPost.equals("ljEditor")) {
                    startScript("jQuery(\"a.i-ljuser-username:contains('Журнал ЖЖ')\").parents('.entryunit').find('.entryunit__head a')[0].click()");
                } else {
                    startScript("jQuery(\"a.i-ljuser-username:not(:contains('Журнал ЖЖ'))\").parents('.entryunit').find('.entryunit__head a')[0].click()");
                }
                flag = false;
            } catch (Exception ex) {
                if (page > 10) {
                    flag = false;
                } else {
                    page++;
                }
            }
        }
        return this;
    }

    @StepGroup
    private Boolean addToFriendsButtonIsAvaliable() {
        return startScript("jQuery('.b-discoveryarticle-addfriend-title').attr('lj-ml')").equals("discovery.article.addfriend");
    }

}
