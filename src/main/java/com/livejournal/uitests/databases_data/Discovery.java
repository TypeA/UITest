package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class Discovery extends DatabasesData{

    public String getIdCategories(String usualCategories) {
        int specialCategories = (Boolean.valueOf(usualCategories)) ? 0 : 1;
        String select = "select id from discovery_categories where special=" + specialCategories;
        ArrayList<String> ans = workWithDB().conect()
                .select(select, "id")
                .finish()
                .get(0);
        return ans.get(new Random().nextInt(ans.size()));
    }

    public String getKeywordCategories(String idCategory) {
        String select = "select keyword from discovery_categories where id = " + idCategory;
        return workWithDB().conect()
                .select(select, "keyword")
                .finish().get(0).get(0);
    }

    public String getNameCategory(String idCategory) {
        String select = "select name from discovery_categories where id = " + idCategory;
        return workWithDB().conect()
                .select(select, "name")
                .finish().get(0).get(0);
    }

    public String getJItemIdMagazine() {
        String select = "select max(magazine_jitemid) from magazine";
        return workWithDB().conect()
                .select(select, "magazine_jitemid*256")
                .finish().get(0).get(0);
    }

}
