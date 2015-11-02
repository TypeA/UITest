package com.livejournal.uitests.databases_data;

/**
 *
 * @author m.prytkova
 */
public class Post extends DatabasesData {

    public String getUserPostId(String security, String user) {
        String select = "select jitemid*256+anum from lj_c2.log2 "
                + "where journalid in(select userid from user where user='" + user + "') "
                + "and security '" + security + "' order "
                + "by rand() limit 1";
        return workWithDB().conect()
                .select(select, "jitemid*256+anum")
                .finish().get(0).get(0);
    }

}
