package com.livejournal.uitests.pages.service_pages.settings.friends;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.finish_form.FinishFormGroupPage;
import java.util.ArrayList;
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

    public ManageGroupsPage clickPrivacy(Integer index, String privacy) {
        selectByIndexGroup(index);
        if (privacy.equals("private")) {
            makeGroupPrivate.click();
        } else if (privacy.equals("public")) {
            makeGroupPublic.click();
        }
        return this;
    }

    public ManageGroupsPage renameGroup(int index, String group) {
        selectByIndexGroup(index);
        renameGroup.click();
        getDriver().switchTo().alert().sendKeys(group);
        getDriver().switchTo().alert().accept();
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

    public ManageGroupsPage createNewGroup(String group) {
        newGroup.click();
        getDriver().switchTo().alert().sendKeys(group);
        getDriver().switchTo().alert().accept();
        return this;
    }

    public FinishFormGroupPage saveChangesForGroup() {
        saveChangesGroup.click();
        return onDisplayed(FinishFormGroupPage.class);
    }

    public ManageGroupsPage clickDeleteGroup(int index) {
        selectByIndexGroup(index);
        deleteGroup.click();
        getDriver().switchTo().alert().accept();
        return this;
    }

    public ManageGroupsPage moveGroup(Integer index, String direction) {
        selectByIndexGroup(index);
        if (direction.equals("up")) {
            moveGroupUp.click();
        } else if (direction.equals("down")) {
            moveGroupDown.click();
        }
        return this;
    }

    public ManageGroupsPage moveUserOut(int index) {
        selectByIndexUserInGroup(index);
        deleteUserInGroup.click();
        return this;
    }

    public ManageGroupsPage moveUserIn(int index) {
        selectByIndexUserOutGroup(index);
        addUserInGroup.click();
        return this;
    }

    public String deleteSecurityInGroups(String text) {
        String groups = text.replace(" (public)", "").replace(" (общедоступная)", "");
        return groups;
    }

    public ArrayList<String> usersInGroup() {
        WebElement list = getDriver().findElement(By.id("list_in"));
        Select value = new Select(list);
        List<WebElement> options = value.getOptions();
        ArrayList<String> usersInGroup = new ArrayList<String>();
        for (WebElement option : options) {
            String userInGroup = option.getText();
            usersInGroup.add(userInGroup);
        }
        return usersInGroup;
    }

    public ArrayList<String>  userOutGroup() {
        WebDriver driver = getDriver();
        WebElement list = driver.findElement(By.name("list_out"));
        Select value = new Select(list);
        List<WebElement> options = value.getOptions();
        ArrayList<String>  usersOutGroup = new ArrayList<String>();
        for (int i = 0; i < options.size(); i++) {
          String  userOutGroup = options.get(i).getText();
            usersOutGroup.add(userOutGroup);
        }
        return usersOutGroup;
    }

    @StepGroup
    public ArrayList<String> getAllGroupForUser() {
        WebElement list = getDriver()
                .findElement(By.id("list_groups"));
        Select value = new Select(list);
        List<WebElement> options = value.getOptions();
        ArrayList<String> nameGroups = new ArrayList<String>();
        for (int i = 0; i < options.size(); i++) {
            String nameGroup = options.get(i).getText();
            nameGroups.add(nameGroup);
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
