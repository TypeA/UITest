package com.livejournal.uitests.create_edit_post.lj_tags.useful.ljcut;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author s.savinykh
 */
public class Ljcut extends LJTest {

    //Scenario: User can create new entry with lj-cut (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .setDefaultStyle(name);
        open(UpdateBmlPageLogged.class);
    }

    @When("user use lj-cut $ljcut and put some text in it")
    public void user_use_ljcut_and_put_some_information_in_it(String ljcut) {
        String before = utility().random().getRandomText(10);
        ThucydidesUtils.putToSession("before", before);
        String after = utility().random().getRandomText(10);
        ThucydidesUtils.putToSession("after", after);
        String text = utility().random().getRandomText(10);
        ThucydidesUtils.putToSession("text", text);
        onOpened(UpdateBmlPageLogged.class)
                .usePostContent()
                .useHTMLEditor()
                .setLJCut(ljcut)
                .setTextInsideLJCut(before, text, after)
                .usePage()
                .postEntry();
    }

    @Then("the post is in journal and contains lj-cut with some information in it")
    public void post_in_journal_and_contains_ljcut_with_some_information_in_it() {
        System.out.println("---------");
    }

}
