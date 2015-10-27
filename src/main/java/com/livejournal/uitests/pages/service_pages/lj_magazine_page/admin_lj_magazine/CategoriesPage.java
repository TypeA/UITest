/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.lj_magazine_page.admin_lj_magazine;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.panferova
 */
@DefaultUrl("/admin/magazine/categories")
public class CategoriesPage extends ServicePageLogged {

    @FindBy(css = "form[action*=create] input.b-admin-discovery-input[name=name]")
    private TextField newName;

    @FindBy(css = "form[action*=create] input.b-admin-discovery-input[name=keyword]")
    private TextField newKeyword;

    @FindBy(css = "form[action*=create] input[type=checkbox][name=special]")
    private Button createSpecialMenu;

    @FindBy(css = "input.b-admin-discovery-submit[value=Add]")
    private Button addCategory;

    @StepGroup
    public void editCategory(String idCategory, String usualCategory, String newName) {
        getDriver().findElement(By.xpath("//a[@class='b-admin-discovery-control' and @href[contains(.,'edit=" + idCategory + "')]]")).click();
        if (Boolean.valueOf(usualCategory).equals(false)) {
            getDriver().findElement(By.xpath("//form[@action[contains(.,'update&id=" + idCategory + "')]]//div//input[@name='special']")).click();
        }
        if (Boolean.valueOf(newName)) {
            getDriver().findElement(By.xpath("//form[@action[contains(.,'update&id=" + idCategory + "')]]//div//input[@name='name']")).sendKeys();
        }
        getDriver().findElement(By.xpath("//form[@action[contains(.,'update&id=" + idCategory + "')]]//div//input[@value='save']")).click();

    }

    public void deleteCategory(String idCategory) {
        getDriver().findElement(By.xpath("//a[@href[contains(.,'delete&id=" + idCategory + "')]]")).click();
    }

    public void addCategory(boolean usualCategory, String nameCategory, String keyword) {
        newName.enter(nameCategory);
        newKeyword.enter(keyword);
        if (usualCategory) {
            createSpecialMenu.click();
        }
        addCategory.click();
    }
}
