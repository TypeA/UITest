package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
public class SuccessfulFinishForm extends FinishForm {

    @FindBy(css = "a[href*='/changeemail.bml']")
    private Link changeEmail;

    @FindBy(css = "a[href*='/register.bml']")
    private Link validateEmail;

    @FindBy(css = "a[href*='/manage/profile']")
    private Link editProfile;

    @FindBy(css = "a[href*='/friends/find']")
    private Link findFiends;

    @FindBy(css = "a[href*='/customize']")
    private Link customizeJournal;

    @FindBy(css = "a[href*='/friends']:not([href*='/find'])")
    private Link frendsFeed;

    @FindBy(css = "a[href*='/ratings']")
    private Link ratings;

    @FindBy(id = "createpage_post")
    private Button createFirstPostButton;

    public Button getCreateFirstPostButton() {
        return elem(createFirstPostButton);
    }

    public Link getChangeEmail() {
        return elem(changeEmail);
    }

    public Link getValidateEmail() {
        return elem(validateEmail);
    }

    public Link getEditProfile() {
        return elem(editProfile);
    }

    public Link getFindFiends() {
        return elem(findFiends);
    }

    public Link getCustomizeJournal() {
        return elem(customizeJournal);
    }

    public Link getFrendsFeed() {
        return elem(frendsFeed);
    }

    public Link getRatings() {
        return elem(ratings);
    }

}
