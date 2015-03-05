/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.friends;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageGroupsPage;
import com.livejournal.uitests.pages.service_pages.settings.friends.finish_form.FinishFormGroupPage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.thucydides.core.annotations.StepGroup;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author m.panferova
 */
public class ManageFriendsGroups extends WebTest {

    //Scenario: Change the position of the group(1/4)
    //Scenario: Public group(1/3)
    //Scenario: Create new group(1/4)
    //Scenario: Delete group(1/3)
    //Scenario: Rename group name(1/3)
    //Scenario: Add users in group(1/3)
    //Scenario: Delete users in group(1/3)

    @Given("logged user (name $name) on Manage Groups Page")
    public void logged_user_on_Manage_Groups_Page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, workWithDB().getUserPassword(name));
        open(ManageGroupsPage.class);
        ThucydidesUtils.putToSession("user", name);
    }

    //Scenario: Change the position of the group(2/4)

    @When("user moves the group up and moves the group down and save the changes")
    public void user_moves_the_group_up_and_moves_the_group_down_and_save_the_changes() {
        String[] groupListBefore = getAllGroupForUser();
        TwoRandomIndexNotEquals results1 = new TwoRandomIndexNotEquals(1, 2);
        TwoRandomIndexNotEquals results2 = results1.getIndexTwoGroup(groupListBefore.length);
        onOpened(ManageGroupsPage.class)
                .selectByIndexGroup(results2.indexMoveUp)
                .moveUpGroup()
                .selectByIndexGroup(results2.indexMoveDown)
                .moveDownGroup()
                .saveChangesForGroup();
        String u = groupListBefore[results2.indexMoveUp];
        groupListBefore[results2.indexMoveUp] = groupListBefore[results2.indexMoveUp - 1];
        groupListBefore[results2.indexMoveUp - 1] = u;

        String f = groupListBefore[results2.indexMoveDown];
        groupListBefore[results2.indexMoveDown] = groupListBefore[results2.indexMoveDown + 1];
        groupListBefore[results2.indexMoveDown + 1] = f;
        ThucydidesUtils.putToSession("groupList", ConvertArrayToString(groupListBefore));

    }

    //Scenario: Public group(2/3)

    @When("user set the group is public and save the changes")
    public void user_set_the_group_is_public_and_save_the_changes() {
        String[] groupListBefore = getAllGroupForUser();
        int randomIndex = new Random().nextInt(groupListBefore.length);
        onOpened(ManageGroupsPage.class)
                .selectByIndexGroup(randomIndex)
                .clickPrivate()
                .saveChangesForGroup();
        open(ManageGroupsPage.class);
        onOpened(ManageGroupsPage.class)
                .selectByIndexGroup(randomIndex);
        String publicGroup = getTextInGroupListByIndex(randomIndex);
        onOpened(ManageGroupsPage.class)
                .clickPublic()
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("publicGroup", publicGroup);
       
    }

    //Scenario: Public group(3/3)

    @Then("unlogged user can see group")
    public void unlogged_user_can_see_group() {
        open(MainPageLogged.class)
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut();
        String user = ThucydidesUtils.getFromSession("user").toString();
        String publicGroup = ThucydidesUtils.getFromSession("publicGroup").toString();
        String userNotFriend = workWithDB().findFriendWithoutGroup(user);
        open(LoginPageUnlogged.class)
                .authorizeBy(userNotFriend, workWithDB().getUserPassword(userNotFriend));
        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."))
                .openFilters();
        String nameOfGroup = onOpened(FriendsFeedLogged.class).getGroups();
        verify().that(nameOfGroup.indexOf(publicGroup) != -1)
                .ifResultIsExpected("Group is public")
                .ifElse("Group is not Public")
                .finish();

    }

    //Scenario: Create new group(2/4)

    @When("user create new group $group and save the changes")
    public void user_create_new_group_and_save_the_changes(String group) {
        String[] groupListBefore = getAllGroupForUser();
        String groups = ConvertArrayToString(groupListBefore) + group;
        onOpened(ManageGroupsPage.class)
                .clickNewGroup();
        WebDriver driver = getCurrentBrowser().getDriver();
        driver.switchTo().alert().sendKeys(group);
        driver.switchTo().alert().accept();
        onOpened(ManageGroupsPage.class)
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("groupList", groups);
        ThucydidesUtils.putToSession("newGroup", group);

    }

    //Scenario: Change the position of the group(3/4)

    @Then("the changes displayed correctly on Manage Groups Page")
    public void the_changes_displayed_correctly_on_Manage_Groups_Page() {
        System.out.println("22222");
        open(ManageGroupsPage.class);
        String groupListBefore = ThucydidesUtils.getFromSession("groupList").toString();
        String[] groupListAfter = getAllGroupForUser();
        verify().that(ConvertArrayToString(groupListAfter).equals(groupListBefore))
                .ifResultIsExpected("Group move change success")
                .ifElse("Not change")
                .finish();
    }

    //Scenario: Change the position of the group(4/4)
    //Scenario: Create new group(3/4)
    //Scenario: Delete group(3/3)
    //Scenario: Rename group name(3/3)

    @Then("the changes displayed correctly on the Friends Feed")
    public void the_changes_displayed_correctly_on_the_Friends_Feed() {
        String groupListBefore = deleteSecurityInGroups(ThucydidesUtils.getFromSession("groupList").toString());
        String user = ThucydidesUtils.getFromSession("user").toString();
        System.out.println("!!!"+groupListBefore);
        
        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."))
                .openFilters();
        String nameOfGroup = onOpened(FriendsFeedLogged.class).getGroups();
        System.out.println("!!!"+nameOfGroup);
        verify().that(nameOfGroup.indexOf(groupListBefore) != -1)
                .ifResultIsExpected("Group move change success")
                .ifElse("Not change")
                .finish();
    }

    //Scenario: Create new group(4/4)

    @Then("there are no posts in the new group")
    public void there_are_no_posts_in_the_new_group() {
        String newGroup = ThucydidesUtils.getFromSession("newGroup").toString();
        String user = ThucydidesUtils.getFromSession("user").toString();
        open(FriendsFeedLogged.class, new Url().setPostfix("/" + newGroup)
                .setPrefix(user + "."));
        Boolean emptyFeed = onOpened(FriendsFeedLogged.class).feedIsEmpty();
        verify().that(emptyFeed)
                .ifResultIsExpected("Feed is empty")
                .ifElse("Feed not Empty")
                .finish();
    }

    //Scenario: Delete group(2/3)

    @When("user delete group and save the changes")
    public void user_delete_group_and_save_the_changes() {
        String[] groupListBefore = getAllGroupForUser();

        int randomIndex = new Random().nextInt(groupListBefore.length);
        onOpened(ManageGroupsPage.class)
                .selectByIndexGroup(randomIndex)
                .clickDeleteGroup();
        WebDriver driver = getCurrentBrowser().getDriver();
        driver.switchTo().alert().accept();
        onOpened(ManageGroupsPage.class)
                .saveChangesForGroup();
        System.out.println(randomIndex+"  111111  ");
        String[] groupListAfter = removeElementInArray(groupListBefore, randomIndex);
        System.out.println(randomIndex+"  111111  "+ConvertArrayToString(groupListAfter));
        ThucydidesUtils.putToSession("groupList", deleteSecurityInGroups(ConvertArrayToString(groupListAfter)));
    }

    //Scenario: Rename group name(2/3)

    @When("user rename group name and save the changes")
    public void user_rename_group_name_and_save_the_changes() {
        String[] groupListBefore = getAllGroupForUser();
        String group = generateNameGroup();
        int randomIndex = new Random().nextInt(groupListBefore.length);
        onOpened(ManageGroupsPage.class)
                .selectByIndexGroup(randomIndex)
                .clickRenameGroup();
        WebDriver driver = getCurrentBrowser().getDriver();
        driver.switchTo().alert().sendKeys(group);
        driver.switchTo().alert().accept();
        onOpened(ManageGroupsPage.class)
                .saveChangesForGroup();
        String[] groupListAfter = changeElementInArray(groupListBefore, randomIndex, group);
        ThucydidesUtils.putToSession("groupList", deleteSecurityInGroups(ConvertArrayToString(groupListAfter)));
    }

    //Scenario: Delete users in group(2/3)

    @When("user delete users in group and save the changes")
    public void user_delete_users_in_group_and_save_the_changes() {
        String[] groupList = getAllGroupForUser();
        
        String[] usersInGroup = null;
        int randomIndexUser = 0;
        int i = 0;
        boolean flag = false;
        while (flag == false && i < groupList.length) {
            onOpened(ManageGroupsPage.class)
                    .selectByIndexGroup(i);
            usersInGroup = userInGroup();
            if (usersInGroup.length != 0) {
                randomIndexUser = new Random().nextInt(usersInGroup.length);
                onOpened(ManageGroupsPage.class)
                        .selectByIndexUserInGroup(randomIndexUser)
                        .moveUserOut()
                        .saveChangesForGroup();
                flag = true;
                i++;
            }
            if (usersInGroup.length == 0) {
                flag = false;
                i++;
            }
        }
        ThucydidesUtils.putToSession("groupIndex", i - 1);
        String[] userAfter = removeElementInArray(usersInGroup, randomIndexUser);
        ThucydidesUtils.putToSession("listUser", ConvertArrayToString(userAfter));
    }

    // Scenario: Add users in group(2/3)

    @When("user add users  in group and save the changes")
    public void user_add_users_in_group_and_save_the_changes() throws InterruptedException {
        String[] groupList = getAllGroupForUser();
        String[] usersOutGroup = null;
        String[] usersInGroup = null;
        int randomIndexUser = 0;
        String user = null;
        int i = 0;
        boolean flag = false;
        while (flag == false && i < groupList.length) {
            onOpened(ManageGroupsPage.class)
                    .selectByIndexGroup(i);
            usersOutGroup = userOutGroup();
            usersInGroup = userInGroup();
            if (usersOutGroup.length != 0) {
                randomIndexUser = new Random().nextInt(usersOutGroup.length);
                user = getTextUserOutGroupByIndex(randomIndexUser);
                onOpened(ManageGroupsPage.class)
                        .selectByIndexUserOutGroup(randomIndexUser);
                onOpened(ManageGroupsPage.class)
                        .moveUserIn()
                        .saveChangesForGroup();
                flag = true;
                i++;
            }
            if (usersOutGroup.length == 0) {
                flag = false;
                i++;
            }
        }
        ThucydidesUtils.putToSession("groupIndex", i - 1);
        String[] usersAfterChange = addElementToArray(usersInGroup, user);
        Arrays.sort(usersAfterChange);
        ThucydidesUtils.putToSession("listUser", ConvertArrayToString(usersAfterChange));

    }

    // Scenario: Add users in group(3/3)
    //Scenario: Delete users in group(3/3)

    @Then("in group displayed correct user")
    public void in_group_displayed_correct_user() {
        String groupIndex = ThucydidesUtils.getFromSession("groupIndex").toString();
        open(ManageGroupsPage.class)
                .selectByIndexGroup(Integer.parseInt(groupIndex));
        String users = ThucydidesUtils.getFromSession("listUser").toString();
        String usersAfter = ConvertArrayToString(userInGroup());
        verify().that(usersAfter.equals(users))
                .ifResultIsExpected("User delete success")
                .ifElse("User not Delete")
                .finish();
    }

    @StepGroup
    public String[] getAllGroupForUser() {
        WebDriver driver = getCurrentBrowser().getDriver();
        WebElement list = driver.findElement(By.id("list_groups"));
        Select value = new Select(list);
        List<WebElement> options = value.getOptions();
        String[] nameGroups = new String[options.size()];

        for (int i = 0; i < options.size(); i++) {
            nameGroups[i] = options.get(i).getText();
        }
        return nameGroups;
    }

    public String getTextInGroupListByIndex(int index) {
        WebDriver driver = getCurrentBrowser().getDriver();
        String group = driver.findElement(By.xpath("//select[@id='list_groups']//option[" + (index + 1) + "]")).getText();
        return group;
    }

    public String getTextUserOutGroupByIndex(int index) {
        WebDriver driver = getCurrentBrowser().getDriver();
        String user = driver.findElement(By.xpath("//select[@name='list_out']//option[" + (index + 1) + "]")).getText();
        return user;
    }

    public String ConvertArrayToString(String[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
        }
        return result.toString();
    }

    public String[] getAllFilterOnFeed() {
        WebDriver driver = getCurrentBrowser().getDriver();
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='l-flatslide-menu-items l-flatslide-menu-items-active']//li//a"));
        String[] nameGroups = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nameGroups[i] = list.get(i).getText();
        }
        return nameGroups;
    }

    public String deleteSecurityInGroups(String text) {
        String groups = text.replace(" (public)", "").replace(" (общедоступная)", "");
        return groups;
    }

    public String generateNameGroup() {
        char[] text = "cnmvls+keueiq[}dk_zkdk.ndxvxc_v0321QWNGHKL:IZA312".toCharArray();
        StringBuilder newNameOfGroup = new StringBuilder();
        int lengthNameGroup = new Random().nextInt(15);
        for (int i = 0; i < lengthNameGroup; i++) {
            int randomIndex = new Random().nextInt(text.length);
            newNameOfGroup.append(text[randomIndex]);
        };
        return newNameOfGroup.toString();
    }

    public String[] removeElementInArray(String[] array, int index) {
        String[] newArray = new String[array.length - 1];
        int v=0;
        for (int i = 0; i < array.length; i++) {
            if (v == index && v != (array.length - 1)) {
                newArray[i] = array[v + 1];
                v=v+2;
                System.out.println(newArray[i]);
            }
            else if  ((v == array.length - 1)&&(v==index)) {
                return newArray;
            }
            else if (v != index&&v<array.length) {
                newArray[i] = array[v];
                v++;
                System.out.println(newArray[i]);
            }
        }
        return newArray;
    }

    public String[] changeElementInArray(String[] array, int index, String newName) {
        String[] newArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                newArray[i] = newName;
            }
            if (i != index) {
                newArray[i] = array[i];
            }
        }
        return newArray;
    }

    public String[] userInGroup() {
        WebDriver driver = getCurrentBrowser().getDriver();
        WebElement list = driver.findElement(By.id("list_in"));
        Select value = new Select(list);
        List<WebElement> options = value.getOptions();
        String[] userInGroup = new String[options.size()];

        for (int i = 0; i < options.size(); i++) {
            userInGroup[i] = options.get(i).getText();
        }
        return userInGroup;
    }

    public String[] userOutGroup() {
        WebDriver driver = getCurrentBrowser().getDriver();
        WebElement list = driver.findElement(By.name("list_out"));
        Select value = new Select(list);
        List<WebElement> options = value.getOptions();
        String[] userOutGroup = new String[options.size()];

        for (int i = 0; i < options.size(); i++) {
            userOutGroup[i] = options.get(i).getText();
        }
        return userOutGroup;
    }

    public String[] addElementToArray(String[] arr, String element) {
        String[] newArr = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = element;
        return newArr;
    }
}
