/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.databasesData;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author m.panferova
 */
public class Tags extends DatabasesData {

    public ArrayList<String> getJitemidPostsWithKeyword(String user, String keyword) {
        String userClusterId = userData().getUserClusterId(user);
        String userId = userData().getUserId(user);
        String select = "select kwid from lj_c" + userClusterId + ".userkeywords where "
                + "userid=" + userId + " and keyword='" + keyword + "'";
        String keywordId = workWithDB().conect()
                .select(select, "kwid")
                .finish().get(0).get(0);
        String select1 = "select jitemid*256+anum from lj_c" + userClusterId + ".log2 where "
                + "jitemid in"
                + "(select jitemid from lj_c" + userClusterId + ".logtags where kwid=" + keywordId + " and journalid=" + userId + ") "
                + "and journalid =" + userId;
        return workWithDB().conect()
                .select(select, "jitemid*256+anum")
                .finish().get(0);
    }
}
