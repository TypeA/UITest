package com.livejournal.uitests.pages;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uitests.pages.service_pages.settings.CustomizeJournalPage;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;

/**
 *
 * @author m.prytkova
 */
public class Style extends LJPage {

    public LJPage setCustonAdaptiveProp(String user, String adaptive) {
        if (!(adaptive.equals(getDBDate().userSettings().getAdaptiveSetting(user).toString()))) {
            open(SettingsMainPage.class, new Url().setPostfix("?cat=display"))
                    .changeCustomAdaptive()
                    .saveSettings();
        }
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

    public LJPage setAdaptiveStyle(String user) {
        if (!getDBDate().userSettings().getStyle(user).equals("wizard-chameleon/__adaptive")) {
            open(CustomizeJournalPage.class)
                    .findStyle("Unstyled Adaptive")
                    .applyStyle("Unstyled Adaptive");
        }
        return onOpened(LJPage.class);
    }

    public LJPage setRegularStyle(String user) {
        if (!getDBDate().userSettings().getStyle(user).equals("wizard-voxhtml/light-clouds")) {
            open(CustomizeJournalPage.class)
                    .findStyle("Light clouds")
                    .applyStyle("Light clouds");
        }
        return onOpened(LJPage.class);
    }

    public LJPage setViewInMyStyle(String user, boolean setting) {
        if (setting != getDBDate().userSettings().getInMyStyleSetting(user)) {
            open(SettingsMainPage.class, new Url().setPostfix("?cat=display"))
                    .changeViewInMyStyle()
                    .saveSettings();

        }
        return onOpened(LJPage.class);
    }

}
