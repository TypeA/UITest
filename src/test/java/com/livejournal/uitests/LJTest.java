package com.livejournal.uitests;


import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.databasesData.DatabasesData;

public class LJTest extends WebTest {

    public DatabasesData getDBDate() {
        return new DatabasesData();
    }

}
