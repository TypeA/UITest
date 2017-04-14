package com.livejournal.uitests.pages.service_pages.settings.edit_profile;

import com.livejournal.uisteps.thucydides.elements.UIBlock;

import java.util.ArrayList;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author p.kulich
 */
@Block(
        @FindBy(css = ".ng-scope.ng-pristine.ng-valid"))
public class IdentityBlock extends UIBlock {

    @FindBy(name = "gender")
    private Select genderSelect;

    @FindBy(name = "opt_sharebday")
    private Select birthdayPrivacy;

    @FindBy(name = "opt_showbday")
    private Select birthdayDisplayOption;

    
    @FindBy(name = "opt_showschools")
    private Select schoolPrivacy;
/*
    @FindBy(css = ".field_link.field_link--school.nowrap")
    private Link manageSchools;
     */
    
    
    
    @StepGroup
    public void setProfileName(String name) {
        WebElement profileInputName = getDriver().findElement(By.xpath("//div//input[@name='name']"));
        profileInputName.clear();
        profileInputName.sendKeys(name);
    }

    @StepGroup
    public void setBirthdayPrivacy(String privacy) {
        this.birthdayPrivacy.selectByValue(privacy);
    }

    @StepGroup
    public String getProfileName() {
        return this.startScript("return jQuery('.field_input input').val()").toString();
    }

    @StepGroup
    public void setGender(String gender) {
        genderSelect.selectByValue(gender);//use value U M F
    }

    @StepGroup
    public String getGender() {
        return genderSelect.getFirstSelectedOption().getText();
    }

    @StepGroup
    public void setBirthday(String year, String month, String day) {

        this.startScript("jQuery('[name=\"year\"]').val(" + year + ")");
        this.startScript("jQuery('[name=\"month\"]').val(" + month + ")");
        this.startScript("jQuery('[name=\"day\"]').val(" + day + ")");

    }

    @StepGroup
    public void setShowBirthdayPrivacy(String option) {
        birthdayDisplayOption.selectByValue(option);
    }

    @StepGroup
    public void setShowBDate(String param) {
        birthdayDisplayOption.selectByValue(param);
    }

    @StepGroup
    public ArrayList<String> getBirthday() {
        ArrayList<String> list = new ArrayList<>();

        list.add(this.startScript("return jQuery('[name=\"year\"]').val()").toString());
        list.add(this.startScript("return jQuery('[name=\"month\"]').val()").toString());
        list.add(this.startScript("return jQuery('[name=\"day\"]').val()").toString());

        return list;
    }
    
    @StepGroup
    public void setSchoolPrivacy(String privacy) {
        schoolPrivacy.selectByValue(privacy);
    }
    

}
