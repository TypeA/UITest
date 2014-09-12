package com.livejournal.uitests.pages.service_pages.create_account_pages.finish_form;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.settings.CustomizeJournalPage;
import com.livejournal.uitests.pages.service_pages.settings.EditProfilePage;
import com.livejournal.uitests.pages.service_pages.settings.FindFriendsPage;
import com.livejournal.uitests.pages.service_pages.settings.email.ChangeEmailPage;
import com.livejournal.uitests.pages.service_pages.settings.email.ValidateEmailPage;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPage;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
public class SuccessfulFinishForm extends FinishForm {

    @FindBy(css = "a[href*='/changeemail.bml']")
    private Link changeEmailLink;

    @FindBy(css = "a[href*='/register.bml']")
    private Link validateEmailLink;

    @FindBy(css = "a[href*='/manage/profile']")
    private Link editProfileLink;

    @FindBy(css = "a[href*='/friends/find']")
    private Link findFiendsLink;

    @FindBy(css = "a[href*='/customize']")
    private Link customizeJournalLink;

    @FindBy(css = "a[href*='/friends']:not([href*='/find'])")
    private Link frendsFeedLink;

    @FindBy(css = "a[href*='/ratings']")
    private Link ratingsLink;

    @FindBy(id = "createpage_post")
    private Button createFirstPostButton;

    public ChangeEmailPage clickOnChangeEmailLink() {
        changeEmailLink.click();
        return on(ChangeEmailPage.class);
    }

    public ValidateEmailPage clickOnValidateEmailLink() {
        validateEmailLink.click();
        return on(ValidateEmailPage.class);
    }

    public EditProfilePage clickOnEditProfileLink() {
        editProfileLink.click();
        return on(EditProfilePage.class);
    }

    public FindFriendsPage clickOnFindFiendsLink() {
        findFiendsLink.click();
        return on(FindFriendsPage.class);
    }

    public CustomizeJournalPage clickOnCustomizeJournalLink() {
        customizeJournalLink.click();
        return on(CustomizeJournalPage.class);
    }

    public FriendsFeedLogged clickOnFrendsFeedLink() {
        frendsFeedLink.click();
        return on(FriendsFeedLogged.class);
    }

    public MainPageLogged clickOnRatingsLink() {
        ratingsLink.click();
        return on(MainPageLogged.class);
    }

    public UpdateBmlPage createFirstPost() {
        createFirstPostButton.click();
        return on(UpdateBmlPage.class);
    }

}
