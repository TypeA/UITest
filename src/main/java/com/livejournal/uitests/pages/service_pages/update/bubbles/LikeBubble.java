package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import java.util.ArrayList;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".b-bubble-like"))
public class LikeBubble extends UIBlock {

    @FindBy(css = ".b-updateform-bubble-like-button")
    private Button save;

    private void clearAll() {
        ArrayList<WebElement> likes = new ArrayList<WebElement>();
        likes = (ArrayList<WebElement>) findElements(By.cssSelector("input"));
        for (WebElement like : likes) {
            if (like.isSelected()) {
                like.click();
            }
        }
    }

    @StepGroup
    public void setLikes(ArrayList<String> likesList) {
        if (!likesList.get(0).toUpperCase().equals("DEFAULT")) {
            clearAll();
            ArrayList<WebElement> likes = new ArrayList<WebElement>();
            likes = (ArrayList<WebElement>) findElements(By.cssSelector("li"));
            for (String likesList1 : likesList) {
                for (WebElement like : likes) {
                    if (like.getAttribute("class").contains(likesList1)) {
                        like.click();
                    }
                }
            }
        }
        save.click();
    }
}
