package com.livejournal.uitests.pages.service_pages.medius.admin.update;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.LJPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@DefaultUrl("/admin/medius/create")
public class MediusUpdateBml extends LJPage {

    @FindBy(name = "dialog-cancel")
    private Button closeDraftButton;

    @FindBy(css = ".b-updatepage-input.b-updatepage-input-subject")
    private TextField subject;

    @FindBy(css = ".b-updatepage-input.b-updatepage-input-lead")
    private TextField lead;

    @FindBy(css = ".b-updateform-textarea")
    private TextField body;

    @FindBy(name = "medius_category")
    private Select category;

    @FindBy(xpath = "//button[@name='action:update']")
    private Button postToMedius;

    @FindBy(xpath = "//label[contains(.,'interesting')]/input")
    private UIElement interesting;

    @FindBy(xpath = "//label[contains(.,'main')]/input")
    private UIElement main;


    public boolean adminCanNotChangeDateUserAndPrivacy() {
        boolean changeOfName = getDriver().findElements(By.className("b-updatepage-login-change")).isEmpty();
        boolean changeOfData = getDriver().findElement(By.xpath("//span[@class='b-updatepage-date-current']/a[@class='b-pseudo']")).isDisplayed();
        boolean changeOfPrivacy = getDriver().findElement(By.cssSelector(".b-updatepage-field.b-updatepage-field-security")).isDisplayed();
        return changeOfName || changeOfData || changeOfPrivacy;
    }

    @StepGroup
    public void setPostText(String boby) {
        this.body.enter(boby);
    }


    public MediusUpdateBml enterTextInTemaLeadBody(String subject, String lead, String body) {
        this.subject.enter(subject);
        this.lead.enter(lead);
        setPostText(body);
        return this;
    }

    public MediusUpdateBml closeDraft() {
        try {
            closeDraftButton.click();
        } catch (Exception ex) {
        }
        return this;
    }


    public MediusUpdateBml selectCategory(String category) {
        this.category.selectByVisibleText(category);
        return this;
    }

    public MediusUpdateBml setInteresting() {
        interesting.click();
        return this;
    }

    public MediusUpdateBml setMainPost(){
        main.click();
        return this;
    }

    public MediusUpdateBml enterSource(String source, int number) {
        getDriver().findElement(By.xpath("//input[@update-links-list-input='" + number + "']")).sendKeys(source);

        return this;
    }

    public void postToMedius() {
        postToMedius.click();
    }
}