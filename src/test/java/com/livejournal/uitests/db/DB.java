package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {

        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");
        
        String rgb = "rgb(36, 55, 227)";
        System.out.println(utility().convertation().RgbToHex(rgb));

        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");

    }

}
