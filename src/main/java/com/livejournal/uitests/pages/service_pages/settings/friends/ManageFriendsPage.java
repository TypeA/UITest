package com.livejournal.uitests.pages.service_pages.settings.friends;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.finish_form.FinishForm;
import java.util.ArrayList;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/friends/edit.bml")
public class ManageFriendsPage extends ServicePageLogged {

    @FindBy(name = "editfriend_add_1_user")
    private TextField friend_1;

    @FindBy(name = "editfriend_add_2_user")
    private TextField friend_2;

    @FindBy(name = "editfriend_add_3_user")
    private TextField friend_3;

    @FindBy(name = "editfriend_add_4_user")
    private TextField friend_4;

    @FindBy(name = "editfriend_add_5_user")
    private TextField friend_5;

    @FindBy(name = "editfriend_add_6_user")
    private TextField friend_6;

    @FindBy(name = "editfriend_add_7_user")
    private TextField friend_7;

    @FindBy(name = "editfriend_add_8_user")
    private TextField friend_8;

    @FindBy(name = "editfriend_add_9_user")
    private TextField friend_9;

    @FindBy(name = "editfriend_add_10_user")
    private TextField friend_10;

    @FindBy(css = ".b-standout .b-flatbutton")
    private Button saveChanges;

    public FinishForm clickSaveChangesButton() {
        saveChanges.click();
        return onDisplayed(FinishForm.class);
    }

    private TextField selectField(int index) {
        switch (index) {
            case 1:
                //  friend_1.enter(users.get(0));
                return friend_1;
            case 2:
                //     friend_2.enter(users.get(1));
                return friend_2;
            case 3:
                //     friend_3.enter(users.get(2));
                return friend_3;
            case 4:
                //     friend_4.enter(users.get(3));
                return friend_4;
            case 5:
                //  friend_5.enter(users.get(4));
                return friend_5;
            case 6:
                //     friend_6.enter(users.get(5));
                return friend_6;
            case 7:
                //     friend_7.enter(users.get(6));
                return friend_7;
            case 8:
                //     friend_8.enter(users.get(7));
                return friend_8;
            case 9:
                //     friend_9.enter(users.get(8));
                return friend_9;
            case 10:
                //     friend_10.enter(users.get(9));
                return friend_10;
            default: return friend_1;
        }
    }
public void typeName(ArrayList<String> users)
{
    for(int i=1;i<users.size()+1;i++)
    {
        selectField(i).enter(users.get(i-1));
    }
}
}
