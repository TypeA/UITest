
package com.livejournal.uitests.pages.service_pages.settings.school;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author p.kulich
 */
@DefaultUrl("/schools/")
public class SchoolsDirectory extends ServicePageLogged {
    @FindBy(xpath = "//form//button[text()='Add']")
    private Button addButton;

    @FindBy(xpath = "//button[text()='Save Changes']")
    private Button saveButton;

    public SchoolsDirectory setSchool() {
        addButton.click();
        return this;
    }

    public String getAlertMessage(){
        return startScript("return jQuery(\".alternating-rows div font\").text()").toString();
    }

    public SchoolsDirectory setYearStart(String year, String schoolid) {
        startScript("return jQuery(\"input[name='" + schoolid + ":year_start']\").val(" + year + ")");
        return this;
    }

    public SchoolsDirectory setYearEnd(String year, String schoolid) {
        startScript("return jQuery(\"input[name='" + schoolid + ":year_end']\").val(" + year + ")");
        return this;
    }
    
    public SchoolsDirectory saveChanges(){
        saveButton.click();
        return this;
    }
}
