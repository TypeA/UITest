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
        } catch (NullPointerException ex) {
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

    public String deleteCategory() {
        //List<String> listInactiveCategories = getDBDate().medius();

        String keywordForVerification = listInactiveCategories.get(0).split(" ")[1];

        try {
            for (String category: listInactiveCategories) {
                startScript("jQuery('button[value=\"" + category.split(" ")[0] + "\"]').click()");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return keywordForVerification;
    }

    public String[] editNameAndGenitiveCategory(String keyword) {
        String idCategory = getIdCategory(keyword);
        String newName = "edited" + idCategory;
        String newGenitive = "changed" + idCategory;

        try {
            startScript("jQuery('input[name=\"name_" + idCategory + "\"]').attr(\"value\",\"" + newName + "\")");
            startScript("jQuery('input[name=\"genitive_" + idCategory + "\"]').attr(\"value\",\"" + newGenitive + "\")");
        } catch (Exception ex) {
            System.out.println("ooops");
        }
        saveChangesButton.click();

        return new String[]{newName, newGenitive};
    }

    public String changePositionCategory(String[] positions) {
        List<String> startList = getDBDate().medius()
                .getListIdAndKeywordOfUsualActiveCategories();
        List<String> changedList = new ArrayList<>(startList);

        try {
            for (String position : positions) {
                if (position.equals("up")) {
                    startScript("jQuery('button[name=\"up\"][value=\"" + startList.get(startList.size() - 1).split(" ")[0] + "\"]').click()");
                    saveChangesButton.click();
                    changedList.add(startList.size() - 2, changedList.get(startList.size() - 1));
                    changedList.remove(changedList.size() - 1);
                }
                if (position.equals("down")) {
                    startScript("jQuery('button[name=\"down\"][value=\"" + startList.get(0).split(" ")[0] + "\"]').click()");
                    saveChangesButton.click();
                    changedList.add(2, startList.get(0));
                    changedList = changedList.subList(1, changedList.size());
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("Ooops.....");
        }

        return changedList.toString();
    }

    public boolean listOfCategoriesChanged(String expectedListCategories) {
        String factListCategories = getDBDate().medius()
                .getListIdAndKeywordOfUsualActiveCategories().toString();

        return expectedListCategories.equals(factListCategories);
    }
}
