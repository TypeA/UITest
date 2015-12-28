package com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import java.util.ArrayList;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".l-flatslide-container"))
public class OverallBlock extends UIBlock {

    @FindBy(css = "button[ng-class*='filters']")
    private Button filtersButton;

    @StepGroup
    public FiltersBlock openFilters() {
        filtersButton.click();
        return onDisplayed(FiltersBlock.class);
    }

    @StepGroup
    public boolean filtersIsDisplayed() {
        try {
            return filtersButton.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    @FindBy(css = ".l-flatslide-settingslink-open")
    private Button settingsButton;

    @StepGroup
    public boolean settingsIsDisplayed() {
        try {
            return settingsButton.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    @FindBy(css = ".l-flatslide-scrolltop.scroll-update__button ")
    private Button upButton;

    @StepGroup
    public void clickUpButton() {
        upButton.click();
    }

    @StepGroup
    public boolean upIsDisplayed() {
        return upButton.isDisplayed();
    }

    @StepGroup
    public ArrayList<String> getMainSettings() {
        ArrayList<String> settings = new ArrayList<String>();
        ArrayList<String> ans = new ArrayList<String>();
        settings.add(startScript("return jQuery('.p-lenta').css('backgroundColor')").toString());
        settings.add(startScript("return jQuery('.entryunit__text').css('font-family')").toString());
        settings.add(startScript("return jQuery('.js-font-color').css('color')").toString());
        settings.add(startScript("return jQuery('.js-link-color').css('color')").toString());
        settings.add(startScript("return jQuery('.p-lenta .l-flatslide-content').css('backgroundColor')").toString());
        settings.add(startScript("return jQuery('.p-lenta .l-flatslide-aside').css('backgroundColor')").toString());
        settings.add(startScript("return jQuery('.js-sidebar-color').css('color')").toString());
        settings.add(startScript("return jQuery('.js-elem-color--svgicon .svgicon').css('color')").toString());
        settings.add(startScript("return jQuery('.js-elem-bordercolor').css('borderTopColor')").toString());
        settings.add(startScript("return jQuery('.js-elem-bgcolor').css('backgroundColor')").toString());
        for (int i = 0; i < settings.size(); i++) {
            ans.add(settings.get(i).replace("rgb(", "").replace(")", "").toUpperCase());
        }
        return ans;
    }

}
