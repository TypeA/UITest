/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() throws SQLException {

        System.out.println("!!!!!!!!!!!!! test start");

        String ans = workWithDB().getUserPassword("testautotest");
        System.out.println(ans);

        //String password = this.getUserPassword("testautotest");
        //System.out.println(password);
        System.out.println("!!!!!!!!!!!!! test stop");

    }
}
