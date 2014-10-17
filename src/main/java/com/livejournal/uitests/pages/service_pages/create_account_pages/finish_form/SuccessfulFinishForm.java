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
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-panel-step2"))
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
        return onOpened(ChangeEmailPage.class);
    }

    public ValidateEmailPage clickOnValidateEmailLink() {
        validateEmailLink.click();
        return onOpened(ValidateEmailPage.class);
    }

    public EditProfilePage clickOnEditProfileLink() {
        editProfileLink.click();
        return onOpened(EditProfilePage.class);
    }

    public FindFriendsPage clickOnFindFiendsLink() {
        findFiendsLink.click();
        return onOpened(FindFriendsPage.class);
    }

    public CustomizeJournalPage clickOnCustomizeJournalLink() {
        customizeJournalLink.click();
        return onOpened(CustomizeJournalPage.class);
    }

    public FriendsFeedLogged clickOnFrendsFeedLink() {
        frendsFeedLink.click();
        return onOpened(FriendsFeedLogged.class);
    }

    public MainPageLogged clickOnRatingsLink() {
        ratingsLink.click();
        return onOpened(MainPageLogged.class);
    }

    public UpdateBmlPageLogged createFirstPost() {
        createFirstPostButton.click();
        return onOpened(UpdateBmlPageLogged.class);
    }

    @WhenPageOpens
    public void waitBlock() throws InterruptedException {
        Thread.sleep(1500);
    }

}
