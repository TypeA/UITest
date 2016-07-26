package com.livejournal.uitests.medius.admin.create_post.useful.success;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.databases_data.Post;
import com.livejournal.uitests.medius.admin.MediusListPosition;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.medius.admin.update.ColumnsListOfPost;
import com.livejournal.uitests.pages.service_pages.medius.admin.update.ListOfPost;
import com.livejournal.uitests.pages.service_pages.medius.admin.update.MediusUpdateBml;
import com.livejournal.uitests.pages.service_pages.medius.admin.update.PreviewPost;
import org.jbehave.core.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;


public class Success extends LJTest {


    private String subject = "subject";
    private String lead = "lead";
    private String body = "body";
    private String authors = "authors";

    @Given("logged user (name $user) on Admin Medius Create Post")
    public void logged_user_on_Admin_Medius_Create_Post(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                .defaultLanguageLogged(user)
                .setDefaultStyle(user);
        open(MediusUpdateBml.class);
    }

    @When("create post without source in random category")
    public void create_post_without_source_in_random_category() {
        String subject = utility().random().getRandomText(10);
        String lead = utility().random().getRandomText(30);
        String body = utility().random().getRandomText(50);
        onOpened(MediusUpdateBml.class)
                .closeDraft()
                .enterTextInTemaLeadBody(subject, lead, body)
                .postToMedius();
        ThucydidesUtils.putToSession(this.subject, subject);
        ThucydidesUtils.putToSession(this.lead, lead);
        ThucydidesUtils.putToSession(this.body, body);
    }

    @When("create post with source in random category")
    public void create_post_with_source_in_random_category() {
        String subject = utility().random().getRandomText(10);
        String lead = utility().random().getRandomText(30);
        String body = utility().random().getRandomText(50);
        String source = getDBDate().userData().getActiveUserWithPosts();
        String ditemid = getDBDate().posts().getUserPostId(new Post().publicSecurity, source);
        String url = utility().calculation().createUrlToPost(source, ditemid);
        onOpened(MediusUpdateBml.class)
                .closeDraft()
                .enterTextInTemaLeadBody(subject, lead, body)
                .enterSource(url, 1)
                .postToMedius();
        ThucydidesUtils.putToSession(this.subject, subject);
        ThucydidesUtils.putToSession(this.lead, lead);
        ThucydidesUtils.putToSession(this.body, body);
        ThucydidesUtils.putToSession(this.authors, new ArrayList<String>(Arrays.asList(source)));
    }
    @When("create interesting post in random category")
    public void create_interesting_post_in_random_category(){
        String subject = utility().random().getRandomText(12);
        String lead = utility().random().getRandomText(35);
        String body = utility().random().getRandomText(102);
        onOpened(MediusUpdateBml.class)
                .closeDraft()
                .enterTextInTemaLeadBody(subject, lead, body)
                .setInteresting()
                .postToMedius();
        ThucydidesUtils.putToSession(this.subject, subject);
        ThucydidesUtils.putToSession(this.lead, lead);
        ThucydidesUtils.putToSession(this.body, body);
    }

    @When("create main post in random category")
    public void create_main_post_in_random_category(){
        String subject = utility().random().getRandomText(15);
        String lead = utility().random().getRandomText(38);
        String body = utility().random().getRandomText(150);
        onOpened(MediusUpdateBml.class)
                .closeDraft()
                .enterTextInTemaLeadBody(subject, lead, body)
                .setMainPost()
                .postToMedius();
        ThucydidesUtils.putToSession(this.subject, subject);
        ThucydidesUtils.putToSession(this.lead, lead);
        ThucydidesUtils.putToSession(this.body, body);
    }


    @Then("admin can not change date and privacy settings")
    public void admin_can_not_change_date_and_privacy_settings() {
        verify().that(!(onOpened(MediusUpdateBml.class)
                .adminCanNotChangeDateUserAndPrivacy()))
                .ifResultIsExpected("admin can not change date and privacy settings")
                .ifElse("admin can change date and privacy settings")
                .finish();
    }

    @Then("post is created with author lj_media and editor $user")
    public void post_is_created_with_author_lj_media_and_editor(String user) {
        ColumnsListOfPost valueOfColumn = new ColumnsListOfPost();
        String sub = ThucydidesUtils.getFromSession(this.subject).toString();
        String lead = ThucydidesUtils.getFromSession(this.lead).toString();
        valueOfColumn.setSubject(sub);
        valueOfColumn.setEditor(user);
        verify().that(onOpened(ListOfPost.class)
                .postIsExistInList(valueOfColumn))
        .ifResultIsExpected("Post with "+ sub + " and with editor "+user + " is dispalyed")
        .ifElse("Post with "+ sub + " and with editor "+user + " does not dispalyed")
        .finish();
        onOpened(ListOfPost.class)
                .openPost(valueOfColumn.getSubject());
        verify().that(onOpened(PreviewPost.class)
                .subjectLeadBodyExist(sub, lead))
        .ifResultIsExpected("Preview post is displayed")
        .ifElse("Preview post does not displayed")
        .finish();
    }

    @Then("post is created with authors and editor $user")
    public void post_is_created_with_authors_and_editor(String user) {
        ColumnsListOfPost valueOfColumn = new ColumnsListOfPost();
        String sub = ThucydidesUtils.getFromSession(this.subject).toString();
        String lead = ThucydidesUtils.getFromSession(this.lead).toString();
        ArrayList<String> source =(ArrayList<String>)ThucydidesUtils.getFromSession(this.authors);
        valueOfColumn.setSubject(sub);
        valueOfColumn.setEditor(user);
        valueOfColumn.setAuthors(source);
        verify().that(onOpened(ListOfPost.class)
                .postIsExistInList(valueOfColumn))
        .ifResultIsExpected("Post with source is displayed in list")
        .ifElse("Post with source does not displayed in list")
        .finish();
    }

    @Then("interesting post is created editor $user")
    public void interesting_post_is_created(String user){
        ColumnsListOfPost valueOfColumn = new ColumnsListOfPost();
        String sub = ThucydidesUtils.getFromSession(this.subject).toString();
        valueOfColumn.setInterestingPost();
        valueOfColumn.setSubject(sub);
        valueOfColumn.setEditor(user);
        verify().that(onOpened(ListOfPost.class)
                .postIsExistInList(valueOfColumn))
                .ifResultIsExpected("Interesting post is displayed in list")
                .ifElse("Interesting post does not displayed in list")
                .finish();
    }


    @Then("main post is created witn editor $user")
    public void main_post_is_created_witn_editor(){
        ColumnsListOfPost valueOfColumn = new ColumnsListOfPost();
        valueOfColumn.setSubject(ThucydidesUtils.getFromSession(this.subject).toString());
        ArrayList<String> mediusListPosition = new ArrayList();
        mediusListPosition.add(new MediusListPosition().getMainPage());
        valueOfColumn.setMain(mediusListPosition);
        verify().that(onOpened(ListOfPost.class)
        .postIsExistInList(valueOfColumn))
                .ifResultIsExpected("Main post is displayed in list")
                .ifElse("Main post does not displayed in list")
                .finish();
    }



}