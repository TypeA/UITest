package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.List;

public class Medius extends DatabasesData {
    public String getIdCategory(String keyword) {
        String select = "select id from medius_categories where keyword = '" + keyword + "'";
        return workWithDB().conect().select(select, "id")
                .finish()
                .get(0)
                .get(0);
    }

    public List<ArrayList<String>> getListIdAndKeywordOfCategories(boolean isActive, boolean isSticker) {
        String select = "select id, keyword from medius_categories where";

        if (isActive)
            select = select.concat(" active =1 and");
        else select = select.concat(" active =0 and");

        if (isSticker)
            select = select.concat(" type = 'T' and position !=1 order by position");
        else select = select.concat(" type = 'C' and position !=1 order by position");

        return workWithDB().conect()
                .select(select, "id")
                .select(select, "keyword")
                .finish();
    }

    public List<ArrayList<String>> getListIdAndKeywordOfAllCategories() {
        String select = "select id, keyword from medius_categories where position !=1";

        return workWithDB().conect()
                .select(select, "id")
                .select(select, "keyword")
                .finish();
    }
}
