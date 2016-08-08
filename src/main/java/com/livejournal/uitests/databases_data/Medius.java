package com.livejournal.uitests.databases_data;

public class Medius extends DatabasesData {
    public String getIdCategory(String name, String keyword, String genitive) {
        String select = "select id from medius_categories where keyword = '" + keyword + "' " +
                "and name='" + name + "' " +
                "and genitive = '" + genitive + "'";
        return workWithDB().conect().select(select, "id")
                .finish()
                .get(0)
                .get(0);
    }
}
