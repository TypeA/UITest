package com.livejournal.uitests.pages.service_pages.settings.friends;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.finish_form.FinishFormGroupPage;
import java.util.List;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/friends/editgroups.bml")
public class ManageGroupsPage extends ServicePageLogged {

    @FindBy(id = "list_groups")
    private Select groupList;

    @FindBy(name = "list_out")
    private Select listUsersOutGroup;

    @FindBy(name = "list_in")
    private Select listUsersInGroup;

    @FindBy(xpath = "//button[@class=' b-flatbutton b-flatbutton-green']")
    private Button saveChangesGroup;

    @FindBy(id = "makePrivate")
    private Button makeGroupPrivate;

    @FindBy(id = "makePublic")
    private Button makeGroupPublic;

    @FindBy(id = "moveGroupUp")
    private Button moveGroupUp;

    @FindBy(id = "moveGroupDown")
    private Button moveGroupDown;

    @FindBy(id = "newGroup")
    private Button newGroup;

    @FindBy(id = "renameGroup")
    private Button renameGroup;

    @FindBy(id = "deleteGroup")
    private Button deleteGroup;

    @FindBy(id = "moveIn")
    private Button addUserInGroup;

    @FindBy(id = "moveOut")
    private Button deleteUserInGroup;

    public ManageGroupsPage selectGroup(String group) {
        groupList.deselectByVisibleText(group);
        return this;
    }

    public ManageGroupsPage clickPrivate() {
        makeGroupPrivate.click();
        return this;
    }

    public ManageGroupsPage clickPublic() {
        makeGroupPublic.click();
        return this;
    }

    public ManageGroupsPage clickRenameGroup() {
        renameGroup.click();
        return this;
    }

    public ManageGroupsPage selectByIndexGroup(Integer index) {
        groupList.selectByIndex(index);
        return this;
    }

    public ManageGroupsPage selectByIndexUserInGroup(Integer index) {
        listUsersInGroup.selectByIndex(index);
        return this;
    }

    public ManageGroupsPage selectByIndexUserOutGroup(Integer index) {
        listUsersOutGroup.selectByIndex(index);
        return this;
    }

    public ManageGroupsPage clickNewGroup() {
        newGroup.click();
        return this;
    }

    public FinishFormGroupPage saveChangesForGroup() {
        saveChangesGroup.click();
        return onDisplayed(FinishFormGroupPage.class);
    }

    public ManageGroupsPage clickDeleteGroup() {
        deleteGroup.click();
        return this;
    }

    public ManageGroupsPage moveUpGroup() {
        moveGroupUp.click();
        return this;
    }

    public ManageGroupsPage moveDownGroup() {
        moveGroupDown.click();
        return this;
    }

    public ManageGroupsPage moveUserOut() {
        deleteUserInGroup.click();
        return this;
    }

    public ManageGroupsPage moveUserIn() {
        addUserInGroup.click();
        return this;
    }

    public String deleteSecurityInGroups(String text) {
        String groups = text.replace(" (public)", "").replace(" (общедоступная)", "");
        return groups;
    }
    
        public String[] userInGroup() {
        WebElement list = getDriver().findElement(By.id("list_in"));
        Select value = new Select(list);
        List<WebElement> options = value.getOptions();
        String[] userInGroup = new String[options.size()];

        for (int i = 0; i < options.size(); i++) {
            userInGroup[i] = options.get(i).getText();
        }
        return userInGroup;
    }

    public String[] userOutGroup() {
        WebDriver driver = getDriver();
        WebElement list = driver.findElement(By.name("list_out"));
        Select value = new Select(list);
        List<WebElement> options = value.getOptions();
        String[] userOutGroup = new String[options.size()];
        for (int i = 0; i < options.size(); i++) {
            userOutGroup[i] = options.get(i).getText();
        }
        return userOutGroup;
    }

    @StepGroup
    public String[] getAllGroupForUser() {
        WebElement list = getDriver()
                .findElement(By.id("list_groups"));

        Select value = new Select(list);
        List<WebElement> options = value.getOptions();
        String[] nameGroups = new String[options.size()];

        for (int i = 0; i < options.size(); i++) {
            nameGroups[i] = options.get(i).getText();
        }
        return nameGroups;
    }

    public String getTextInGroupListByIndex(int index) {
        WebDriver driver = getDriver();
        String group = driver.findElement(By.xpath("//select[@id='list_groups']//option[" + (index + 1) + "]")).getText();
        return group;
    }

    public String getTextUserOutGroupByIndex(int index) {
        WebDriver driver = getDriver();
        String user = driver.findElement(By.xpath("//select[@name='list_out']//option[" + (index + 1) + "]")).getText();
        return user;
    }

}
