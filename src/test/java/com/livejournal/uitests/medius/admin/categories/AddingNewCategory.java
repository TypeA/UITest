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
import java.util.Random;

public class AddingNewCategory extends LJTest {

    //Scenario: Create new category
    //Scenario: Fail with adding category
    //Scenario: Delete category*
    //Scenario: Edit name and genitive of category*
    //Scenario: Change position of category in top*
    @Given("logged editor $user on Admin Medius Categories Page")
    public void logged_editor_on_Admin_Medius_Categories_Page(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                .setDefault().defaultLanguageLogged(user);

        open(AdminMediusCategoryPage.class);
    }

    //Scenario: Create new category
    //Scenario: Fail with adding category
    @When("editor adds new category with $keyword_with and $sticker and $limit_10 on Categories Page")
    public void editor_adds_new_category_on_Categories_Page(String keyword_with, String sticker, String limit_10) {
        int count_of_chars;
        switch (limit_10.trim()) {
            case ">":
                count_of_chars = utility().random().getRandomValue(10) + 10;
                break;
            case "<":
                count_of_chars = utility().random().getRandomValue(10);
                break;
            case "=":
                count_of_chars = 10;
                break;
            default: count_of_chars=0;
        }

        String name = "";
        String keyword = "";
        String genitive = "";
        String[] punctuation = {",", ".", ":", ";", "!", "?", "\'", "\"", "[", "]", "-"};
        switch (keyword_with) {
            case "text":
                name = utility().random().getRandomText(count_of_chars);
                keyword = utility().random().getRandomText(count_of_chars).toLowerCase();
                genitive = utility().random().getRandomText(count_of_chars);
                break;
            case "upper_text":
                name = utility().random().getRandomText(count_of_chars).toUpperCase();
                keyword = utility().random().getRandomText(count_of_chars).toUpperCase();
                genitive = utility().random().getRandomText(count_of_chars).toUpperCase();
                break;
            case "russian_text":
                name = utility().random().getRandomRussianText(count_of_chars);
                keyword = utility().random().getRandomRussianText(count_of_chars);
                genitive = utility().random().getRandomRussianText(count_of_chars);
                break;
            case "number":
                name = utility().random().getRandomText(count_of_chars - 1)
                        + utility().random().getRandomValue(10);
                keyword = utility().random().getRandomText(count_of_chars - 1).toLowerCase()
                        + utility().random().getRandomValue(10);
                genitive = utility().random().getRandomText(count_of_chars - 1)
                        + utility().random().getRandomValue(10);
                break;
            case "punctuation":
                int i = utility().random().getRandomValue(punctuation.length-1);
                name = utility().random().getRandomText(count_of_chars - 1)
                        + punctuation[i];
                keyword = utility().random().getRandomText(count_of_chars - 1).toLowerCase()
                        + punctuation[i];
                genitive = utility().random().getRandomText(count_of_chars - 1)
                        + punctuation[i];
                break;
            case "_":
                name = utility().random().getRandomText(count_of_chars - 1) + "_";
                keyword = utility().random().getRandomText(count_of_chars - 1).toLowerCase() + "_";
                genitive = utility().random().getRandomText(count_of_chars - 1) + "_";
                break;
            default:
                name = null;
                keyword = null;
                genitive = null;
        }

        System.out.println("name: " + name +", key: " + keyword);
        onOpened(AdminMediusCategoryPage.class)
                .addCategory(name, keyword, genitive, sticker);

        ThucydidesUtils.putToSession("name", name);
        ThucydidesUtils.putToSession("keyword", keyword);
        ThucydidesUtils.putToSession("genitive", genitive);
        ThucydidesUtils.putToSession("sticker", sticker);
        ThucydidesUtils.putToSession("active", false);
    }

    //Scenario: Delete category*
    @When("editor delete any category with $symbol_in_keyword")
    public void editor_delete_any_category_with(String symbol_in_keyword) {
        String keyword = getRandomKeywordFromListOfAllCategoriesWithSpecialKey(symbol_in_keyword);
        if (keyword == null) {
            keyword = getRandomKeywordFromListOfCategoriesByActive(false);
        }

        if (keyword == null) {
            throw new NullPointerException("На странице нет ни одной удовлетворяющей условию категории");
        }

        onOpened(AdminMediusCategoryPage.class).deleteCategory(getIdCategory(keyword));

        ThucydidesUtils.putToSession("keyword", keyword);
    }

