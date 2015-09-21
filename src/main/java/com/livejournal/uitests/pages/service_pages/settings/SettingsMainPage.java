package com.livejournal.uitests.pages.service_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/manage/settings/")
public class SettingsMainPage extends ServicePageLogged {

    @FindBy(css = "#settings_left .b-flatbutton")
    private Button saveSettings;

    public SettingsMainPage selectWorkAsUser(String user) {
        workAsUser.selectByValue(user);
        return this;
    }

    public SettingsMainPage saveSettings() {
        saveSettings.click();
        return this;
    }

    //////////////////////////display page
    @FindBy(name = "LJ__Setting__Language_lang")
    private Select language;

    public SettingsMainPage setLanguage(String lang) {
        language.selectByValue(lang);
        return this;
    }

    public SettingsMainPage changeCyrServices() {
        startScript("jQuery('tr td input[id=LJ__Setting__CyrillicServices_cyrillicservices]').click()");
        return this;
    }
    
    public SettingsMainPage changeCustomAdaptive() {
        startScript("jQuery('tr td input[id=LJ__Setting__MobAdaptive_cmobadv]').click()");
        return this;
    }

    //////////////////////////privacy page
    @FindBy(id = "LJ__Setting__MinSecurity_minsecurity")
    private Select minSecurity;

    @FindBy(name = "authas")
    private Select workAsUser;

    @FindBy(css = "[value='Switch']")
    private Button switcwJournalType;

    public SettingsMainPage setMinSecurity(String security) {
        if (security.equals("Members")) {
            security = "Friends";
        }
        minSecurity.selectByValue(security.toLowerCase());
        return this;
    }

    public SettingsMainPage clickSwitchJournalType() {
        switcwJournalType.click();
        return this;
    }

}
