package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.create_edit_post.privacy.useful.post_in_community.SelectCommunityUserList;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {
        System.out.println("START TEST +++++++++++++++++++++++++++++++");
        String user = getDBDate().community().getMember("test_comm");
       /* ArrayList<String> users =getDBDate().community().getAllMembers("test_comm");
        for(int i=0; i<users.size();i++){
        System.out.println("user " + users.get(i));
        }*/
        System.out.println("STOP TEST +++++++++++++++++++++++++++++++ " + user);



    }

    @Then("table is displayed")
    public void table_is_displayed() {

    }


}
