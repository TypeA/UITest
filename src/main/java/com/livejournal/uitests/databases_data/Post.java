package com.livejournal.uitests.databases_data;

import java.util.ArrayList;

/**
 *
 * @author m.prytkova
 */
public class Post extends DatabasesData {

    public final String publicSecurity = "public";



    public String getUserPostId(String security, String user) {
        String useridAndCluster = "select userid, clusterid from user where user='"+user+"'";
        String userid = workWithDB().conect()
                .select(useridAndCluster, "userid")
                .finish().get(0).get(0);

        String clusterid = workWithDB().conect()
                .select(useridAndCluster, "clusterid")
                .finish().get(0).get(0);
        String select = "select jitemid*256+anum from lj_c"+clusterid+".log2 "
                + "where journalid="+userid
                + " and security = '" + security + "' order "
                + "by rand() limit 1";

        return workWithDB().conect()
                .select(select, "jitemid*256+anum")
                .finish().get(0).get(0);
    }

    public ArrayList<String> getPostIdByKeyword(String user, String keyword) {
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
                .select(select1, "jitemid*256+anum")
                .finish().get(0);
    }

}
