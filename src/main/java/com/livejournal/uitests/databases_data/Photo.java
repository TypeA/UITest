package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.Random;

public class Photo extends DatabasesData {
    
    public String getRandomPhotoIdWithSizeAndSecurity(String user, String security, String size) {
        String userId = userData().getUserId(user);
        String clusterId = userData().getUserClusterId(user);
        if (size.length() <= 0 || size.equals("Original")) {
            size = "100";
        }
        String select = "select photo_id from lj_c" + clusterId + ".fotki_photo_prop where userid=" + userId + " and "
                + "propname='height' and value>=" + size + " and photo_id in"
                + "(select photo_id from lj_c" + clusterId + ".fotki_photo_prop where"
                + " userid=" + userId + " and propname='width' and value>=" + size + ")";
        ArrayList<String> ans = workWithDB()
                .conect()
                .select(select, "photo_id")
                .finish()
                .get(0);
        String joinedAns = String.join(", ", ans);
        //не понятно откуда взялся album_id=71. Он нигде не отображется на web. Возможно, это альбом для превью.
        String select1 = "Select photo_id from lj_c" + clusterId + ".fotki_photos where userid = " + userId
                + " and security = '" + security + "' and album_id!=71 and photo_id in(" + joinedAns + ")";
        System.out.println(select1);
        System.out.println(select);
        ArrayList<String> ans1 = workWithDB()
                .conect()
                .select(select1, "photo_id")
                .finish()
                .get(0);
        return ans1.get(new Random().nextInt(ans1.size()));
    }
    
    public String getAlbumContainsPhotoId(String photoId, String user) {
        String userId = userData().getUserId(user);
        String clusterId = userData().getUserClusterId(user);
        String select = "Select album_id from lj_c" + clusterId + ".fotki_photos where userid = " + userId + " and "
                + "photo_id=" + photoId;
        String albumId = workWithDB()
                .conect()
                .select(select, "album_id")
                .finish()
                .get(0)
                .get(0);
        String select1 = "Select album_title from lj_c" + clusterId + ".fotki_albums where userid=" + userId + " and album_id=" + albumId;
        return workWithDB()
                .conect()
                .select(select1, "album_title")
                .finish()
                .get(0)
                .get(0);
    }
    
    public String getPhotoIdInUrl(String user, String photoId) {
        String userId = userData().getUserId(user);
        String clusterId = userData().getUserClusterId(user);
        String select = "Select photo_id*256+auth from lj_c" + clusterId + ".fotki_photos where userid=" + userId + " and photo_id=" + photoId;
        return workWithDB()
                .conect()
                .select(select, "photo_id*256+auth")
                .finish()
                .get(0)
                .get(0);
    }    
}
