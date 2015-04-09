package com.livejournal.uitests.friends.useful.manage_friends_groups;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageGroupsPage;
import com.livejournal.uitests.utility.RandomText;
import java.util.Arrays;
import java.util.Random;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

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
                .authorizeBy(name, getDBDate().userData().getUserPassword(name));
        String[] groupListBefore = open(ManageGroupsPage.class)
                .getAllGroupForUser();
        ThucydidesUtils.putToSession("user", name);
        ThucydidesUtils.putToSession("group_list_before", groupListBefore);
    }

    //Scenario: Change the position of the group(2/4)
    @When("user moves the group up and moves the group down and save the changes")
    public void user_moves_the_group_up_and_moves_the_group_down_and_save_the_changes() {
        String[] groupListBefore = (String[]) ThucydidesUtils.getFromSession("group_list_before");
        TwoRandomIndexNotEquals results = new TwoRandomIndexNotEquals(1, 2).getIndexTwoGroup(groupListBefore.length);
        onOpened(ManageGroupsPage.class)
                .selectByIndexGroup(results.indexMoveUp)
                .moveUpGroup()
                .selectByIndexGroup(results.indexMoveDown)
                .moveDownGroup()
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("groupList", convertArrayToString(changeArrayElements(groupListBefore, results)));
    }

    //Scenario: Public group(2/3)
    @When("user set the group is public and save the changes")
    public void user_set_the_group_is_public_and_save_the_changes() {
        String[] groupListBefore = (String[]) ThucydidesUtils.getFromSession("group_list_before");
        int randomIndex = new Random().nextInt(groupListBefore.length);
        onOpened(ManageGroupsPage.class)
                .selectByIndexGroup(randomIndex)
                .clickPrivate()
                .saveChangesForGroup();
        open(ManageGroupsPage.class)
                .selectByIndexGroup(randomIndex)
                .clickPublic()
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("publicGroup", onOpened(ManageGroupsPage.class).getTextInGroupListByIndex(randomIndex));
    }

    //Scenario: Create new group(2/4)
    @When("user create new group $group and save the changes")
    public void user_create_new_group_and_save_the_changes(String group) {
        String groups = convertArrayToString((String[]) ThucydidesUtils.getFromSession("group_list_before")) + group;
        onOpened(ManageGroupsPage.class)
                .clickNewGroup();
        getCurrentBrowser().getDriver().switchTo().alert().sendKeys(group);
        getCurrentBrowser().getDriver().switchTo().alert().accept();
        onOpened(ManageGroupsPage.class)
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("groupList", groups);
        ThucydidesUtils.putToSession("newGroup", group);
    }

    //Scenario: Delete group(2/3)
    @When("user delete group and save the changes")
    public void user_delete_group_and_save_the_changes() {
        String[] groupListBefore = (String[]) ThucydidesUtils.getFromSession("group_list_before");
        int randomIndex = new Random().nextInt(groupListBefore.length);
        onOpened(ManageGroupsPage.class)
                .selectByIndexGroup(randomIndex)
                .clickDeleteGroup();
        getCurrentBrowser().getDriver().switchTo().alert().accept();
        onOpened(ManageGroupsPage.class)
                .saveChangesForGroup();
        String[] groupListAfter = removeElementInArray(groupListBefore, randomIndex);
        ThucydidesUtils.putToSession("groupList", onOpened(ManageGroupsPage.class).deleteSecurityInGroups(convertArrayToString(groupListAfter)));
    }

    //Scenario: Rename group name(2/3)
    @When("user rename group name and save the changes")
    public void user_rename_group_name_and_save_the_changes() {
        String[] groupListBefore = (String[]) ThucydidesUtils.getFromSession("group_list_before");
        String group = RandomText.getRandomText(10);
        int randomIndex = new Random().nextInt(groupListBefore.length);
        onOpened(ManageGroupsPage.class)
                .selectByIndexGroup(randomIndex)
                .clickRenameGroup();
        getCurrentBrowser().getDriver().switchTo().alert().sendKeys(group);
        getCurrentBrowser().getDriver().switchTo().alert().accept();
        onOpened(ManageGroupsPage.class)
                .saveChangesForGroup();
        String[] groupListAfter = changeElementInArray(groupListBefore, randomIndex, group);
        ThucydidesUtils.putToSession("groupList", onOpened(ManageGroupsPage.class).deleteSecurityInGroups(convertArrayToString(groupListAfter)));
    }

    //Scenario: Delete users in group(2/3)
    @When("user delete users in group and save the changes")
    public void user_delete_users_in_group_and_save_the_changes() {
        String[] groupList = (String[]) ThucydidesUtils.getFromSession("group_list_before");
        for (int i = 0; i < groupList.length; i++) {
            onOpened(ManageGroupsPage.class)
                    .selectByIndexGroup(i);
            String[] usersInGroup = onOpened(ManageGroupsPage.class).userInGroup();
            if (usersInGroup.length > 0) {
                int randomIndexUser = new Random().nextInt(usersInGroup.length);
                onOpened(ManageGroupsPage.class)
                        .selectByIndexUserInGroup(randomIndexUser)
                        .moveUserOut()
                        .saveChangesForGroup();
                ThucydidesUtils.putToSession("groupIndex", i - 1);
                String[] userAfter = removeElementInArray(usersInGroup, randomIndexUser);
                ThucydidesUtils.putToSession("listUser", convertArrayToString(userAfter));
                i = groupList.length;
            }
        }

    }

    // Scenario: Add users in group(2/3)
    @When("user add users  in group and save the changes")
    public void user_add_users_in_group_and_save_the_changes() {
        String[] groupList = (String[]) ThucydidesUtils.getFromSession("group_list_before");
        String[] usersOutGroup = null;
        String[] usersInGroup = null;
        int randomIndexUser = 0;
        String user = null;
        int i = 0;
        boolean flag = false;
        while (flag == false && i < groupList.length) {
            onOpened(ManageGroupsPage.class)
                    .selectByIndexGroup(i)
                    .userOutGroup();
            usersInGroup = onOpened(ManageGroupsPage.class).userInGroup();
            if (usersOutGroup.length != 0) {
                randomIndexUser = new Random().nextInt(usersOutGroup.length);
                user = onOpened(ManageGroupsPage.class).getTextUserOutGroupByIndex(randomIndexUser);
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
        ThucydidesUtils.putToSession("listUser", convertArrayToString(usersAfterChange));

    }

    //Scenario: Public group(3/3)
    @Then("unlogged user can see group")
    public void unlogged_user_can_see_group() {
        open(MainPageLogged.class)
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut();
        String user = ThucydidesUtils.getFromSession("user").toString();
        String publicGroup = ThucydidesUtils.getFromSession("publicGroup").toString();
        String userNotFriend = getDBDate().friends().findFriendWithoutGroup(user);
        open(LoginPageUnlogged.class)
                .authorizeBy(userNotFriend, getDBDate().userData().getUserPassword(userNotFriend));
        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."))
                .openFilters();
        String nameOfGroup = onOpened(FriendsFeedLogged.class).getGroups();
        verify().that(nameOfGroup.indexOf(publicGroup) != -1)
                .ifResultIsExpected("Group is public")
                .ifElse("Group is not Public")
                .finish();

    }

    //Scenario: Change the position of the group(3/4)
    @Then("the changes displayed correctly on Manage Groups Page")
    public void the_changes_displayed_correctly_on_Manage_Groups_Page() {
        System.out.println("22222");
        open(ManageGroupsPage.class);
        String groupListBefore = ThucydidesUtils.getFromSession("groupList").toString();
        String[] groupListAfter = onOpened(ManageGroupsPage.class).getAllGroupForUser();
        verify().that(convertArrayToString(groupListAfter).equals(groupListBefore))
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
        String groupListBefore = onOpened(ManageGroupsPage.class).deleteSecurityInGroups(ThucydidesUtils.getFromSession("groupList").toString());
        String user = ThucydidesUtils.getFromSession("user").toString();
        System.out.println("!!!" + groupListBefore);

        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."))
                .openFilters();
        String nameOfGroup = onOpened(FriendsFeedLogged.class).getGroups();
        System.out.println("!!!" + nameOfGroup);
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

    // Scenario: Add users in group(3/3)
    //Scenario: Delete users in group(3/3)
    @Then("in group displayed correct user")
    public void in_group_displayed_correct_user() {
        String groupIndex = ThucydidesUtils.getFromSession("groupIndex").toString();
        open(ManageGroupsPage.class)
                .selectByIndexGroup(Integer.parseInt(groupIndex));
        String users = ThucydidesUtils.getFromSession("listUser").toString();
        String usersAfter = convertArrayToString(onOpened(ManageGroupsPage.class).userInGroup());
        verify().that(usersAfter.equals(users))
                .ifResultIsExpected("User delete success")
                .ifElse("User not Delete")
                .finish();
    }

    ////////////////////////////////
    private String convertArrayToString(String[] array) {
        StringBuilder result = new StringBuilder();
        for (String array1 : array) {
            result.append(array1);
        }
        return result.toString();
    }

    private String[] removeElementInArray(String[] array, int index) {
        String[] newArray = new String[array.length - 1];
        int v = 0;
        for (int i = 0; i < array.length; i++) {
            if (v == index && v != (array.length - 1)) {
                newArray[i] = array[v + 1];
                v = v + 2;
                System.out.println(newArray[i]);
            } else if ((v == array.length - 1) && (v == index)) {
                return newArray;
            } else if (v != index && v < array.length) {
                newArray[i] = array[v];
                v++;
                System.out.println(newArray[i]);
            }
        }
        return newArray;
    }

    private String[] changeElementInArray(String[] array, int index, String newName) {
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

    private String[] addElementToArray(String[] arr, String element) {
        String[] newArr = new String[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = element;
        return newArr;
    }

    private String[] changeArrayElements(String[] array, TwoRandomIndexNotEquals results) {
        String dop = array[results.indexMoveUp];
        array[results.indexMoveUp] = array[results.indexMoveUp - 1];
        array[results.indexMoveUp - 1] = dop;

        dop = array[results.indexMoveDown];
        array[results.indexMoveDown] = array[results.indexMoveDown + 1];
        array[results.indexMoveDown + 1] = dop;

        return array;
    }
}
