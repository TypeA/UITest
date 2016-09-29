package com.livejournal.uitests.DB;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.create_edit_post.privacy.useful.post_in_community.SelectCommunityUserList;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.livejournal.uitests.pages.service_pages.medius.admin.category.AdminMediusCategoryPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {
        System.out.println("START TEST +++++++++++++++++++++++++++++++");
        System.out.println(getRandomKeywordFromListCategories());
        System.out.println("STOP TEST +++++++++++++++++++++++++++++++ ");

    }

    @Then("table is displayed")
    public void table_is_displayed() {

    }


    public String getRandomKeywordFromListCategories() {
        List<ArrayList<String>> listIdWithKeywordOfCategories = getDBDate().medius().getListIdAndKeywordOfCategories(true, false);
        listIdWithKeywordOfCategories.get(1).subList(1, listIdWithKeywordOfCategories.get(0).size() - 2);
        return listIdWithKeywordOfCategories.get(1).get(new Random().nextInt(listIdWithKeywordOfCategories.get(1).size()));
    }

}
