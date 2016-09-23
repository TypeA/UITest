package com.livejournal.uitests.medius.admin.categories;


import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.medius.admin.category.AdminMediusCategoryPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.ArrayList;
import java.util.List;

public class AddingNewCategory extends LJTest {

    //Scenario: Create new category
    //Scenario: Fail with adding category
    //Scenario: Delete category
    //Scenario: Edit name and genitive of category !!!
    //Scenario: Change position of category in top
    @Given("logged editor $user on Admin Medius Categories Page")
    public void logged_editor_on_Admin_Medius_Categories_Page(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                .setDefault().defaultLanguageLogged(user);

        open(AdminMediusCategoryPage.class);
    }

    //Scenario: Create new category
    //Scenario: Fail with adding category
    //Scenario: Edit name and genitive of category !!!
    //Scenario: Change position of category in top
    @When("editor adds new category with $symbol_in_keyword and $sticker and $figures on Categories Page")
    public void editor_adds_new_category_with_and_and_on_Categories_Page(String symbol_in_keyword, String sticker, String figures) {
        int setFigures = Integer.parseInt(figures);
        String name = utility().random().getRandomChar(setFigures);
        String keyword = utility().random().getRandomChar(setFigures).toLowerCase() + symbol_in_keyword;
        String genitive = utility().random().getRandomChar(setFigures);
        boolean isSticker = Boolean.parseBoolean(sticker);

        onOpened(AdminMediusCategoryPage.class)
                .addCategory(name, keyword, genitive, isSticker);

        ThucydidesUtils.putToSession("keyword", keyword);
        ThucydidesUtils.putToSession("sticker", sticker);
    }

    //Scenario: Delete category
    @When("editor delete any category")
    public void editor_delete_any_category() {
        String removedKeyword = onOpened(AdminMediusCategoryPage.class).deleteCategory();

        //ThucydidesUtils.putToSession("keyword", removedKeyword);
    }

    //Scenario: Edit name and genitive of category !!!
    @When("editor change name and genitive of new category")
    public void editor_change_name_and_genitive_of_new_category() {
        String keyword = ThucydidesUtils.getFromSession("keyword").toString();

        String[] nameAndGenitive = onOpened(AdminMediusCategoryPage.class).editNameAndGenitiveCategory(keyword);

        ThucydidesUtils.putToSession("name", nameAndGenitive[0]);
        ThucydidesUtils.putToSession("genitive", nameAndGenitive[1]);

    }

    //Scenario: Change position of category in top
    @When("editor change $positions of any category")
    public void editor_change_of_any_category(String positions) {
        String expectedListCategories = onOpened(AdminMediusCategoryPage.class)
                .changePositionCategory(positions.split(" "));

        ThucydidesUtils.putToSession("expectedListCategories", expectedListCategories);
    }

    //Scenario: Create new category
    //Scenario: Edit name and genitive of category !!!
    @Then("new category is in List of categories on Categories Page")
    public void new_category_is_in_List_of_categories_on_Categories_Page() {
        String keyword = ThucydidesUtils.getFromSession("keyword").toString();
        boolean sticker = Boolean.parseBoolean(ThucydidesUtils.getFromSession("sticker").toString());

        verify().that(onOpened(AdminMediusCategoryPage.class)
                .categoryIsAdded(keyword, sticker))
                .ifResultIsExpected("Category is added with keyword = " + keyword +
                        " sticker = " + sticker)
                .ifElse("Category is not added with keyword = " + keyword +
                        " and sticker = " + sticker)
                .finish();
    }

    //Scenario: Fail with adding category
    @Then("editor sees message about error")
    public void editor_sees_message_about_error() {
        onOpened(AdminMediusCategoryPage.class).messageAboutError();
    }

    //Scenario: Fail with adding category
    //Scenario: Delete category !!!
    @Then("category is not in List of categories on Categories Page")
    public void category_is_not_in_List_of_categories_on_Categories_Page() {
        String keyword = ThucydidesUtils.getFromSession("keyword").toString();

        verify().that(onOpened(AdminMediusCategoryPage.class)
                .incorrectCategoryIsNotAdded(keyword))
                .ifResultIsExpected("Category is not added with keyword = " + keyword)
                .ifElse("Category is added with wrong keyword = " + keyword)
                .finish();
    }

    //Scenario: Change position of category in top
    @Then("category changed its position")
    public void category_changed_its_position() {
        String expectedListCategories = ThucydidesUtils.getFromSession("expectedListCategories").toString();

        verify().that(onOpened(AdminMediusCategoryPage.class).listOfCategoriesChanged(expectedListCategories))
                .ifResultIsExpected("Positions of Medius active categories changed successfully")
                .ifElse("Positions of Medius active categories haven't changes")
                .finish();
    }

}
