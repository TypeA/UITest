package com.livejournal.uitests.pages.service_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/customize")
public class CustomizeJournalPage extends ServicePageLogged {

    @FindBy(css = ".detail.theme-nav-search-box input")
    private TextField searchStyleField;

    @FindBy(name = "Widget[ThemeNav]_search_submit")
    private Button searchStyleButton;

    @FindBy(name = "Widget[ThemeChooser]_apply")
    private Button applyStyle;

    public CustomizeJournalPage findStyle(String style) throws InterruptedException {
        searchStyleField.enter(style);
        searchStyleButton.click();
        Thread.sleep(2000);
        return this;
    }

    public CustomizeJournalPage applyStyle() {
        applyStyle.click();
        getDriver().switchTo().alert().accept();
        return this;
    }

}
