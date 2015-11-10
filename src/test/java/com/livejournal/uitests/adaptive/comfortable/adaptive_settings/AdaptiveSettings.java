package com.livejournal.uitests.adaptive.comfortable.adaptive_settings;

import com.livejournal.uitests.LJTest;
import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.pages.journal_pages.JournalPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import static com.livejournal.uitests.utility.GetUsers.scriptAllUsers;
import static com.livejournal.uitests.utility.GetUsers.scriptWithMobileView;
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
public class AdaptiveSettings extends LJTest {

    //Scenario: User see Air theme(1/3)
    //Scenario: User see Adaptive Chameleon theme(1/3)
    //Scenario: User see Non adaptive theme(1/3)
    //Scenario: User see Non adaptive Chameleon theme(1/3)
    @Given("user $user")
    public void given_user(String user) {
        if (!user.toUpperCase().equals("UNLOGGED")) {
            open(LoginPageUnlogged.class)
                    .authorizeBy(user, getDBDate().userData().getUserPassword(user)).setOptionViewInMyStyle(user, "n");
        }
    }

    //Scenario: User see correct theme in his journal(1/3)
    @Given("random user (paid $paid,mobile view $mobileView,style $style)")
    public void random_user(String paid, String mobileView, String style) {
        String user = getNeededUser("Need pass", "Journal", Boolean.valueOf(paid), Boolean.valueOf(mobileView), style);
        ThucydidesUtils.putToSession("finded_user", user);
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
    }

    //Scenario: User see correct theme in random journal with option 'in my style'(1/3)
    @Given("random user (paid $paid,mobile view $mobileView,style $style) with option in my style")
    public void random_user_with_option_in_my_style(String paid, String mobileView, String style) {
        String user = getNeededUser("Need pass", "Journal", Boolean.valueOf(paid), Boolean.valueOf(mobileView), style);
        ThucydidesUtils.putToSession("viewer", user);
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user)).setOptionViewInMyStyle(user, "y");
    }

    //Scenario: User see Air theme(2/3)
    //Scenario: User see Adaptive Chameleon theme(2/3)
    //Scenario: User see Non adaptive theme(2/3)
    //Scenario: User see Non adaptive Chameleon theme(2/3)
    @When("user go to the journal (paid $paid,mobile view $mobileView,style $style) page")
    public void user_go_to_the_journal_page(String paid, String mobileView, String style) {
        String findedUser = getNeededUser("DONT NEED PASS", "Journal", Boolean.valueOf(paid), Boolean.valueOf(mobileView), style);
        ThucydidesUtils.putToSession("finded_user", findedUser);
        open(JournalPage.class, new Url().setPrefix(findedUser + "."));
    }

    //Scenario: User see correct theme in his journal(2/3)
    @When("user go to the his journal page")
    public void user_go_to_the_his_journal_page() {
        open(JournalPage.class, new Url().setPrefix(ThucydidesUtils.getFromSession("finded_user") + "."));
    }

    //Scenario: User see correct theme in random journal with option 'in my style'(2/3)
    @When("user go to the random journal (paid $paid1,mobile view $mobileView1,style $style1) page")
    public void user_go_to_the_random_journal(String paid1, String mobileView1, String style1) {
        String findedUser = getNeededUser("DONT NEED PASS", "Journal", Boolean.valueOf(paid1), Boolean.valueOf(mobileView1), style1);
        ThucydidesUtils.putToSession("finded_user", findedUser);
        open(JournalPage.class, new Url().setPrefix(findedUser + "."));
    }

    //Scenario: User see Air theme(3/3)
    //Scenario: User see Adaptive Chameleon theme(3/3)
    //Scenario: User see Non adaptive theme(3/3)
    //Scenario: User see Non adaptive Chameleon theme(3/3)
    //Scenario: User see correct theme in his journal(2/3)
    @Then("user see correct style $correctStyle")
    public void user_see_correct_style(String correctStyle) {
        verify().that(isCorrectStyle(correctStyle))
                .ifResultIsExpected("User see correct style " + correctStyle + " in " + ThucydidesUtils.getFromSession("finded_user") + " journal")
                .ifElse("User see incorrect style in " + ThucydidesUtils.getFromSession("finded_user") + " journal")
                .finish();
    }

    //Scenario: User see correct theme in random journal with option 'in my style'(2/3)
    @Then("random user see correct style $correctStyle in random journal")
    public void user_see_correct_style_in_random_journal(String correctStyle) {
        verify().that(isCorrectStyle(correctStyle))
                .ifResultIsExpected("User " + ThucydidesUtils.getFromSession("viewer") + " see correct style " + correctStyle + " in " + ThucydidesUtils.getFromSession("finded_user") + " journal")
                .ifElse("User " + ThucydidesUtils.getFromSession("viewer") + " see incorrect style " + correctStyle + " in " + ThucydidesUtils.getFromSession("finded_user") + " journal")
                .finish();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @StepGroup
    private String getNeededUser(String needPass, String userType, Boolean paid, Boolean mobileView, String style) {

        List<ArrayList<String>> users = getAllUsers(needPass, userType, paid, style);
        users.get(1).addAll(users.get(2)); //соединение результатов с двух кластеров в один список
        users.get(1).remove("system"); //удаление пользователя system
        
        ArrayList<String> neededUsers = new ArrayList<>();
        if (mobileView) {
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

        int index = 0;
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
        String script1 = "", script2 = "";
        switch (style.toUpperCase()) {
            case "AIR":
                script1 = "return jQuery('.entryunit__title a')[0]";
                script2 = "return jQuery('.entryunit__title a')[0]";
                break;
            case "ADAPTIVE":
                script1 = "return jQuery('.j-e-title')[0]";
                script2 = "return jQuery('.j-p-adaptability-on')[0]";
                break;
            case "CHAMELEON":
                script1 = "return jQuery('.j-e-title')[0]";
                script2 = "return jQuery('.j-p-adaptability-on')";
                break;
            case "NONADAPTIVE":
                script1 = "return jQuery('.entryunit__title a')[0]";
                script2 = "return jQuery('.j-e-title')[0]";
                break;
        }
        
        try {
            return (!startScript(script1).toString().isEmpty()) && (!startScript(script2).toString().isEmpty());
        } catch (Exception ex) {
            return style.toUpperCase().equals("NONADAPTIVE");
        }
    }


    private List<ArrayList<String>> getAllUsers(String needPass, String userType, Boolean paid, String style) {
        return workWithDB().conect()
                .select(scriptWithMobileView(), "user")
                .select(scriptAllUsers(needPass, userType, paid, style)[0], "user")
                .select(scriptAllUsers(needPass, userType, paid, style)[1], "user")
                .finish();
    }
}
