package com.livejournal.uitests.new_test.new_good;

import com.livejournal.uisteps.thucydides.WebTest;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;

/**
 *
 * @author m.prytkova
 */
public class NewGood extends WebTest {

    @Given("new good test3")
    public void newT() throws SQLException {

        ArrayList<String> ans = baseConnect("select * from user limit 10", "user");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!test");
        for (int i=0; i<ans.size(); i++) {
            System.out.println(ans.get(i));//Последовательно для каждой строки выводим значение из колонки ColumnName
        }
        System.out.println(".......................browser");

    }
}
