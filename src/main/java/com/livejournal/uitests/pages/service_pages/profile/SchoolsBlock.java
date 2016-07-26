
package com.livejournal.uitests.pages.service_pages.profile;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import java.util.ArrayList;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author p.kulich
 */
@Block(
        @FindBy(css = ".b-profile-group.b-profile-userinfo"))
public class SchoolsBlock extends UIBlock {

    @StepGroup
    public ArrayList<String> getSchoolList() {
        ArrayList<WebElement> schools = new ArrayList<WebElement>();
        ArrayList<String> school_list = new ArrayList<String>();
        schools = (ArrayList<WebElement>) findElements(By.cssSelector
        (".b-profile-group-row.b-profile-group-school ul li a"));
        for (int i = 0; i < schools.size(); i++) {
            school_list.add(schools.get(i).getText());
        }
        return school_list;
    }
}
