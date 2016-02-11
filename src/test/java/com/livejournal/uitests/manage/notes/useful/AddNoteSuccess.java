package com.livejournal.uitests.manage.notes.useful;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePage;
import com.livejournal.uitests.pages.service_pages.settings.ManageNote;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageFriendsPage;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AddNoteSuccess extends LJTest {

    @Given("logged user $user on Edit Friend Page")
    public void logged_user_on_Edit_Friend_Page(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                .defaultLanguageLogged(user)
                .setDefaultStyle(user);
    }

    @When("user $user add note for friend")
    public void user_add_note_for_friend(String user) {
        ArrayList<String> friends = getDBDate().friends().getAllFriends(user);
        System.out.println("11111111");
        ArrayList<String> usersNote = open(ManageNote.class).getAllUserNote();
        System.out.println("11111111");
        String friendNotInListNote = UserNotInNoteList(user, usersNote, friends);
        System.out.println("11111111");
        String note = utility().random().getRandomChar(7);
        System.out.println("11111111");
        open(ManageFriendsPage.class)
                .addNoteToFriend(friendNotInListNote, note);
        System.out.println("11111111");
        ThucydidesUtils.putToSession("friend", friendNotInListNote);
        ThucydidesUtils.putToSession("note", note);
    }

    @Then("username friend with asterisk and note is displayed on Friends Page")
    public void username_friend_with_asterisk_and_note_is_displayed_on_Friends_Page() {
        String user = ThucydidesUtils.getFromSession("friend").toString();
        String note = ThucydidesUtils.getFromSession("note").toString();
        open(ManageFriendsPage.class);
        verify().that(onOpened(ManageFriendsPage.class).friendWithNoteExist(user, note))
                .ifResultIsExpected("Note =" + note + " for friend " + user + " is displayed on Friends Page")
                .ifElse("Note =" + note + " for friend " + user + " is not displayed on Friends Page")
                .finish();
    }

    @Then("username friend with note is displayed on Manage Note")
    public void username_friend_with_note_is_displayed_on_Manage_Note() {
        String user = ThucydidesUtils.getFromSession("friend").toString();
        String note = ThucydidesUtils.getFromSession("note").toString();
        verify().that(open(ManageNote.class).noteIsDisplayed(user, note))
                .ifResultIsExpected("Note =" + note + " for user " + user + " is displayed on Manage Note Page")
                .ifElse("Note =" + note + " for user " + user + " is not displayed on Manage Note Page")
                .finish();
    }

    @Then("note is displayed on user profile")
    public void note_is_displayed_on_user_profile() {
        String userWithNote = ThucydidesUtils.getFromSession("userWithNote").toString();
        String note = ThucydidesUtils.getFromSession("note").toString();
        verify().that(open(ProfilePage.class)
                .noteIsDisplayed(userWithNote, note))
                .ifResultIsExpected("Note = " + note + " is displayed in user " + userWithNote + " profile")
                .ifElse("Note = " + note + " is not displayed in user " + userWithNote + " profile")
                .finish();
    }

    @When("user $user add note for user $user_status")
    public void add_note_for_user(String user, String user_status) {
        String note = utility().random().getRandomText(7);
        ArrayList<String> usersNote = onOpened(ManageNote.class).getAllUserNote();
        String userAddNote = UserNotInNoteList(user, usersNote, getDBDate().userData().getUserWithStatus(user_status));
        onOpened(ManageNote.class)
                .addNote(userAddNote, note);
        ThucydidesUtils.putToSession("userWithNote", userAddNote);
        ThucydidesUtils.putToSession("note", note);
    }

    private String UserNotInNoteList(String user, ArrayList<String> userWithNote, ArrayList<String> usersOther) {
        String friendNotInListNote = usersOther.get(0);
        for (int i = 0; i < usersOther.size(); i++) {
            if ((userWithNote.indexOf(usersOther.get(i)) < 0) && (!usersOther.get(i).equals(user))) {
                friendNotInListNote = usersOther.get(i);
                break;
            }
        }
        return friendNotInListNote;
    }
}
