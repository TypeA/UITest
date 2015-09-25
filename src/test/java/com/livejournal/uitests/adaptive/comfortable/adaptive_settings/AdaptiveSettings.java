package com.livejournal.uitests.adaptive.comfortable.adaptive_settings;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.JournalPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import java.util.ArrayList;
import java.util.List;
import net.thucydides.core.annotations.StepGroup;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author s.savinykh
 */
public class AdaptiveSettings extends WebTest {

    //User see Air theme(1/3)
    //User see Adaptive Chameleon theme(1/3)
    //User see Non adaptive theme(1/3)
    //User see Non adaptive Chameleon theme(1/3)
    @Given("user $user")
    public void given_user(String user) {
        if (!user.toUpperCase().equals("UNLOGGED")) {
            open(LoginPageUnlogged.class).authorizeBy(user, getDBDate().userData().getUserPassword(user)).setOptionViewInMyStyle(user, "n");
        }
    }

    //User see correct theme in his journal(1/3)
    @Given("random user (paid $paid,mobile view $mobileView,style $style)")
    public void random_user(String paid, String mobileView, String style) {
        String user = getUser("Need pass", "Journal", paid, mobileView, style);
        ThucydidesUtils.putToSession("finded_user", user);
        open(LoginPageUnlogged.class).authorizeBy(user, getDBDate().userData().getUserPassword(user));
    }

    //User see correct theme in random journal with option 'in my style'(1/3)
    @Given("random user (paid $paid,mobile view $mobileView,style $style) with option in my style")
    public void random_user_with_option_in_my_style(String paid, String mobileView, String style) {
        String user = getUser("Need pass", "Journal", paid, mobileView, style);
        ThucydidesUtils.putToSession("viewer", user);
        open(LoginPageUnlogged.class).authorizeBy(user, getDBDate().userData().getUserPassword(user)).setOptionViewInMyStyle(user, "y");
    }

    //User see Air theme(2/3)
    //User see Adaptive Chameleon theme(2/3)
    //User see Non adaptive theme(2/3)
    //User see Non adaptive Chameleon theme(2/3)
    @When("user go to the journal (paid $paid,mobile view $mobileView,style $style) page")
    public void user_go_to_the_journal_page(String paid, String mobileView, String style) {
        String findedUser = getUser("DONT NEED PASS", "Journal", paid, mobileView, style);
        ThucydidesUtils.putToSession("finded_user", findedUser);
        open(JournalPage.class, new Url().setPrefix(findedUser + "."));
    }

    //User see correct theme in his journal(2/3)
    @When("user go to the his journal page")
    public void user_go_to_the_his_journal_page() {
        open(JournalPage.class, new Url().setPrefix(ThucydidesUtils.getFromSession("finded_user") + "."));
    }

    //User see correct theme in random journal with option 'in my style'(2/3)
    @When("user go to the random journal (paid $paid1,mobile view $mobileView1,style $style1) page")
    public void user_go_to_the_random_journal(String paid1, String mobileView1, String style1) {
        String findedUser = getUser("DONT NEED PASS", "Journal", paid1, mobileView1, style1);
        ThucydidesUtils.putToSession("finded_user", findedUser);
        open(JournalPage.class, new Url().setPrefix(findedUser + "."));
    }

    //User see Air theme(3/3)
    //User see Adaptive Chameleon theme(3/3)
    //User see Non adaptive theme(3/3)
    //User see Non adaptive Chameleon theme(3/3)
    //User see correct theme in his journal(2/3)
    @Then("user see correct style $correctStyle")
    public void user_see_correct_style(String correctStyle) {
        verify().that(isCorrectStyle(correctStyle))
                .ifResultIsExpected("User see correct style " + correctStyle + " in " + ThucydidesUtils.getFromSession("finded_user") + " journal")
                .ifElse("User see incorrect style in " + ThucydidesUtils.getFromSession("finded_user") + " journal")
                .finish();
    }

    //User see correct theme in random journal with option 'in my style'(2/3)
    @Then("random user see correct style $correctStyle in random journal")
    public void user_see_correct_style_in_random_journal(String correctStyle) {
        verify().that(isCorrectStyle(correctStyle))
                .ifResultIsExpected("User " + ThucydidesUtils.getFromSession("viewer") + " see correct style " + correctStyle + " in " + ThucydidesUtils.getFromSession("finded_user") + " journal")
                .ifElse("User " + ThucydidesUtils.getFromSession("viewer") + " see incorrect style " + correctStyle + " in " + ThucydidesUtils.getFromSession("finded_user") + " journal")
                .finish();
    }

