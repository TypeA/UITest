
package com.livejournal.uitests.pages;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
import junit.framework.Assert;

/**
 *
 * @author m.prytkova
 */
public class Region extends LJPage{
    
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

    
}
