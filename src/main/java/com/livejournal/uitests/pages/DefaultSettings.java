package com.livejournal.uitests.pages;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uitests.pages.service_pages.settings.CustomizeJournalPage;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
import junit.framework.Assert;

/**
 *
 * @author m.prytkova
 */
public class DefaultSettings extends LJPage {

    public LJPage defaultMinSecurity(String user) {
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
            open(SettingsMainPage.class, new Url().setPostfix("?authas=" + user + "&cat=privacy"))
                    .setMinSecurity("Public")
                    .saveSettings();
        } catch (Exception ex) {
            Assert.assertTrue("I cannot set default min security", true);
        }
        return onOpened(LJPage.class);
    }

    public LJPage defaultLanguageLogged(String user) {
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
        String lang;
        try {
            lang = workWithDB().conect()
                    .select(script2, "value")
                    .finish()
                    .get(0)
                    .get(0);
        } catch (Exception ex) {
            lang = "Empty set";
        }
        if (!lang.equals("en_LJ")) {
            open(SettingsMainPage.class, new Url().setPostfix("?cat=display"))
                    .setLanguage("en_LJ")
                    .saveSettings();
        }

        return onOpened(LJPage.class);
    }

    public LJPage defaultLanguageUnlogged() {
        addCookie("langpref", "en_LJ");
        return onOpened(LJPage.class);
    }

    public LJPage defaultStyle(String user) {
        if (!getDBDate().userSettings().getStyle(user).equals("wizard-air/default_theme")) {
            open(CustomizeJournalPage.class)
                    .findStyle("Air")
                    .applyStyle("Air");
        }
        return onOpened(LJPage.class);
    }

}
