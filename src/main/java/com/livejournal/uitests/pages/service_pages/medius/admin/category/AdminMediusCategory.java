package com.livejournal.uitests.pages.service_pages.medius.admin.category;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.LJPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.webelements.Checkbox;
import org.openqa.jetty.html.Input;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("/admin/medius/category")
public class AdminMediusCategory extends LJPage {

    @FindBy(name = "name")
    private TextField addName;

    @FindBy(name = "keyword")
    private TextField addKeyword;

    @FindBy(name = "genitive")
    private TextField addGenitive;

    @FindBy(name = "add")
    private Button add;

    @FindBy(name = "is_sticker")
    private UIElement isSticky;

    public void AddCategory(String name, String keyword, String genitive, boolean sticker) {
        addName.sendKeys(name);
        addKeyword.sendKeys(keyword);
        addGenitive.sendKeys(genitive);

        if (sticker) {
            isSticky.click();
        }

        add.click();
    }

    private String getElementActiveCategory(String idCategory) {
        return getDriver().findElement(By.name("active_" + idCategory)).getAttribute("checked");
    }

    private String getElementStickerCategory(String idCategory) {
        return getDriver().findElement(By.name("sticker_" + idCategory)).getAttribute("checked");
    }

    public boolean categoryIsAdded(String name, String keyword, String genitive, boolean sticker) {
        String idCategory = getDBDate().medius().getIdCategory(name, keyword, genitive);
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

    public void printMessageAboutError() {
        String rightMessageAboutError = "Keyword can contain only lower-case letters (a-z), digits (0-9), and the underscore character (_)";
        boolean ourMessageAboutError = getDriver().findElement(By.xpath("//div[@class='b-msgsystem-body' and @lj-html='message.body' and contains(text(), '" + rightMessageAboutError + "')]")).isDisplayed();

        if (ourMessageAboutError) {
            System.out.println("Ok. Message about error is right");
        } else {
            System.out.println("Oops... Message about error is incorrect");
        }
    }

    public boolean incorrectCategoryIsNotAdded(String name, String keyword, String genitive, boolean sticker) {
        try {
            getDriver().findElement(By.xpath("//td[@class='admintable__column admin-categories-name' and input[@value='" + name + "']]")).getText();
            return false;

        } catch (Exception e) {
            return true;
        }

        /*System.out.println(categoryIsAdded(name, keyword, genitive, sticker));
        if (categoryIsAdded(name, keyword, genitive, sticker))
            return false;
        else {
            boolean isMessageOfError = getDriver().findElement(By.xpath("//div[@class='b-msgsystem-body' and @lj-html='message.body']")).isDisplayed();
            System.out.println(isMessageOfError);
            return isMessageOfError;
        }*/

    }


}
