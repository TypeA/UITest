package com.livejournal.uitests.redis_data;

import com.livejournal.uisteps.thucydides.RedisDatabase;

/**
 *
 * @author m.prytkova
 */
public class RedisData extends RedisDatabase {

    public Discovery discovery() {
        return new Discovery();
    }

    public class Discovery extends RedisData {

        public int getMainAnnounceId() {
            int idSlot = 1;
            for (int i = 1; i < 4; i++) {
                if (redis().existKey("disc.ann." + i)) {
                    String mainSlot = redis().hashGetData("disc.ann." + i, "main");
                    if (mainSlot.equals("1")) {
                        idSlot = i;
                        break;
                    }
                }
            }
            return idSlot;
        }
    }

    public int getNotMainAnnounceId() {
        int idSlot = discovery().getNotMainAnnounceId();
        for (int i = 1; i < 4; i++) {
            if (i != idSlot) {
                idSlot = i;
            }
        }
        return idSlot;
    }

}
