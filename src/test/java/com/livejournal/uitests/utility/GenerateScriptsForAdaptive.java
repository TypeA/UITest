package com.livejournal.uitests.utility;

/**
 *
 * @author s.savinykh
 */
public class GenerateScriptsForAdaptive {

    public static String scriptWithMobileView() {  //формирование запроса на включенную опцию Mobile View
        return "SELECT user.user "
                + "FROM user "
                + "left join lj_c2.userproplite2 on user.userid = lj_c2.userproplite2.userid "
                + "left join lj_c1.userproplite2 on user.userid = lj_c1.userproplite2.userid "
                + "WHERE lj_c2.userproplite2.upropid = 402 "
                + "OR lj_c1.userproplite2.upropid = 402;";

    }

    public static String[] scriptAllUsers(String needPass, String userType, Boolean paid, String style) { //формирование кластерных запросов для поиска подходящих пользователей
        String[] script = new String[2];

        for (Integer i = 0; i < 2; i++) {
            script[i] = "SELECT DISTINCT user.user "
                    + "FROM user ";
            if (needPass.toUpperCase().equals("NEED PASS")) {
                script[i] += "LEFT JOIN password ON user.userid=password.userid ";
            }
            script[i] += "left join lj_c" + (i + 1) + ".userproplite2 on user.userid = lj_c" + (i + 1) + ".userproplite2.userid "
                    + "left join s2styles on lj_c" + (i + 1) + ".userproplite2.value = s2styles.styleid "
                    + "left join lj_c" + (i + 1) + ".log2 on lj_c" + (i + 1) + ".log2.journalid = user.userid "
                    + "WHERE  lj_c" + (i + 1) + ".userproplite2.upropid = 96 "
                    + "AND user.statusvis = 'V' "
                    + "AND lj_c" + (i + 1) + ".log2.security = 'public' ";
            if (needPass.toUpperCase().equals("NEED PASS")) {
                script[i] += "AND password.password not like '%md5%' ";
            }

            if (userType.toUpperCase().equals("COMMUNITY")) {
                script[i] += "AND user.journaltype = 'C' ";
            } else {
                script[i] += "AND user.journaltype = 'P' ";
            }

            if (paid) {
                script[i] += "AND ((user.caps & 1<<3 = 8) =1 or (user.caps & 1<<4=16)=1) ";
            } else {
                script[i] += "AND ((user.caps & 1<<3 = 8) =0 and (user.caps & 1<<4=16)=0) ";
            }

            switch (style.toUpperCase()) {
                case "AIR":
                    script[i] += "AND s2styles.name like '%wizard-air/default_theme%';";
                    break;
                case "CHAMELEON":
                    script[i] += "AND s2styles.name like '%chameleon%' "
                            + "AND s2styles.name !='wizard-chameleon/__none' "
                            + "AND s2styles.name NOT LIKE '%chameleonljart%' "
                            + "AND s2styles.name NOT LIKE '%chamljartv2%' "
                            + "AND s2styles.name !='wizard-chameleon/__headerin_alpha' "
                            + "AND s2styles.name !='wizard-chameleon/bright-decorations' "
                            + "AND s2styles.name !='wizard-chameleon/orange-tinsel';";
                    break;
                case "NONADAPTIVE":
                    script[i] += "AND s2styles.name not like '%wizard-air/default_theme%' and  s2styles.name not like '%chameleon%';";
                    break;
                default:
                    script[i] += "AND s2styles.name not like '%wizard-air/default_theme%' and  s2styles.name not like '%chameleon%';";
                    break;
            }
        }
        return script;
    }

}
