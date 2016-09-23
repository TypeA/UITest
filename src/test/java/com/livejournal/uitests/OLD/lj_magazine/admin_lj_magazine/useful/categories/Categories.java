package com.livejournal.uitests.OLD.lj_magazine.admin_lj_magazine.useful.categories;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageLogged;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.admin_lj_magazine.CategoriesPage;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.panferova
 */
public class Categories extends LJTest {

    @Given("logged user on Main Page and go to Admin Magazine Categories")
    public void logged_user_on_Main_Page_and_go_to_Admin_Magazine_Categories() {
        String name = getDBDate().privileges().getUserWithPrivDiscovery();
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name));
        open(CategoriesPage.class);
    }

    @When("create new $usual_category category")
    public void create_new_category(String usual_category) {
        String nameCategory = utility().random().getRandomChar(10);
        String keyword = utility().random().getRandomChar(10);
        onOpened(CategoriesPage.class)
                .addCategory(Boolean.valueOf(usual_category), nameCategory, keyword);
        ThucydidesUtils.putToSession("nameCategory", nameCategory);
        ThucydidesUtils.putToSession("keyword", keyword);
    }

    @Then("categories exist in $usual_category widget")
    public void categories_exist_in_widget(String usual_category) {
        String categoryName = ThucydidesUtils.getFromSession("nameCategory").toString();
        String keyword = ThucydidesUtils.getFromSession("keyword").toString();
        verify().that(open(LJMagazinePageLogged.class)
                .categoryExistOnLJMagagazine(Boolean.valueOf(usual_category), categoryName, keyword))
                .ifResultIsExpected("Category = " + categoryName + " is exist")
                .ifElse("Category  = " + categoryName + " is not exist")
                .finish();

    }

    @When("edit $usual_category category and set option special category $special_category and new name $new_name")
    public void edit_usual_category_category_and_set_option_special_category_special_category_and_new_name(String usual_category, String new_name) {
        if (Boolean.valueOf(new_name)) {
            new_name = utility().random().getRandomChar(10);
        }
        String idCategory = getDBDate().discovery().getIdCategories(usual_category);
        onOpened(CategoriesPage.class)
                .editCategory(idCategory, usual_category, new_name);
        ThucydidesUtils.putToSession("new_name", new_name);
        ThucydidesUtils.putToSession("idCategory", idCategory);
    }

    @Then("$special_category category is changed")
    public void category_is_changed(String special_category) {
        String categoryName = ThucydidesUtils.getFromSession("new_name").toString();
        String idCategory = ThucydidesUtils.getFromSession("idCategory").toString();
        verify().that(open(LJMagazinePageLogged.class)
                .categoryExistOnLJMagagazine(Boolean.valueOf(special_category) ? false : true, categoryName, getDBDate().discovery().getKeywordCategories(idCategory)))
                .ifResultIsExpected("Category = " + categoryName + " is changed")
                .ifElse("Category  = " + categoryName + " is not changed")
                .finish();
    }

    @When("delete $usual_category category")
    public void delete_category(String usual_category) {
        String idCategory = getDBDate().discovery().getIdCategories(usual_category);
        String nameCategory = getDBDate().discovery().getNameCategory(idCategory);
        onOpened(CategoriesPage.class)
                .deleteCategory(idCategory);
        ThucydidesUtils.putToSession("nameCategory", nameCategory);
        ThucydidesUtils.putToSession("keywordCategory", getDBDate().discovery().getKeywordCategories(idCategory));

    }

    @Then("$usual_category category is deleted")
    public void category_is_deleted(String usual_category) {
        String categoryName = ThucydidesUtils.getFromSession("nameCategory").toString();
        verify().that(open(LJMagazinePageLogged.class)
                .categoryExistOnLJMagagazine(Boolean.valueOf(usual_category), categoryName, ThucydidesUtils.getFromSession("keywordCategory").toString()).equals(false))
                .ifResultIsExpected("Category = " + categoryName + " is changed")
                .ifElse("Category  = " + categoryName + " is not changed")
                .finish();
    }
}
