package com.livejournal.uitests.friends.personal.manage_friends_groups;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageGroupsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class ManageFriendsGroups extends LJTest {

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
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultLanguageLogged(name);
        List<ArrayList<String>> groupListBefore = getDBDate().friends().getSortAllGroup(name);
        ThucydidesUtils.putToSession("group_list_before", groupListBefore);
    }


//    Scenario: Change the position of the group(2/4)
    @When("user $name moves the group $position and save change")
    public void user_moves_the_group_and_save_change(String name, String position) {
        List<ArrayList<String>> groupListBefore = (List<ArrayList<String>>) ThucydidesUtils.getFromSession("group_list_before");
        String minOrMax = "min";
        if (position.equals("up")) {
            minOrMax = "min";
        } else if (position.equals("down")) {
            minOrMax = "max";
        }
        String moveGroup = getDBDate().friends().getRandomGroup(name, minOrMax);
        open(ManageGroupsPage.class)
                .moveGroup(moveGroup, position)
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("groupList", putDefaultViewToBegining(changeArrayElements(groupListBefore, moveGroup, position)));
    }

    //Scenario: Public group(2/3)
    @When("user (name $name) set the group is public and save the changes")
    public void user_set_the_group_is_public_and_save_the_changes(String name) {
        List<ArrayList<String>> groupListBefore = (List<ArrayList<String>>) ThucydidesUtils.getFromSession("group_list_before");
        String notPublicValueGroup = getDBDate().friends().getValuePublicGroup(name, false);
        open(ManageGroupsPage.class)
                .clickPrivacy(notPublicValueGroup, true)
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("publicGroup", getDBDate().friends().getNamePublicGroup(name, notPublicValueGroup));
    }

    //Scenario: Create new group(2/4)
    @When("user create new group and save the changes")
    public void user_create_new_group_and_save_the_changes() {
        String group = utility().random().getRandomChar(10);
        List<ArrayList<String>> groupListBefore = (List<ArrayList<String>>) ThucydidesUtils.getFromSession("group_list_before");
        open(ManageGroupsPage.class)
                .createNewGroup(group)
                .saveChangesForGroup();
        groupListBefore.get(0).add(group);
        ThucydidesUtils.putToSession("groupList", putDefaultViewToBegining(groupListBefore));
        ThucydidesUtils.putToSession("newGroup", group);
    }

    //Scenario: Delete group(2/3)
    @When("user (name $name) delete group and save the changes")
    public void user_delete_group_and_save_the_changes(String name) {
        List<ArrayList<String>> groupListBefore = (List<ArrayList<String>>) ThucydidesUtils.getFromSession("group_list_before");
        int randomIndex = new Random().nextInt(groupListBefore.size());
        String valueGroup = groupListBefore.get(3).get(randomIndex);
        open(ManageGroupsPage.class)
                .clickDeleteGroup(valueGroup)
                .saveChangesForGroup();
        for (int i = 0; i < groupListBefore.size(); i++) {
            groupListBefore.get(i).remove(randomIndex);
        }
        ThucydidesUtils.putToSession("groupList", groupListBefore);
    }
