package com.livejournal.uitests.medius.admin.categories;


import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.medius.admin.category.AdminMediusCategory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Then;

public class UnsuccessfulAddingCategory extends LJTest {

    @Given("logged editor $user on Admin Medius Categories Page")
    public void logged_editor_on_Admin_Medius_Categories_Page(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                .defaultLanguageLogged(user);
        open(AdminMediusCategory.class);
    }

    @When("editor add new incorrect category with $incorrect_symbol_in_keyword on Categories Page")
    public void editor_add_new_incorrect_category_on_Categories_Page(String incorrect_symbol_in_keyword) {
        String name = utility().random().getRandomChar(7);
        String incorrectedKeyword = utility().random().getRandomChar(7).toLowerCase() + incorrect_symbol_in_keyword;
        String genitive = utility().random().getRandomChar(7);
        onOpened(AdminMediusCategory.class)
                .AddCategory(name, incorrectedKeyword, genitive, false);
        ThucydidesUtils.putToSession("name", name);
        ThucydidesUtils.putToSession("incorrectKeyword", incorrectedKeyword);
        ThucydidesUtils.putToSession("genitive", genitive);
    }

    @Then("editor sees message about error")
    public void editor_sees_message_about_error() {
        onOpened(AdminMediusCategory.class).printMessageAboutError();
    }

    @Then("new incorrect category is not in List of categories on Categories Page")
    public void new_incorrect_category_is_not_in_List_of_categories_on_Categories_Page() {
        String name = ThucydidesUtils.getFromSession("name").toString();
        String incorrectKeyword = ThucydidesUtils.getFromSession("incorrectKeyword").toString();
        String genitive = ThucydidesUtils.getFromSession("genitive").toString();

        verify().that(onOpened(AdminMediusCategory.class)
                .incorrectCategoryIsNotAdded(name, incorrectKeyword, genitive, false))
                .ifResultIsExpected("Category is not added with name = " + name +
                        " and incorrectKeyword = " + incorrectKeyword +
                        " and genitive = " + genitive +
                        " and checkbox sticker = false")
                .ifElse("Category is added with name=" + name +
                        " and incorrectKeyword = " + incorrectKeyword +
                        " and genitive = " + genitive +
                        " and checkbox sticker = false")
                .finish();


    }



}