    //Scenario: Edit name and genitive of category*
    @When("editor change name and genitive of any category with $symbol_in_keyword")
    public void editor_change_name_and_genitive_of_any_category_with(String symbol_in_keyword) {
        String keyword = getRandomKeywordFromListOfAllCategoriesWithSpecialKey(symbol_in_keyword);

        onOpened(AdminMediusCategoryPage.class).editNameAndGenitiveCategory(keyword);

        ThucydidesUtils.putToSession("keyword", keyword);
    }

    //Scenario: Change position of category in top*
    @When("editor change $position of any category")
    public void editor_change_of_any_category(String position) {
        String keyword = getRandomKeywordFromListCategoriesByActiveAndSticker(true, false);

        List<String> expectedListCategories = createExpectedListCategories(keyword, position);

        onOpened(AdminMediusCategoryPage.class)
                .changePositionCategory(position, keyword);

        ThucydidesUtils.putToSession("expectedListCategories", expectedListCategories);
    }

    //Scenario: Create new category
    //Scenario: Edit name and genitive of category*
    @Then("category is in List of categories on Categories Page")
    public void category_is_in_List_of_categories_on_Categories_Page() {
        String expectedName = ThucydidesUtils.getFromSession("name").toString();
        String expectedKeyword = ThucydidesUtils.getFromSession("keyword").toString();
        String expectedGenitive = ThucydidesUtils.getFromSession("genitive").toString();
        boolean expectedSticker = Boolean.parseBoolean(ThucydidesUtils.getFromSession("sticker").toString());
        boolean expectedActive = Boolean.parseBoolean(ThucydidesUtils.getFromSession("active").toString());

        String idCategory = getIdCategory(expectedKeyword);

        String receivedName = onOpened(AdminMediusCategoryPage.class).getCategoryName(idCategory);
        String receivedKeyword = onOpened(AdminMediusCategoryPage.class).getCategoryKeyword(idCategory);
        String receivedGenitive = onOpened(AdminMediusCategoryPage.class).getCategoryGenitive(idCategory);
        boolean receivedSticker = onOpened(AdminMediusCategoryPage.class).getCategorySticker(idCategory);
        boolean receivedActive = onOpened(AdminMediusCategoryPage.class).getCategoryActive(idCategory);

        verify().that(receivedName.equals(expectedName))
                .ifResultIsExpected("Category in List of Categories with: name = " + expectedName)
                .ifElse("Category did not found with expected name! Received name = " + receivedName)
                .and()
                .that(receivedGenitive.equals(expectedGenitive))
                .ifResultIsExpected("Category in List of Categories with: genitive = " + expectedGenitive)
                .ifElse("Category did not found d with expected genitive! Received genitive = " + receivedGenitive)
                .and()
                .that(receivedKeyword.equals(expectedKeyword))
                .ifResultIsExpected("Category in List of Categories with: keyword = " + expectedKeyword)
                .ifElse("Category did not found with expected keyword! Received keyword = " + receivedKeyword)
                .and()
                .that(receivedSticker == expectedSticker)
                .ifResultIsExpected("Category in List of Categories with: sticker = " + expectedSticker)
                .ifElse("Category did not found with expected sticker! Received sticker = " + receivedSticker)
                .and()
                .that(receivedActive == expectedActive)
                .ifResultIsExpected("Category in List of Categories with: activator = " + expectedActive)
                .ifElse("Category did not found with expected activator! Received activator = " + receivedActive)
                .finish();
    }

