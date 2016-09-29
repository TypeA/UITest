package com.livejournal.uitests.pages.service_pages.medius.admin.category;

import com.livejournal.uisteps.thucydides.Databases;
import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.LJPage;
import jnr.ffi.annotations.In;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.webelements.Checkbox;
import org.openqa.jetty.html.Input;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DefaultUrl("/admin/medius/category")
public class AdminMediusCategoryPage extends LJPage {

    @FindBy(name = "name")
    private TextField addName;

    @FindBy(name = "keyword")
    private TextField addKeyword;

    @FindBy(name = "genitive")
    private TextField addGenitive;

    @FindBy(name = "add")
    private Button addCategoryButton;

    @FindBy(name = "is_sticker")
    private UIElement isSticky;

    @FindBy(name = "save")
    private Button saveChangesButton;

    public void addCategory(String name, String keyword, String genitive, boolean sticker) {
        addName.sendKeys(name);
        addKeyword.sendKeys(keyword);
        addGenitive.sendKeys(genitive);

        if (sticker) {
            isSticky.click();
        }

        addCategoryButton.click();
    }

    private String getElementActiveCategory(String idCategory) {
        return getDriver().findElement(By.name("active_" + idCategory)).getAttribute("checked");
    }

    private String getElementStickerCategory(String idCategory) {
        return getDriver().findElement(By.name("sticker_" + idCategory)).getAttribute("checked");
    }

    private String getIdCategory(String keyword) {
        return getDBDate().medius().getIdCategory(keyword);
    }

    public boolean categoryIsAdded(String keyword, boolean sticker) {
        String idCategory = getIdCategory(keyword);
        boolean nameIsExist = getDriver().findElement(By.name("name_" + idCategory)).isDisplayed();
        boolean keywordIsExist = getDriver().findElement(By.xpath("//td[@class='admintable__column admin-categories-keyword' and contains(text(), '" + keyword + "')]")).isDisplayed();
        boolean genitiveIsExist = getDriver().findElement(By.name("genitive_" + idCategory)).isDisplayed();
        boolean activeDefault = getElementActiveCategory(idCategory) == null;
        boolean stickerOn;

        if (sticker) {
            stickerOn = getElementStickerCategory(idCategory).equals("true");
        } else {
            stickerOn = getElementStickerCategory(idCategory) == null;
        }

        return nameIsExist && keywordIsExist && genitiveIsExist && activeDefault && stickerOn;
    }

    public void messageAboutError() {
        String rightMessageAboutError1 = "Keyword can contain only lower-case letters (a-z), digits (0-9), and the underscore character (_)";
        String rightMessageAboutError2 = "Name of sticker is too long";

        try {
            if (getDriver().findElement(By.xpath("//div[@class='b-msgsystem-body' and @lj-html='message.body' and contains(text(), '" + rightMessageAboutError1 + "')]")).isDisplayed()) {
                System.out.println("Ok. Message about error is right");
            }
        } catch (Exception ex) {
            if (getDriver().findElement(By.xpath("//div[@class='b-msgsystem-body' and @lj-html='message.body' and contains(text(), '" + rightMessageAboutError2 + "')]")).isDisplayed()) {
                System.out.println("Ok. Message about error is right");
            }
        }
    }

    public boolean incorrectCategoryIsNotAdded(String keyword) {
        try {
            getDriver().findElement(By.xpath("//td[@class='admintable__column admin-categories-keyword' and contains(text(), '" + keyword + "')]")).getText();
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public AdminMediusCategoryPage deleteCategory(String keyword) {
        startScript("jQuery('button[name=\"delete\"][value=\"" + getIdCategory(keyword) + "\"]').click()");

        return this;
    }

    public AdminMediusCategoryPage editNameAndGenitiveCategory(String keyword) {
        startScript("jQuery('input[name=\"name_" + getIdCategory(keyword) + "\"]').attr(\"value\",\"edited\")");
        startScript("jQuery('input[name=\"genitive_" + getIdCategory(keyword) + "\"]').attr(\"value\",\"changed\")");

        return this;
    }

    public AdminMediusCategoryPage changePositionCategory(String position, String keyword) {
        if (position.equals("up")) {
            startScript("jQuery('button[name=\"up\"][value=\""
                    + getIdCategory(keyword) + "\"]').click()");
        }
        if (position.equals("down")) {
            startScript("jQuery('button[name=\"down\"][value=\""
                    + getIdCategory(keyword) + "\"]').click()");
        }
        saveChangesButton.click();
        return this;
    }

    public boolean listOfCategoriesChanged(String expectedListCategories) {
        String factListCategories = getDBDate().medius()
                .getListIdAndKeywordOfCategories(true, false).get(1).toString();

        return expectedListCategories.equals(factListCategories);
    }

    public boolean categoryChanged(String categoryWithChanges) {
        String idCategory = categoryWithChanges.split(" ")[0];
        boolean nameChanged = getDriver().findElement(By.name("name_" + idCategory))
                .getAttribute("value").equals("edited");
        boolean genitiveChanged = getDriver().findElement(By.name("genitive_" + idCategory))
                .getAttribute("value").equals("changed");

        return nameChanged && genitiveChanged;
    }
}
