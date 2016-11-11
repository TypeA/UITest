package com.livejournal.uitests.DB;

import com.livejournal.uitests.LJTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

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
        List<ArrayList<String>> listIdWithKeywordOfCategories = getDBDate().medius().getListIdAndKeywordOfCategoriesByActiveAndSticker(true, false);
        listIdWithKeywordOfCategories.get(1).subList(1, listIdWithKeywordOfCategories.get(0).size() - 2);
        return listIdWithKeywordOfCategories.get(1).get(new Random().nextInt(listIdWithKeywordOfCategories.get(1).size()));
    }

}
