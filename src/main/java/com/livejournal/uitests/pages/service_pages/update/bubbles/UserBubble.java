package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-bubble-user"))
public class UserBubble extends UIBlock {

    @FindBy(css = ".b-updateform-bubble-input-wrapper.b-updateform-bubble-input-username input")
    private TextField username;

    @FindBy(css = ".b-updateform-bubble-user-button .b-flatbutton-simple")
    private Button save;

    @StepGroup
    public void enterUsername(String ljuser, Boolean isCorrectUser) {
        username.enter(ljuser);
        startScript("jQuery('.b-bubble-user .b-flatbutton-simple').click()");
        //скрипт отрабатывает слишком быстро и lj-user не успевает появиться на форме.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }

    @StepGroup
    public void enterUsernameUsingAutocomplete(String ljuser) {
        String ljuserCutted = ljuser.substring(0, 3);
        username.enter(ljuserCutted);
        boolean flag = true;
        int i = 0;
        while (flag) {
            if (i < 10) {
                username.sendKeys(Keys.ARROW_DOWN);
                i++;
                if (startScript("return jQuery('.ui-autocomplete .ui-state-hover').text()").equals(ljuser)) {
                    username.sendKeys(Keys.ENTER);
                    flag = false;
                }
            } else {
                ljuserCutted = ljuser.substring(0, ljuserCutted.length() + 1);
                username.enter(ljuserCutted);
                i = 0;
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
    }

}
