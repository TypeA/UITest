package com.livejournal.uitests.medius.admin.categories;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.medius.admin.category.AdminMediusCategory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AddStickerCategory extends LJTest {

    @Given("logged editor $user on Admin Medius Categories Page")
    public void logged_editor_on_Admin_Medius_Categories_Page(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                .defaultLanguageLogged(user);
        open(AdminMediusCategory.class);
    }

    @When("editor adds new sticker category with $symbol_in_keyword on Categories Page")
    public void editor_adds_new_sticker_category_with_on_Categories_Page(String symbol_in_keyword) {
        String name = utility().random().getRandomChar(7);
        String keyword = utility().random().getRandomChar(7).toLowerCase() + symbol_in_keyword;
        String genitive = utility().random().getRandomChar(7);
        onOpened(AdminMediusCategory.class)
                .AddCategory(name, keyword, genitive, true);

        ThucydidesUtils.putToSession("name", name);
        ThucydidesUtils.putToSession("keyword", keyword);
        ThucydidesUtils.putToSession("genitive", genitive);
    }

    @Then("new sticker category is in List of categories on Categories Page")
    public void new_sticker_category_is_in_List_of_categories_on_Categories_Page() {
        String name = ThucydidesUtils.getFromSession("name").toString();
        String keyword = ThucydidesUtils.getFromSession("keyword").toString();
        String genitive = ThucydidesUtils.getFromSession("genitive").toString();

        verify().that(onOpened(AdminMediusCategory.class)
                .categoryIsAdded(name, keyword, genitive, true))
                .ifResultIsExpected("Sticker-category is added with name = " + name +
                        " and keyword = " + keyword +
                        " and genitive = " + genitive +
                        " and checkbox sticker = true")
                .ifElse("Sticker-category is not added with name = " + name +
                        " and keyword = " + keyword +
                        " and genitive = " + genitive +
                        " and checkbox sticker = true")
                .finish();


    }
}

