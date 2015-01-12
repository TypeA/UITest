/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() throws SQLException {

        String select = "select * from user limit 10";
        String column = "user";

        System.out.println("!!!!!!!!!!!!! test start");

        ArrayList<String> answer = this.baseConnect(select, column);

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }

        System.out.println("!!!!!!!!!!!!! test stop");

  
    }
}
