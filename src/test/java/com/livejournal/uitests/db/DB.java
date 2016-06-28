package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

public class DB extends LJTest {
    
    @Given("data from DB")
    public void db() {
        System.out.println("START TEST +++++++++++++++++++++++++++++++");
        String text = utility().random().getRandomText(55);
        System.out.println(text);
        System.out.println(text.substring(0,50));
        System.out.println("STOP TEST +++++++++++++++++++++++++++++++");
        
    }
    
    @Then("table is displayed")
    public void table_is_displayed() {
        
    }
    
}
