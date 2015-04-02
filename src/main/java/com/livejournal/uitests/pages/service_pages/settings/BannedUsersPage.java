package com.livejournal.uitests.pages.service_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/manage/banusers.bml")
public class BannedUsersPage extends ServicePageLogged {

    @FindBy(css = ".ban-list-textarea")
    private TextField banListField;

    @FindBy(name = "ban_users_btn")
    private Button banUserButton;

    @FindBy(name = "unban_users_btn")
    private Button saveChanges;

    @FindBy(name = "all")
    private Button checkBoxAll;

    public BannedUsersPage typeInBanList(String list) {
        banListField.sendKeys(list);
        return this;
    }

    public BannedUsersPage clickBannedUser() {
        banUserButton.click();
        return this;
    }

    public BannedUsersPage clickSaveChange() {
        saveChanges.click();
        return this;
    }

    public boolean userInBanList(String user) {
        String script = "return jQuery(\"table b\").is(\":contains('" + user + "')\")";
        return Boolean.valueOf(startScript(script).toString());

    }
}
