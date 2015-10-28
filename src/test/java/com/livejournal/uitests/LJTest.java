package com.livejournal.uitests;


import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.databasesData.DatabasesData;
import com.livejournal.uitests.utility.Utility;

public class LJTest extends WebTest {

    public DatabasesData getDBDate() {
        return new DatabasesData();
    }
    
    public Utility utility() {
        return new Utility();
    }

}
