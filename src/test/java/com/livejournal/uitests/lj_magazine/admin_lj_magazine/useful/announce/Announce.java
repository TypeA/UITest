package com.livejournal.uitests.lj_magazine.admin_lj_magazine.useful.announce;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageLogged;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.admin_lj_magazine.AnnouncePage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.panferova
 */
public class Announce extends LJTest {

    ////////////////// нет аннотаций к шагам (где указывается стори)
    ////////////////// нет форматирования
    ////////////////// неправильное расположение шагов теста
    //////////////////зачем оборот user on Main Page and go to?
    ///////////////// Main Page нет и не должно быть и в тесте и в опиании
    @Given("logged user on Admin Magazine Announce")
    public void logged_user_on_Admin_Magazine_Announce() {
        String name = getDBDate().privileges().getUserWithPrivDiscovery();
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name));
        open(AnnouncePage.class);
    }

    @When("edit announce with image $image")
    public void edit_announce_with_image(String image) {
        int idSlot = getRedisDate().discovery().getMainAnnounceId();
        String urlPost = "http://www." + getSystemConfiguration().getBaseUrl() + "/magazine/"
                + getDBDate().discovery().getLastPostFromMainCategory() + ".html";
        String subject = utility().random().getRandomChar(10);
        String lead = utility().random().getRandomChar(15);
        onOpened(AnnouncePage.class)
                .editSlot(idSlot, image, urlPost, subject, lead);
        ThucydidesUtils.putToSession("linkTopost", urlPost);
        ThucydidesUtils.putToSession("subject", subject);
        ThucydidesUtils.putToSession("lead", lead);

    }

    @Then("announce with image $image is displayed on Lj Magazine")
    public void announce_with_image_is_displayed_on_Lj_Magazine(String image) {
        String linkTopost = ThucydidesUtils.getFromSession("linkTopost").toString();
        String subject = ThucydidesUtils.getFromSession("subject").toString();
        String lead = ThucydidesUtils.getFromSession("lead").toString();
        ThucydidesUtils.getFromSession("lead");
        verify().that(open(LJMagazinePageLogged.class)
                .announceIsExistOnLJMagazine(linkTopost, subject, lead, image))
                .ifResultIsExpected("Announce with link to post = " + linkTopost
                        + " and subject=" + subject + " and lead=" + lead
                        + " and image=" + image + " is exist")
                .ifElse("Announce with link to post = " + linkTopost
                        + " and subject=" + subject + " and lead=" + lead + " and image=" + image
                        + " is not exist")
                .finish();
    }

    @Then("post in previous announce is displayed on feed LJ Magazine")
    public void post_in_previous_announce_is_displayed_on_feed_LJ_Magazine() {

    }

    @When("create new announce with image $image")
    public void create_new_announce_with_image(String image) {
        int idSlot = getRedisDate().discovery().getNotMainAnnounceId();
        String urlPost = "http://www." + getSystemConfiguration().getBaseUrl() + "/magazine/"
                + getDBDate().discovery().getLastPostFromMainCategory() + ".html";
        String subject = utility().random().getRandomChar(10);
        String lead = utility().random().getRandomChar(15);
        onOpened(AnnouncePage.class)
                .editSlot(idSlot, image, urlPost, subject, lead);
        ThucydidesUtils.putToSession("linkTopost", urlPost);
        ThucydidesUtils.putToSession("subject", subject);
        ThucydidesUtils.putToSession("lead", lead);
    }

    @Then("new announce with image $image is dispalyed in widget")
    public void new_announce_with_image_is_dispalyed_in_widget(String image) {

    }
}