    //Scenario: Fail with adding category
    @Then("editor sees message about error and category is not in List of categories on Categories Page")
    public void editor_sees_message_about_error_and_category_is_not_in_List_of_categories_on_Categories_Page() {
        String categoryKeyword = ThucydidesUtils.getFromSession("keyword").toString();
        boolean rightMessageAboutError = false;
        String messageAboutError = onOpened(AdminMediusCategoryPage.class).getMessageAboutError();
        switch (messageAboutError) {
            case "Keyword can contain only lower-case letters (a-z), digits (0-9), and the underscore character (_)":
                rightMessageAboutError = true;
                break;
            case "Name of sticker is too long":
                rightMessageAboutError = true;
                break;
        }

        verify().that(rightMessageAboutError)
                .ifResultIsExpected("Right mesage: " + messageAboutError)
                .ifElse("Missing or wrong message: " + messageAboutError)
                .and()
                .that(getIdCategory(categoryKeyword) == null)
                .ifResultIsExpected("Category didn't added to List of Categories with: keyword = " + categoryKeyword)
                .ifElse("Category is added to List of Categories with: keyword = "
                        + onOpened(AdminMediusCategoryPage.class).getCategoryKeyword(getIdCategory(categoryKeyword)))
                .finish();
    }

    //Scenario: Delete category*
    @Then("category is not in List of categories on Categories Page")
    public void category_is_not_in_List_of_categories_on_Categories_Page() {
        String keyword = ThucydidesUtils.getFromSession("keyword").toString();

        verify().that(getIdCategory(keyword) == null)
                .ifResultIsExpected("Category was deleted List of Categories with: keyword = " + keyword)
                .ifElse("Category is in List of Categories with: keyword = "
                        + getIdCategory(keyword))
                .finish();
    }

    //Scenario: Change position of category in top*
    @Then("category changed its position")
    public void category_changed_its_position() {

        String expectedListCategories = ThucydidesUtils.getFromSession("expectedListCategories").toString();

        verify().that(onOpened(AdminMediusCategoryPage.class).listOfCategoriesChanged(expectedListCategories))
                .ifResultIsExpected("Positions of Medius active categories changed successfully")
                .ifElse("Positions of Medius active categories haven't changes")
                .finish();
    }

    private String getRandomKeywordFromListCategoriesByActiveAndSticker(boolean isActive, boolean isSticker) {
        List<ArrayList<String>> listIdWithKeywordOfCategories = getDBDate().medius().getListIdAndKeywordOfCategoriesByActiveAndSticker(isActive, isSticker);
        listIdWithKeywordOfCategories.get(1).subList(1, listIdWithKeywordOfCategories.get(0).size() - 2);

        return listIdWithKeywordOfCategories.get(1).get(new Random().nextInt(listIdWithKeywordOfCategories.get(1).size()));
    }

    private String getRandomKeywordFromListOfAllCategoriesWithSpecialKey(String key) {
        List<ArrayList<String>> listIdWithKeywordOfCategories = getDBDate().medius().getListIdAndKeywordOfAllCategories();
        String expectedKeyword = "";
        for (String keyword : listIdWithKeywordOfCategories.get(1)) {
            if (keyword.endsWith(key))
                expectedKeyword = keyword;
        }
        return expectedKeyword;
    }

    private String getRandomKeywordFromListOfCategoriesByActive(boolean isActive) {
        List<ArrayList<String>> listIdWithKeywordOfCategories = getDBDate().medius().getListIdAndKeywordOfCategoriesByActive(isActive);
        return listIdWithKeywordOfCategories.get(1).get(new Random().nextInt(listIdWithKeywordOfCategories.get(1).size()));
    }

    private List<String> createExpectedListCategories(String keyword, String position) {
        List<ArrayList<String>> listIdWithKeywordOfCategories = getDBDate().medius().getListIdAndKeywordOfCategoriesByActiveAndSticker(true, false);
        List<String> listOfKeywords = listIdWithKeywordOfCategories.get(1);

        if (position.equals("up")) {
            listOfKeywords.add(listOfKeywords.indexOf(keyword) - 1, keyword);
            listOfKeywords.remove(listOfKeywords.lastIndexOf(keyword));
        }

        if (position.equals("down")) {
            listOfKeywords.add(listOfKeywords.indexOf(keyword) + 2, keyword);
            listOfKeywords.remove(listOfKeywords.indexOf(keyword));
        }

        return listOfKeywords;
    }

    private String getIdCategory(String keyword) {
        try {
            return getDBDate().medius().getIdCategory(keyword);
        } catch (Exception ex) {
            return null;
        }

    }
}
