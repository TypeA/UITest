package com.livejournal.uitests.medius.admin.categories;


import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.medius.admin.category.AdminMediusCategoryPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AddingCategory extends LJTest {

    //Scenario: Create new usual category
    //Scenario: Create new sticker category
    //Scenario: Fail with creating new usual category
    @Given("logged editor $user on Admin Medius Categories Page")
    public void logged_editor_on_Admin_Medius_Categories_Page(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                .defaultLanguageLogged(user);
        open(AdminMediusCategoryPage.class);
    }

    //Scenario: Create new usual category
    //Scenario: Create new sticker category
    @When("editor adds new category with <symbol_in_keyword> and <sticker> on Categories Page")
    public void editor_adds_new_category_with_and_on_Categories_Page(String symbol_in_keyword, String sticker) {
        String name = utility().random().getRandomChar(7);
        String keyword = utility().random().getRandomChar(7).toLowerCase() + symbol_in_keyword;
        String genitive = utility().random().getRandomChar(7);
        boolean isSticker = Boolean.parseBoolean(sticker);

        onOpened(AdminMediusCategoryPage.class)
                .AddCategory(name, keyword, genitive, isSticker);
        ThucydidesUtils.putToSession("name", name);
        ThucydidesUtils.putToSession("keyword", keyword);
        ThucydidesUtils.putToSession("genitive", genitive);
        ThucydidesUtils.putToSession("sticker", sticker);
    }

    //Scenario: Create new usual category
    //Scenario: Create new sticker category
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

    @Then("editor sees message about error")
    public void editor_sees_message_about_error() {
        onOpened(AdminMediusCategoryPage.class).printMessageAboutError();
    }

    @Then("new category is not in List of categories on Categories Page")
    public void new_category_is_not_in_List_of_categories_on_Categories_Page() {
        String name = ThucydidesUtils.getFromSession("name").toString();
        String incorrectKeyword = ThucydidesUtils.getFromSession("incorrectKeyword").toString();
        String genitive = ThucydidesUtils.getFromSession("genitive").toString();
        Boolean sticker = Boolean.parseBoolean(ThucydidesUtils.getFromSession("sticker").toString());

        verify().that(onOpened(AdminMediusCategoryPage.class)
                .incorrectCategoryIsNotAdded(name, incorrectKeyword, genitive, sticker))
                .ifResultIsExpected("Category is not added with name = " + name +
                        " and incorrectKeyword = " + incorrectKeyword +
                        " and genitive = " + genitive +
                        " and checkbox sticker =" + sticker)
                .ifElse("Category is added with name=" + name +
                        " and incorrectKeyword = " + incorrectKeyword +
                        " and genitive = " + genitive +
                        " and checkbox sticker =" + sticker)
                .finish();


    }


}
