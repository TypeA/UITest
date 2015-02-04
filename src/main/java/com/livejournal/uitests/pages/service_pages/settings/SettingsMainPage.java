package com.livejournal.uitests.pages.service_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import java.util.ArrayList;
import java.util.List;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/manage/settings/")
public class SettingsMainPage extends ServicePageLogged {

    @FindBy(css = "div[id*='settings_save'] button")
    private Button saveSettings;

    public SettingsMainPage saveSettings() {
        saveSettings.click();
        return this;
    }

    //////////////////////////display
    @FindBy(name = "LJ__Setting__Language_lang")
    private Select language;

    public SettingsMainPage setLanguage(String lang) {
        language.selectByValue(lang);
        return this;
    }

    //////////////////////////privacy
    @FindBy(id = "LJ__Setting__MinSecurity_minsecurity")
    private Select minSecurity;

    public SettingsMainPage setMinSecurity(String security) {
        minSecurity.selectByValue(security.toLowerCase());
        return this;
    }

}
