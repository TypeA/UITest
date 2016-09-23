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

    public List<String> getListIdAndKeywordOfUsualActiveCategories() {
        String select = "select id, keyword from medius_categories where active =1 and type = 'C' and position !=1 order by position";

        List<String> listId = workWithDB().conect().select(select, "id").finish().get(0);
        List<String> listKeywords = workWithDB().conect().select(select, "keyword").finish().get(0);

        List<String> listIdWithKeyword = new ArrayList<>();
        for (int i = 0; i < listId.size(); i++) {
            listIdWithKeyword.add(listId.get(i) + " " + listKeywords.get(i));
        }

        return listIdWithKeyword;
    }


}
