package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {

        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");
        
        this.getCurrentBrowser().getDriver().getWindowHandles().size();

        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");

    }

}