//
    //Scenario: Rename group name(2/3)
    @When("user (name $name) rename group name and save the changes")
    public void user_rename_group_name_and_save_the_changes(String name) {
        List<ArrayList<String>> groupListBefore = (List<ArrayList<String>>) ThucydidesUtils.getFromSession("group_list_before");
        String group = utility().random().getRandomChar(10);
        int randomIndex = new Random().nextInt(groupListBefore.size());
        String valueGroup = groupListBefore.get(3).get(randomIndex);
        open(ManageGroupsPage.class)
                .renameGroup(valueGroup, group)
                .saveChangesForGroup();
        groupListBefore.get(0).set(randomIndex, group);
        ThucydidesUtils.putToSession("groupList", groupListBefore);
    }

    //Scenario: Delete users in group(2/3)
    @When("user (name, $name) delete users in group and save the changes")
    public void user_delete_users_in_group_and_save_the_changes(String name) {
        ArrayList<String> groupList = (ArrayList<String>) ThucydidesUtils.getFromSession("group_list_before");
        ArrayList<String> groupAndFriend = getGroupAndFriendInGroup(name);
        String group = groupAndFriend.get(0);
        String friend = groupAndFriend.get(1);
        open(ManageGroupsPage.class)
                .moveUserOutByName(group, friend)
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("group", group);
        ThucydidesUtils.putToSession("userOutGroup", friend);

    }

    // Scenario: Add users in group(2/3)
    @When("user (name $name) add users in group and save the changes")
    public void user_add_users_in_group_and_save_the_changes(String name) {
        ArrayList<String> groupList = (ArrayList<String>) ThucydidesUtils.getFromSession("group_list_before");
        ArrayList<String> friendAndGroup = getGroupAndGetFriendNotInGroup(name);
        open(ManageGroupsPage.class)
                .moveUserInByName(friendAndGroup.get(1), friendAndGroup.get(0))
                .saveChangesForGroup();
        ThucydidesUtils.putToSession("userInGroup", friendAndGroup.get(0));
        ThucydidesUtils.putToSession("group", friendAndGroup.get(1));
    }

    //Scenario: Public group(3/3)
    @Then("unlogged user (name $name) can see group")
    public void unlogged_user_can_see_group(String name) {
        open(MainPageLogged.class)
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut();
        String publicGroup = ThucydidesUtils.getFromSession("publicGroup").toString();
        String userNotFriend = getDBDate().friends().getFriendWithoutGroup(name);
        open(LoginPageUnlogged.class)
                .authorizeBy(userNotFriend, getDBDate().userData().getUserPassword(userNotFriend));
        ArrayList<String> groupsOnFeed = open(FriendsFeedLogged.class, new Url().setPrefix(name + "."))
                .openFilters()
                .getAllGroups();
        verify().that(groupsOnFeed.contains(publicGroup))
                .ifResultIsExpected("Group is public")
                .ifElse("Group is not Public")
                .finish();

    }

    //Scenario: Change the position of the group(3/4)
    @Then("the changes displayed correctly on Manage Groups Page")
    public void the_changes_displayed_correctly_on_Manage_Groups_Page() {
        open(ManageGroupsPage.class);
        List<ArrayList<String>> groupListBefore = (List<ArrayList<String>>) ThucydidesUtils.getFromSession("groupList");
        ArrayList<String> groupListAfter = onOpened(ManageGroupsPage.class).getAllGroupForUser();
        verify().that(addPublicToGroup(groupListBefore).containsAll(groupListAfter))
                .ifResultIsExpected("Group move change success")
                .ifElse("Not change")
                .finish();

    }

    //Scenario: Change the position of the group(4/4)
    //Scenario: Create new group(3/4)
    //Scenario: Delete group(3/3)
    //Scenario: Rename group name(3/3)
    @Then("the changes displayed correctly on the Friends Feed (name $name)")
    public void the_changes_displayed_correctly_on_the_Friends_Feed(String name) {
        List<ArrayList<String>> groupListBefore = (List<ArrayList<String>>) ThucydidesUtils.getFromSession("groupList");
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."))
                .openFilters();
        ArrayList<String> nameOfGroup = onOpened(FriendsFeedLogged.class)
                .openFilters()
                .getGroups();
        verify().that(checkFiltersOnFeed(groupListBefore, nameOfGroup))
                .ifResultIsExpected("Group is changed success")
                .ifElse("Not change")
                .finish();
    }
