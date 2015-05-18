package com.livejournal.uitests.friends.useful.manage_friends_groups;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageGroupsPage;
import com.livejournal.uitests.utility.RandomText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

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
        ArrayList<String> groupListBefore = new ArrayList<String>();
        groupListBefore = open(ManageGroupsPage.class)
                .getAllGroupForUser();
        ThucydidesUtils.putToSession("user", name);
        ThucydidesUtils.putToSession("group_list_before", groupListBefore);
    }

    //Scenario: Change the position of the group(2/4)
    @When("user moves the group up and moves the group down and save the changes")
    public void user_moves_the_group_up_and_moves_the_group_down_and_save_the_changes() {
        ArrayList<String> groupListBefore = (ArrayList<String>) ThucydidesUtils.getFromSession("group_list_before");
        TwoRandomIndexNotEquals results = new TwoRandomIndexNotEquals(groupListBefore.size());
        onOpened(ManageGroupsPage.class)
                .moveGroup(results.indexMoveUp, "up")
                .moveGroup(results.indexMoveDown, "down")
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("groupList", convertArrayToString(changeArrayElements(groupListBefore, results)));
    }

    //Scenario: Public group(2/3)
    @When("user set the group is public and save the changes")
    public void user_set_the_group_is_public_and_save_the_changes() {
        ArrayList<String> groupListBefore = (ArrayList<String>) ThucydidesUtils.getFromSession("group_list_before");
        int randomIndex = new Random().nextInt(groupListBefore.size());
        String groupName = onOpened(ManageGroupsPage.class)
                .clickPrivacy(randomIndex, "private")
                .getTextInGroupListByIndex(randomIndex);
        onOpened(ManageGroupsPage.class)
                .saveChangesForGroup();
        open(ManageGroupsPage.class)
                .clickPrivacy(randomIndex, "public")
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("publicGroup", groupName);
    }

    //Scenario: Create new group(2/4)
    @When("user create new group and save the changes")
    public void user_create_new_group_and_save_the_changes() {
        String group = RandomText.getRandomText(10);
        String groups = convertArrayToString((ArrayList<String>) ThucydidesUtils.getFromSession("group_list_before")) + group;
        onOpened(ManageGroupsPage.class)
                .createNewGroup(group)
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("groupList", groups);
        ThucydidesUtils.putToSession("newGroup", group);
    }

    //Scenario: Delete group(2/3)
    @When("user delete group and save the changes")
    public void user_delete_group_and_save_the_changes() {
        ArrayList<String> groupListBefore = (ArrayList<String>) ThucydidesUtils.getFromSession("group_list_before");
        int randomIndex = new Random().nextInt(groupListBefore.size());
        onOpened(ManageGroupsPage.class)
                .clickDeleteGroup(randomIndex)
                .saveChangesForGroup();
        groupListBefore.remove(randomIndex);
        ThucydidesUtils.putToSession("groupList", onOpened(ManageGroupsPage.class).deleteSecurityInGroups(convertArrayToString(groupListBefore)));
    }

    //Scenario: Rename group name(2/3)
    @When("user rename group name and save the changes")
    public void user_rename_group_name_and_save_the_changes() {
        ArrayList<String> groupListBefore = (ArrayList<String>) ThucydidesUtils.getFromSession("group_list_before");
        String group = RandomText.getRandomText(10);
        int randomIndex = new Random().nextInt(groupListBefore.size());
        onOpened(ManageGroupsPage.class)
                .renameGroup(randomIndex, group)
                .saveChangesForGroup();
        ArrayList<String> groupListAfter = changeElementInArray(groupListBefore, randomIndex, group);
        ThucydidesUtils.putToSession("groupList", onOpened(ManageGroupsPage.class).deleteSecurityInGroups(convertArrayToString(groupListAfter)));
    }

    //Scenario: Delete users in group(2/3)
    @When("user delete users in group and save the changes")
    public void user_delete_users_in_group_and_save_the_changes() {
        ArrayList<String> groupList = (ArrayList<String>) ThucydidesUtils.getFromSession("group_list_before");
        int i = 0;
        while (i < groupList.size()) {
            onOpened(ManageGroupsPage.class)
                    .selectByIndexGroup(i);
            ArrayList<String> usersInGroup = onOpened(ManageGroupsPage.class).usersInGroup();
            if (usersInGroup.size() > 0) {
                int randomIndexUser = new Random().nextInt(usersInGroup.size());
                onOpened(ManageGroupsPage.class)
                        .moveUserOut(randomIndexUser)
                        .saveChangesForGroup();
                ThucydidesUtils.putToSession("groupIndex", i);
                usersInGroup.remove(randomIndexUser);
                ThucydidesUtils.putToSession("listUser", convertArrayToString(usersInGroup));
                i = groupList.size();
            }
            i++;
        }
    }

    // Scenario: Add users in group(2/3)
    @When("user add users in group and save the changes")
    public void user_add_users_in_group_and_save_the_changes() {
        ArrayList<String> groupList = (ArrayList<String>) ThucydidesUtils.getFromSession("group_list_before");
        ArrayList<String> usersOutGroup = null;
        ArrayList<String> usersInGroup;
        int randomIndexUser;
        String user;
        int i = 0;
        while (i < groupList.size()) {
            usersOutGroup = onOpened(ManageGroupsPage.class)
                    .selectByIndexGroup(i)
                    .userOutGroup();
            usersInGroup = onOpened(ManageGroupsPage.class).usersInGroup();
            if (!usersOutGroup.isEmpty()) {
                randomIndexUser = new Random().nextInt(usersOutGroup.size());
                user = onOpened(ManageGroupsPage.class).getTextUserOutGroupByIndex(randomIndexUser);
                onOpened(ManageGroupsPage.class)
                        .moveUserIn(randomIndexUser)
                        .saveChangesForGroup();
                ThucydidesUtils.putToSession("groupIndex", i);
                usersInGroup.add(user);
                Collections.sort(usersInGroup);
                ThucydidesUtils.putToSession("listUser", convertArrayToString(usersInGroup));
                i = groupList.size();
            }
            i++;
        }

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
        verify().that(nameOfGroup.contains(publicGroup))
                .ifResultIsExpected("Group is public")
                .ifElse("Group is not Public")
                .finish();

    }

    //Scenario: Change the position of the group(3/4)
    @Then("the changes displayed correctly on Manage Groups Page")
    public void the_changes_displayed_correctly_on_Manage_Groups_Page() {
        open(ManageGroupsPage.class);
        String groupListBefore = ThucydidesUtils.getFromSession("groupList").toString();
        ArrayList<String> groupListAfter = onOpened(ManageGroupsPage.class).getAllGroupForUser();
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
        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."))
                .openFilters();
        String nameOfGroup = onOpened(FriendsFeedLogged.class).getGroups();
        verify().that(nameOfGroup.contains(groupListBefore))
                .ifResultIsExpected("Group is changed success")
                .ifElse("Not change")
                .finish();
    }

    //Scenario: Create new group(4/4)
    @Then("there are no posts in the new group")
    public void there_are_no_posts_in_the_new_group() {
        String newGroup = ThucydidesUtils.getFromSession("newGroup").toString();
        String user = ThucydidesUtils.getFromSession("user").toString();
        Boolean emptyFeed = open(FriendsFeedLogged.class, new Url().setPostfix("/" + newGroup)
                .setPrefix(user + "."))
                .feedIsEmpty();
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
        String usersAfter = convertArrayToString(onOpened(ManageGroupsPage.class).usersInGroup());
        verify().that(usersAfter.equals(users))
                .ifResultIsExpected("User move success")
                .ifElse("User not move")
                .finish();
    }

    ////////////////////////////////
    private String convertArrayToString(ArrayList<String> array) {
        String[] myArray;
        myArray = array.toArray(new String[array.size()]);
        StringBuilder result = new StringBuilder();
        for (String array1 : myArray) {
            result.append(array1);
        }
        return result.toString();
    }

    private ArrayList<String> changeElementInArray(ArrayList<String> array, int index, String newName) {
        ArrayList<String> newArray = new ArrayList<String>();
        array.set(index, newName);
        return newArray;
    }

    private ArrayList<String> changeArrayElements(ArrayList<String> array, TwoRandomIndexNotEquals results) {
        String dop = array.get(results.indexMoveUp);
        array.set(results.indexMoveUp, array.get(results.indexMoveUp - 1));
        array.set(results.indexMoveUp - 1, dop);

        dop = array.get(results.indexMoveDown);
        array.set(results.indexMoveDown, array.get(results.indexMoveDown + 1));
        array.set(results.indexMoveDown + 1, dop);

        return array;
    }
}