    ///////////////////////////////////////METHODS///////////////////////////////////////
    @StepGroup
    private String getUser(String needPass, String userType, String paid, String mobileView, String style) {
        int index = 0;
        ArrayList<String> neededUsers = new ArrayList<>();
        String[] script = new String[3];
        script[0] = "SELECT user.user "
                + "FROM user "
                + "left join lj_c2.userproplite2 on user.userid = lj_c2.userproplite2.userid "
                + "left join lj_c1.userproplite2 on user.userid = lj_c1.userproplite2.userid "
                + "WHERE lj_c2.userproplite2.upropid = 402 "
                + "OR lj_c1.userproplite2.upropid = 402;"; //формирование запроса на включенную опцию

        for (Integer i = 1; i < 3; i++) {
            script[i] = "SELECT DISTINCT user.user "
                    + "FROM user ";
            if (needPass.toUpperCase().equals("NEED PASS")) {
                script[i] += "LEFT JOIN password ON user.userid=password.userid ";
            }
            script[i] += "left join lj_c" + i.toString() + ".userproplite2 on user.userid = lj_c" + i.toString() + ".userproplite2.userid "
                    + "left join s2styles on lj_c" + i.toString() + ".userproplite2.value = s2styles.styleid "
                    + "left join lj_c" + i.toString() + ".log2 on lj_c" + i.toString() + ".log2.journalid = user.userid "
                    + "WHERE  lj_c" + i.toString() + ".userproplite2.upropid = 96 "
                    + "AND user.statusvis = 'V' ";
            if (needPass.toUpperCase().equals("NEED PASS")) {
                script[i] += "AND password.password not like '%md5%' ";
            }
            script[i] += "AND lj_c" + i.toString() + ".log2.security = 'public' ";
            switch (userType.toUpperCase()) {
                case "JOURNAL":
                    script[i] += "AND user.journaltype = 'P' ";
                    break;
                case "COMMUNITY":
                    script[i] += "AND user.journaltype = 'C' ";
                    break;
                default:
                    script[i] += "AND user.journaltype = 'P' ";
                    break;
            }
            switch (paid.toUpperCase()) {
                case "TRUE":
                    script[i] += "AND ((user.caps & 1<<3 = 8) =1 or (user.caps & 1<<4=16)=1) ";
                    break;
                case "FALSE":
                    script[i] += "AND ((user.caps & 1<<3 = 8) =0 and (user.caps & 1<<4=16)=0) ";
                    break;
                default:
                    script[i] += "AND ((user.caps & 1<<3 = 8) =0 and (user.caps & 1<<4=16)=0) ";
                    break;
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
        }//формирование кластерных запросов для поиска подходящих пользователей
        List<ArrayList<String>> users = workWithDB().conect()
                .select(script[0], "user")
                .select(script[1], "user")
                .select(script[2], "user")
                .finish();//0 - все с включенной опцией, 1 - все заданные пользователи первого кластера, 2 - все заданные пользователи второго кластера
        users.get(1).addAll(users.get(2)); //соединение результатов с двух кластеров в один список
        users.get(1).remove("system"); //удаление пользователя system
        if (mobileView.toUpperCase().equals("TRUE")) {
            for (int i = 0; i < users.get(0).size(); i++) {
                if (users.get(1).contains(users.get(0).get(i))) {
                    neededUsers.add(users.get(0).get(i));
                }
            }
        } else {
            for (int i = 0; i < users.get(0).size(); i++) {
                users.get(1).remove(users.get(0).get(i));
            }
            neededUsers.addAll(users.get(1));
        }
        if (!neededUsers.isEmpty()) {
            index = (int) (Math.random() * (neededUsers.size()));
        } else {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!! НЕТ ДАННЫХ !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            neededUsers.set(index, "");
        }
        return neededUsers.get(index);
    }

    @StepGroup
    private Boolean isCorrectStyle(String style) {
        Boolean correct = false;
        switch (style.toUpperCase()) {
            case "AIR":
                try {
                    correct = !startScript("return jQuery('.entryunit__title a')[0]").toString().isEmpty();
                } catch (Exception ex) {
                    correct = false;
                }
                break;
            case "ADAPTIVE":
                try {
                    correct = (!startScript("return jQuery('.j-e-title')[0]").toString().isEmpty()) && (!startScript("return jQuery('.j-p-adaptability-on')[0]").toString().isEmpty());
                } catch (Exception ex) {
                    correct = false;
                }
                break;
            case "CHAMELEON":
                try {
                    correct = (!startScript("return jQuery('.j-e-title')[0]").toString().isEmpty()) && (!startScript("return jQuery('.j-p-adaptability-on')").toString().isEmpty());
                } catch (Exception ex) {
                    correct = false;
                }
                break;
            case "NONADAPTIVE":
                try {
                    correct = (!startScript("return jQuery('.entryunit__title a')[0]").toString().isEmpty()) || (!startScript("return jQuery('.j-e-title')[0]").toString().isEmpty());
                } catch (Exception ex) {
                    correct = true;
                }
                break;
        }
        return correct;
    }
}
