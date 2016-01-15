package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.Random;

public class Video extends DatabasesData {

    public String getVideoIdWithSecurity(String user, String security) {
        String select = " select id from lj_c" 
                + userData().getUserClusterId(user) + ".video_records "
                + "where userid=" + userData().getUserId(user) 
                + " and security='" + security + "'";
        ArrayList<String> ans = workWithDB()
                .conect()
                .select(select, "id")
                .finish()
                .get(0);
        return ans.get(new Random().nextInt(ans.size()));
    }

    public String getVideoName(String user, String videoId) {
        String select = "select name from lj_c" 
                + userData().getUserClusterId(user) + ".video_records"
                + " where userid=" + userData().getUserId(user) 
                + " and id=" + videoId;
        return workWithDB()
                .conect()
                .select(select, "name")
                .finish()
                .get(0)
                .get(0);
    }

    public String getVideoAlbumName(String user, String videoId) {
        String userId = userData().getUserId(user);
        String clusterId = userData().getUserClusterId(user);
        String select = "select albumid from lj_c" + clusterId + ".video_records "
                + "where userid = " + userId + " and id=" + videoId;
        String albumId = workWithDB()
                .conect()
                .select(select, "albumid")
                .finish()
                .get(0)
                .get(0);
        String select1 = "select name from lj_c" + clusterId + ".video_albums "
                + "where userid =" + userId + " and id=" + albumId;
        return workWithDB()
                .conect()
                .select(select1, "name")
                .finish()
                .get(0)
                .get(0);
    }

    public String getVideoIdInUrl(String user, String videoId) {
        String select = "select storageid from lj_c" 
                + userData().getUserClusterId(user) 
                + ".video_records where id=" + videoId 
                + " and userid=" + userData().getUserId(user);
        return workWithDB()
                .conect()
                .select(select, "storageid")
                .finish()
                .get(0)
                .get(0);

    }

}
