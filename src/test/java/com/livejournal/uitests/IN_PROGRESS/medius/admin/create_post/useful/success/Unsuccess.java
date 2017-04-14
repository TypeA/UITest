package com.livejournal.uitests.IN_PROGRESS.medius.admin.create_post.useful.success;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.databases_data.Post;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.medius.admin.update.MediusUpdateBml;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
import org.jbehave.core.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;


public class Unsuccess  extends LJTest {


   @Given(value = "a step that is executed before each scenario")
   public void a_step_that_is_executed_before_each_scenario() {
        System.out.println("!!!!!!!");
    }

    @Given("logged editor (name $user) on Admin Medius Create Post")
    public void logged_user_on_Admin_Medius_Create_Post(String user){
        System.out.println("!!!!!!!!");
//        open(LoginPageUnlogged.class)
//                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
//                .defaultLanguageLogged(user)
//                .setDefaultStyle(user);
//        open(MediusUpdateBml.class);
    }
    @When("create post without source in random category")
    public void create_post_without_source_in_random_category() {
        String subject = utility().random().getRandomText(10);
        String lead = utility().random().getRandomText(30);
        String body = utility().random().getRandomText(50);
//     String source = getDBDate().userData().getActiveUserWithPosts();
//
//
//        String ditemid = getDBDate().posts().getUserPostId(new Post().publicSecurity, source);
//        String url = utility().calculation().createUrlToPost(source, ditemid);
//        onOpened(MediusUpdateBml.class)
//                .closeDraft()
//                .enterTextInTemaLeadBody(subject, lead, body)
//                .enterSource(url, 1)
//                .postToMedius();
//        ThucydidesUtils.putToSession(this.subject, subject);
//        ThucydidesUtils.putToSession(this.lead, lead);
//        ThucydidesUtils.putToSession(this.body, body);
//        ThucydidesUtils.putToSession(this.authors, new ArrayList<String>(Arrays.asList(source)));
    }
}