package com.livejournal.uitests.medius.admin.categories;


import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.medius.admin.category.AdminMediusCategoryPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AddingNewCategory extends LJTest {

    //Scenario: Scenario: Create new category
    //Scenario: Fail with creating new usual category
    //Scenario: Delete category
    //Scenario: Edit name and genetive of category
    //Scenario: Change position of category in top
    @Given("logged editor $user on Admin Medius Categories Page")
    public void logged_editor_on_Admin_Medius_Categories_Page(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                .defaultLanguageLogged(user);
        open(AdminMediusCategoryPage.class);
    }

    //Scenario: Scenario: Create new category
    //Scenario: Fail with creating new usual category
    //Scenario: Delete category
    //Scenario: Edit name and genetive of category
    //Scenario: Change position of category in top
    @When("editor adds new category with $symbol_in_keyword and $sticker and $figures on Categories Page")
    public void editor_adds_new_category_with_and_and_on_Categories_Page(String symbol_in_keyword, String sticker, String figures) {
        int setFigures = Integer.parseInt(figures);
        String name = utility().random().getRandomChar(setFigures);
        String keyword = utility().random().getRandomChar(setFigures).toLowerCase() + symbol_in_keyword;
        String genitive = utility().random().getRandomChar(setFigures);
        boolean isSticker = Boolean.parseBoolean(sticker);

        onOpened(AdminMediusCategoryPage.class)
                .AddCategory(name, keyword, genitive, isSticker);

        ThucydidesUtils.putToSession("name", name);
        ThucydidesUtils.putToSession("keyword", keyword);
        ThucydidesUtils.putToSession("genitive", genitive);
        ThucydidesUtils.putToSession("sticker", sticker);
    }

    //Scenario: Delete category
    @When("editor delete new category")
    public void editor_delete_new_category() {
        String name = ThucydidesUtils.getFromSession("name").toString();
        String keyword = ThucydidesUtils.getFromSession("keyword").toString();
        String genitive = ThucydidesUtils.getFromSession("genitive").toString();

        onOpened(AdminMediusCategoryPage.class).deleteCategory(name, keyword, genitive);
    }

    //Scenario: Edit name and genetive of category
    @When("editor change name and genitive of new category")
    public void editor_change_name_and_genetive_of_new_category() {
        String name = ThucydidesUtils.getFromSession("name").toString();
        String keyword = ThucydidesUtils.getFromSession("keyword").toString();
        String genitive = ThucydidesUtils.getFromSession("genitive").toString();

        String[] nameAndGenetive = onOpened(AdminMediusCategoryPage.class).editNameAndGenitiveCategory(name, keyword, genitive);

        ThucydidesUtils.putToSession("name", nameAndGenetive[0]);
        ThucydidesUtils.putToSession("genitive", nameAndGenetive[1]);

    }

    @When("editor change status Active and position of new category")
    public void editor_change_status_Active_of_new_category(String[] positions) {
        String name = ThucydidesUtils.getFromSession("name").toString();
        String keyword = ThucydidesUtils.getFromSession("keyword").toString();
        String genitive = ThucydidesUtils.getFromSession("genitive").toString();

        //String[] correctArrayPositions = positions.split(" ");
        onOpened(AdminMediusCategoryPage.class).editStatusCategory(name, keyword, genitive);
        onOpened(AdminMediusCategoryPage.class).changePositionCategory(name, keyword, genitive, positions);
    }

    //Scenario: Scenario: Create new category
    //Scenario: Edit name and genetive of category
    @Then("new category is in List of categories on Categories Page")
    public void new_category_is_in_List_of_categories_on_Categories_Page() {
        String name = ThucydidesUtils.getFromSession("name").toString();
        String keyword = ThucydidesUtils.getFromSession("keyword").toString();
        String genitive = ThucydidesUtils.getFromSession("genitive").toString();
        Boolean sticker = Boolean.parseBoolean(ThucydidesUtils.getFromSession("sticker").toString());

        verify().that(onOpened(AdminMediusCategoryPage.class)
                .categoryIsAdded(name, keyword, genitive, sticker))
                .ifResultIsExpected("Category is added with name = " + name +
                        " and keyword = " + keyword +
                        " and genitive = " + genitive +
                        " and checkbox sticker = " + sticker)
                .ifElse("Category is not added with name=" + name +
                        " and keyword = " + keyword +
                        " and genitive = " + genitive +
                        " and checkbox sticker = " + sticker)
                .finish();
    }

    //Scenario: Fail with creating new usual category
    @Then("editor sees message about error")
    public void editor_sees_message_about_error() {
        onOpened(AdminMediusCategoryPage.class).messageAboutError();
    }

    //Scenario: Fail with creating new usual category
    //Scenario: Delete category
    @Then("category is not in List of categories on Categories Page")
    public void category_is_not_in_List_of_categories_on_Categories_Page() {
        String name = ThucydidesUtils.getFromSession("name").toString();

        verify().that(onOpened(AdminMediusCategoryPage.class)
                .incorrectCategoryIsNotAdded(name))
                .ifResultIsExpected("Category is not added with name = " + name)
                .ifElse("Category is added with name=" + name)
                .finish();
    }
}
