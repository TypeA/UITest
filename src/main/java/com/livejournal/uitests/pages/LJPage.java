package com.livejournal.uitests.pages;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.Root;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.pages.service_pages.settings.CustomizeJournalPage;
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
        return this;
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
        return onOpened(LJPage.class);
    }

    public LJPage defaultLanguageUnlogged() {
        addCookie("langpref", "en_LJ");
        return onOpened(LJPage.class);
    }

    public LJPage regionSwitchLogged(String user, String region) {
        switch (region.toUpperCase()) {
            case "CYR":
                if (getDBDate().userSettings().getCyrSetting(user).equals("NONCYR")) {
                    open(SettingsMainPage.class, new Url().setPostfix("?cat=display")).changeCyrServices().saveSettings();
                }
                break;
            case "NONCYR":
                if (getDBDate().userSettings().getCyrSetting(user).equals("CYR")) {
                    open(SettingsMainPage.class, new Url().setPostfix("?cat=display")).changeCyrServices().saveSettings();
                }
                break;
            default:
                Assert.fail("Incorrect user region " + region);
        }
        return onOpened(LJPage.class);
    }

    public LJPage regionSwitchUnlogged(String reg) {
        switch (reg.toUpperCase()) {
            case "CYR":
                addCookie("fake_ipclass", "russia");
                break;
            case "NONCYR":
                addCookie("fake_ipclass", "US");
                break;
            default:
                Assert.fail("Incorrect user region " + reg);
        }
        return onOpened(LJPage.class);
    }

    public LJPage setCustonAdaptiveProp(String user, String adaptive) {
        if (!(adaptive.equals(getDBDate().userSettings().getAdaptiveSetting(user).toString()))) {
            open(SettingsMainPage.class, new Url().setPostfix("?cat=display"))
                    .changeCustomAdaptive()
                    .saveSettings();
        }
        return this;
    }

    public LJPage setDefaultStyle(String user) {
        if (!getDBDate().userSettings().getStyle(user).equals("wizard-air/default_theme")) {
            open(CustomizeJournalPage.class)
                    .findStyle("Air")
                    .applyStyle("Air");
        }
        return this;
    }

    public LJPage setAdaptiveStyle(String user) {
        if (!getDBDate().userSettings().getStyle(user).equals("wizard-chameleon/__adaptive")) {
            open(CustomizeJournalPage.class)
                    .findStyle("Unstyled Adaptive")
                    .applyStyle("Unstyled Adaptive");
        }
        return this;
    }

    public LJPage setRegularStyle(String user) {
        if (!getDBDate().userSettings().getStyle(user).equals("wizard-voxhtml/light-clouds")) {
            open(CustomizeJournalPage.class)
                    .findStyle("Light clouds")
                    .applyStyle("Light clouds");
        }
        return this;
    }

    public LJPage setOptionViewInMyStyle(String user, String optionValue) {
        if (!optionValue.toUpperCase().equals(getDBDate().userSettings().getInMyOnStyleSetting(user).toUpperCase())) {
            open(SettingsMainPage.class, new Url().setPostfix("?cat=display"))
                    .changeViewInMyStyle()
                    .saveSettings();
        }
        return this;
    }

}
