
package com.livejournal.uitests.pages.service_pages.profile;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import java.util.ArrayList;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author p.kulich
 */
@DefaultUrl("/profile")
public class SchoolsBlock extends UIBlock{
    
     @StepGroup
    public ArrayList<String> getSchoolList() {
         System.out.println("++++ GET SCHOOL LIST");
        ArrayList<WebElement> schools = new ArrayList<WebElement>();
        ArrayList<String> school_list = new ArrayList<>();
        schools = (ArrayList<WebElement>) findElements(By.cssSelector(".b-profile-group-row.b-profile-group-school li"));
        
        for (int i = 0; i < schools.size(); i++) {
           school_list.add(schools.get(i).toString());
            System.out.println("elements " + school_list.get(i));
        }
        return school_list;
    }
}
