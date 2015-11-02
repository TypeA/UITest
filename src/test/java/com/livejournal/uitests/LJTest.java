package com.livejournal.uitests;


import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.redis_data.RedisData;
import com.livejournal.uitests.databases_data.DatabasesData;
import com.livejournal.uitests.utility.Utility;

public class LJTest extends WebTest {

    public DatabasesData getDBDate() {
        return new DatabasesData();
    }
    
    public RedisData getRedisDate() {
        return new RedisData();
    }
    
    
    public Utility utility() {
        return new Utility();
    }

}
