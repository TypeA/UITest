package com.livejournal.uitests.pages.service_pages.settings.edit_profile;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import java.util.List;
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

    // @FindBy(css = ".field_change-userpic a")
    // private Link changeUserpicLink;
    /*
    @FindBy(name = "gender")
    private Select genderSelect;

    @FindBy(name = "day")
    private Select daySelect;

    @FindBy(name = "month")
    private Select monthSelect;

    @FindBy(name = "year")
    private Select yearSelect;

    @FindBy(name = "opt_sharebday")
    private Select birthdayPrivacy;

    @FindBy(name = "opt_showbday")
    private Select birthdayDisplayOption;

    @FindBy(name = "opt_showschools")
    private Select schoolPrivacy;

    @FindBy(css = ".field_link.field_link--school.nowrap")
    private Link manageSchools;
     */
    @StepGroup
    public void setName(String name) {
        /*WebElement profileInputName = getDriver().findElement(By.xpath("//div//input[@name='name']"));
        profileInputName.clear();
        profileInputName.sendKeys(name);*/
        this.startScript("jQuery('.field_input input').val('" + name + "')");
    }

    @StepGroup
    public String getName() {
        WebElement profileInputName = getDriver().findElement(By.xpath("//div//input[@name='name']"));
        return this.startScript("return jQuery('.field_input input').val()").toString();
    }
    /*
    @StepGroup
    public void setGender(String gender) {
        genderSelect.selectByValue(gender);//use value U M F
    }

    @StepGroup
    public void setBirthday(String day, String month, String year) {
        daySelect.selectByValue(day);
        monthSelect.selectByValue(month);
        yearSelect.selectByValue(year);
    }
    
    @StepGroup 
    public void setBirthdayPrivacy(String privacy) {
        birthdayPrivacy.selectByValue(privacy);
    }
    
   
     */
}
