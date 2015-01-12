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

        /*
         System.out.println("+++++++++++++++");

         String user = "root";//Логин пользователя
         String password = "";//Пароль пользователя
         String url = "jdbc:mysql://127.0.0.1:2222/livejournal";//URL адрес
         String driver = "com.mysql.jdbc.Driver";//Имя драйвера
         try {
         Class.forName(driver);//Регистрируем драйвер
         } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         }
         Connection c = null;//Соединение с БД

         System.out.println("!!!!!!!!!!!!!!!!!!!!");
         try {
         c = (Connection) DriverManager.getConnection(url, user, password);//Установка соединения с БД
         Statement st = c.createStatement();//Готовим запрос
         ResultSet rs = st.executeQuery("select * from user limit 10");//Выполняем запрос к БД, результат в переменной rs
         while (rs.next()) {
         System.out.println(rs.getString("user"));//Последовательно для каждой строки выводим значение из колонки ColumnName
         }
         } catch (Exception e) {
         e.printStackTrace();
         } finally {
         //Обязательно необходимо закрыть соединение
         try {
         if (c != null) {
         c.close();
         }
         } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         }
         }*/
    }
}
