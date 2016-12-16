package com.livejournal.uitests.pages.service_pages.medius.admin.category;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.LJPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.support.FindBy;

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

    public AdminMediusCategoryPage addCategory(String name, String keyword, String genitive, String sticker) {
        addName.sendKeys(name);
        addKeyword.sendKeys(keyword);
        addGenitive.sendKeys(genitive);

        if (sticker.equals("true")) {
            isSticky.click();
        }
        addCategoryButton.click();

        return this;
    }

    public String getCategoryName(String idCategory) {
        return startScript("return jQuery('input[name=\"name_" + idCategory + "\"]').attr(\"value\")")
                .toString();
    }

    public String getCategoryGenitive(String idCategory) {
        return startScript("return jQuery('input[name=\"genitive_" + idCategory + "\"]').attr(\"value\")")
                .toString();
    }

    public String getCategoryKeyword(String idCategory) {
        return startScript("return " +
                "jQuery('input[name=\"name_" + idCategory + "\"]')" +
                ".parent()" +
                ".siblings('.admin-categories-keyword')" +
                ".text()" +
                ".trim()")
                .toString();
    }

    public boolean getCategorySticker(String idCategory) {
        boolean sticker = false;
        if (getDriver().findElement(By.name("sticker_" + idCategory)).getAttribute("checked") != null) {
            if (getDriver().findElement(By.name("sticker_" + idCategory)).getAttribute("checked").equals("true"))
                sticker = true;
        }
        return sticker;
    }

    public boolean getCategoryActive(String idCategory) {
        boolean inActive = false;
        if (getDriver().findElement(By.name("active_" + idCategory)).getAttribute("checked") != null) {
            if (getDriver().findElement(By.name("active_" + idCategory)).getAttribute("checked").equals("true"))
                inActive = true;
        }
        return inActive;
    }

    public String getMessageAboutError() {
        return startScript("return jQuery('div[lj-html=\"message.body\"').text()").toString();
    }

    public AdminMediusCategoryPage deleteCategory(String categoryId) {
        startScript("jQuery('button[name=\"delete\"][value=\"" + categoryId + "\"]').click()");
        return onOpened(AdminMediusCategoryPage.class);
    }

    //!!!!!!
    public AdminMediusCategoryPage editNameAndGenitiveCategory(String keyword) {
        startScript("jQuery('input[name=\"name_" + keyword + "\"]').attr(\"value\",\"edited\")");
        startScript("jQuery('input[name=\"genitive_" + keyword + "\"]').attr(\"value\",\"changed\")");

        return this;
    }

    //!!!!!
    public AdminMediusCategoryPage changePositionCategory(String position, String keyword) {
        if (position.equals("up")) {
            startScript("jQuery('button[name=\"up\"][value=\""
                    + keyword + "\"]').click()");
        }
        if (position.equals("down")) {
            startScript("jQuery('button[name=\"down\"][value=\""
                    + keyword + "\"]').click()");
        }
        saveChangesButton.click();
        return this;
    }

    public boolean listOfCategoriesChanged(String expectedListCategories) {
        String factListCategories = getDBDate().medius()
                .getListIdAndKeywordOfCategoriesByActiveAndSticker(true, false).get(1).toString();

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
