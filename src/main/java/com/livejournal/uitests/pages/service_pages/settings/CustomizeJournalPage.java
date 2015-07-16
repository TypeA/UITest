package com.livejournal.uitests.pages.service_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/customize")
public class CustomizeJournalPage extends ServicePageLogged {

    @FindBy(css = ".detail.theme-nav-search-box input")
    private TextField searchStyleField;
    
    @FindBy(css = ".theme-selector-content.pkg h3")
    private TextBlock fullText;
    
    @FindBy(name = "Widget[ThemeNav]_search_submit")
    private Button searchStyleButton;

    @FindBy(id = "theme_btn_36913693")
    private Button applyStyle;

    public CustomizeJournalPage findStyle(String style) {
        searchStyleField.enter(style);
        searchStyleButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return fullText.getText().contains("Search Results For");
            }
        });
        return this;
    }

    public CustomizeJournalPage applyStyle() {
        applyStyle.click();
        getDriver().switchTo().alert().accept();
        return this;
    }

}