//
    //Scenario: Create new group(4/4)
    @Then("there are no posts in the new group (name $name)")
    public void there_are_no_posts_in_the_new_group(String name) {
        String newGroup = ThucydidesUtils.getFromSession("newGroup").toString();
        Boolean emptyFeed = open(FriendsFeedLogged.class, new Url().setPostfix("/" + newGroup)
                .setPrefix(name + "."))
                .feed()
                .feedIsEmpty();
        verify().that(emptyFeed)
                .ifResultIsExpected("Feed is empty")
                .ifElse("Feed not Empty")
                .finish();
    }

    // Scenario: Add users in group(3/3)
    @Then("user added to group")
    public void user_added_to_group() {
        String group = ThucydidesUtils.getFromSession("group").toString();
        ArrayList<String> usersInGroup = open(ManageGroupsPage.class)
                .selectByValueGroup(group)
                .getAllUserInGroup();
        String userAdd = ThucydidesUtils.getFromSession("userInGroup").toString();
        verify().that(usersInGroup.contains(userAdd))
                .ifResultIsExpected("User move success")
                .ifElse("User not move")
                .finish();
    }

    //Scenario: Delete users in group(3/3)
    @Then("user deleted from group")
    public void user_deleted_from_group() {
        String group = ThucydidesUtils.getFromSession("group").toString();
        ArrayList<String> usersInGroup = open(ManageGroupsPage.class)
                .selectByValueGroup(group)
                .getAllUserInGroup();
        ArrayList<String> usersOutGroup = open(ManageGroupsPage.class)
                .selectByValueGroup(group)
                .getAllUserOutGroup();
        String userOut = ThucydidesUtils.getFromSession("userOutGroup").toString();
        verify().that(!usersInGroup.contains(userOut))
                .ifResultIsExpected("User not in group")
                .ifElse("User in group")
                .and()
                .that(usersOutGroup.contains(userOut))
                .ifResultIsExpected("User is in list groupOut")
                .ifElse("User is not in list groupout")
                .finish();
    }

    private List<ArrayList<String>> changeArrayElements(List<ArrayList<String>> arrayList, String moveGroup, String position) {
        int indexMoveGroup = arrayList.get(3).indexOf(moveGroup);
        if (position.equals("up")) {
            for (int i = 0; i < arrayList.size(); i++) {
                String b = arrayList.get(i).get(indexMoveGroup);
                arrayList.get(i).set(indexMoveGroup, arrayList.get(i).get(indexMoveGroup - 1));
                arrayList.get(i).set(indexMoveGroup - 1, b);
            }
        } else if (position.equals("down")) {
            for (int i = 0; i < arrayList.size(); i++) {
                String b = arrayList.get(i).get(indexMoveGroup);
                arrayList.get(i).set(indexMoveGroup, arrayList.get(i).get(indexMoveGroup + 1));
                arrayList.get(i).set(indexMoveGroup + 1, b);
            }
        }
        return arrayList;
    }

    private ArrayList<String> addPublicToGroup(List<ArrayList<String>> arraylist) {
        ArrayList<String> groupList = new ArrayList<String>();
        for (int t = 0; t < arraylist.get(0).size(); t++) {
            groupList.add(t, arraylist.get(0).get(t));
        }
        for (int i = 0; i < groupList.size(); i++) {
            if (arraylist.get(2).get(i).equals("1")) {
                groupList.set(i, groupList.get(i) + " (public)");
            }
        }
        return groupList;
    }

    private List<ArrayList<String>> removePublicInGroup(List<ArrayList<String>> arraylist) {
        for (int i = 0; i < arraylist.get(0).size(); i++) {
            if (arraylist.get(2).get(i).equals("1")) {
                arraylist.get(0).set(i, arraylist.get(0).get(i).replace(" (public)", ""));
            }
        }
        return arraylist;
    }

    private List<ArrayList<String>> putDefaultViewToBegining(List<ArrayList<String>> grouplistBefore) {
        int indexDefaultView = -1;
        for (int i = 0; i < grouplistBefore.get(0).size(); i++) {
            if (grouplistBefore.get(0).get(i).equalsIgnoreCase("default view")) {
                indexDefaultView = i;
                break;
            }
        }
        if (indexDefaultView != -1) {
            grouplistBefore.get(0).add(0, grouplistBefore.get(0).get(indexDefaultView));
            grouplistBefore.get(0).remove(indexDefaultView + 1);
        }
        return grouplistBefore;
    }

    private boolean checkFiltersOnFeed(List<ArrayList<String>> grouplist, ArrayList<String> filterFeed) {
        int index = 0;
        boolean checkFilter = true;
        ArrayList<String> list = new ArrayList();
        if (grouplist.get(0).get(0).equalsIgnoreCase("default view")) {
            list.add(grouplist.get(0).get(0));
            index = 1;
            list.add("Journals Only");
            list.add("Communities Only");
            list.add("Syndicated Feeds");
            for (int t = 1; t < grouplist.get(0).size(); t++) {
                list.add(grouplist.get(0).get(t));
            }
            list.add("All Friends");
            list.add("Settings");
        } else {
            list.add("All Friends");
            list.add("Journals Only");
            list.add("Communities Only");
            list.add("Syndicated Feeds");
            for (int t = 0; t < grouplist.get(0).size(); t++) {
                list.add(grouplist.get(0).get(t));
            }
            list.add("Settings");
        }
        for (int r = 0; r < grouplist.get(0).size(); r++) {
            checkFilter = checkFilter && list.get(r).equalsIgnoreCase(filterFeed.get(r));
        }
        return checkFilter;
    }

    private ArrayList<String> getGroupAndGetFriendNotInGroup(String user) {
        List<ArrayList<String>> allGroups = getDBDate().friends().getSortAllGroup(user);
        ArrayList<String> allFriends = getDBDate().friends().getAllFriends(user);
        ArrayList<String> groupAndFriend = new ArrayList();

        for (int i = 0; i < allGroups.size(); i++) {
            ArrayList<String> allFriendsInGroup = getDBDate().friends().getAllFriendsInGroup(user, allGroups.get(0).get(i));
            for (int t = 0; t < allFriends.size(); t++) {
                if (allFriendsInGroup.indexOf(allFriends.get(t)) == -1) {
                    groupAndFriend.add(allFriends.get(t));
                    break;
                }
            }
            if (!groupAndFriend.isEmpty()) {
                groupAndFriend.add(allGroups.get(3).get(i));
                break;
            }
        }
        return groupAndFriend;
    }

    private ArrayList<String> getGroupAndFriendInGroup(String user) {
        List<ArrayList<String>> allGroups = getDBDate().friends().getSortAllGroup(user);
        ArrayList<String> groupAndFriend = new ArrayList();
        for (int i = 0; i < allGroups.size(); i++) {
            ArrayList<String> allFriendsInGroup = getDBDate().friends().getAllFriendsInGroup(user, allGroups.get(0).get(i));
            if (!allFriendsInGroup.isEmpty()) {
                groupAndFriend.add(allGroups.get(3).get(i));
                groupAndFriend.add(allFriendsInGroup.get(new Random().nextInt(allFriendsInGroup.size())));
                break;
            }

        }
        return groupAndFriend;
    }
}
