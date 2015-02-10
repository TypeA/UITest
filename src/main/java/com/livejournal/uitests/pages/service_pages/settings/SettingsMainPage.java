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

    @FindBy(css = "[value='Save']")
    private Button saveSettings;

    //////////////////////////privacy
    @FindBy(id = "LJ__Setting__MinSecurity_minsecurity")
    private Select minSecurity;
    
    @FindBy(name = "authas")
    private Select workAsUser;
    
    @FindBy(css="[value='Switch']")
    private Button buttonSwitch;

    public SettingsMainPage setMinSecurity(String security) {
        if(security.equals("Members")){
        security="Friends";
        }
        minSecurity.selectByValue(security.toLowerCase());
        return this;
    }

    public SettingsMainPage saveSettings() {
        saveSettings.click();
        return this;
    }
    public SettingsMainPage selectWorkAsUser(String user) {
        workAsUser.selectByValue(user);
        return this;
    }
    
     public SettingsMainPage clickSwitch() {
        buttonSwitch.click();
        return this;
    }
    
}
