package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

public class DB extends LJTest {
    
    @Given("data from DB")
    public void db() {
        System.out.println("START TEST +++++++++++++++++++++++++++++++");
        ArrayList<String> ans = this.getDBDate().bannedUser().getAllUserInBannedList("testautotest");
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
        System.out.println("STOP TEST +++++++++++++++++++++++++++++++");
        
    }
    
    @Then("table is displayed")
    public void table_is_displayed() {
        
    }
    
}
