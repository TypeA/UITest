package com.livejournal.uitests.pages;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.Root;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
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

    public LJPage defoultMinSecurity(String user) {
        String script1 = "select clusterid, user from user "
                + "where user = '" + user + "';";
        String clusterid = workWithDB().conect()
                .select(script1, "clusterid")
                .finish()
                .get(0)
                .get(0);
        String script2 = "select * from lj_c" + clusterid + ".userproplite2 "
                + "where upropid = "
                + "(select upropid from userproplist where name = 'newpost_minsecurity') "
                + "and userid = "
                + "(select userid from user where user = '" + user + "');";
        try {
            workWithDB().conect()
                    .select(script2, "value")
                    .finish()
                    .get(0)
                    .get(0);
            open(SettingsMainPage.class, new Url().setPostfix("?cat=privacy"))
                    .setMinSecurity("Public")
                    .saveSettings();
        } catch (Exception ex) {
        }
        return this;
    }

    public LJPage defoultLanguage(String user) {
        String script1 = "select clusterid, user from user "
                + "where user = '" + user + "';";
        String clusterid = workWithDB().conect()
                .select(script1, "clusterid")
                .finish()
                .get(0)
                .get(0);
        String script2 = " select * from lj_c" + clusterid + ".userproplite2 "
                + "where upropid = "
                + "(select upropid from userproplist where name = 'browselang') "
                + "and userid = "
                + "(select userid from user where user = '" + user + "');";
        String lang = workWithDB().conect()
                .select(script2, "value")
                .finish()
                .get(0)
                .get(0);
        if (!lang.equals("en_LJ")) {
            open(SettingsMainPage.class, new Url().setPostfix("?cat=display"))
                    .setLanguage("en_LJ")
                    .saveSettings();
        }
        return this;
    }

}
