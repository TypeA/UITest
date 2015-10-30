package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class Privileges extends DatabasesData {

    public String getUserWithPrivDiscovery() {
        String select = "select user.user, priv_list.privcode, priv_map.arg  from user "
                + "left join priv_map on priv_map.userid=user.userid "
                + "left join priv_list on priv_list.prlid=priv_map.prlid "
                + "where priv_list.privcode='siteadmin' "
                + "and (priv_map.arg='discovery' or priv_map.arg='*') "
                + "and user.user like '%test%';";
        ArrayList<String> ans = workWithDB().conect()
                .select(select, "user")
                .finish()
                .get(0);
        return ans.get(new Random().nextInt(ans.size()));
    }

}
