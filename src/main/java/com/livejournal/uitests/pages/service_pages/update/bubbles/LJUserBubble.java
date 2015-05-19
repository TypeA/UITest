package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".b-bubble-user .b-popup-outer"))
public class LJUserBubble extends UIBlock {

    @FindBy(css = ".b-updateform-bubble-input-username .b-updateform-bubble-input")
    private TextField username;

    @StepGroup
    public UpdateBmlPageLogged enterUsername(String ljuser, Boolean isCorrectUser) {
        username.enter(ljuser);
        startScript("jQuery('.b-updateform-bubble-user-button .b-flatbutton-simple').click()");
        if(isCorrectUser){
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return !LJUserBubble.super.isDisplayed();
            }
        });      
            
        } 
            return onOpened(UpdateBmlPageLogged.class);
        
    }
}
