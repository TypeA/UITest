/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.lj_magazine.admin_lj_magazine.useful.announce;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageLogged;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.admin_lj_magazine.AnnouncePage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import static com.livejournal.uitests.utility.RandomOnlyChar.getRandomChar;
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
    @Given("logged user on Main Page and go to Admin Magazine Announce")
    public void logged_user_on_Main_Page_and_go_to_Admin_Magazine_Announce() {

        String name = getDBDate().privileges().getUserWithPrivDiscovery();
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name));
        open(AnnouncePage.class);
    }

    //////////////// main announce это гдавный пост? если да, можно вполне обойтись без main
    @When("create new main announce with image $image")
    public void create_new_main_announce_with_image(String image) {
        int idSlot = getRedisData().discovery().getMainAnnounceId();
        String urlPost = "http://www." + getSystemConfiguration().getBaseUrl() + "/magazine/" + getDBDate().discovery().getJItemIdMagazine() + ".html";
        String subject = getRandomChar(10);
        String lead = getRandomChar(15);
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

    @When("remove existing main announce and create new main announce with image $image")
    public void remove_existing_main_announce_and_create_new_main_announce(String image) {
        int idSlot = getRedisData().discovery().getMainAnnounceId();
        
        
        /////////////////// а разве выделенный кусок не избыточен?
        /////////////////// вроде то же самое в методе getMainAnnounceId
        for (int i = 1; i < 4; i++) {
            if (i != idSlot) {
                idSlot = i;
                break;
            }
        }
        //////////////////
        
        
        String urlPost = "http://www." + getSystemConfiguration().getBaseUrl() + "/magazine/" + getDBDate().discovery().getJItemIdMagazine() + ".html";
        String subject = getRandomChar(10);
        String lead = getRandomChar(15);
        onOpened(AnnouncePage.class)
                .editSlot(idSlot, image, urlPost, subject, lead);
        ThucydidesUtils.putToSession("linkTopost", urlPost);
        ThucydidesUtils.putToSession("subject", subject);
        ThucydidesUtils.putToSession("lead", lead);
    }
    @Then("new main announce with image $image is dispalyed in widget")
    public void new_main_announce_with_image_is_dispalyed_in_widget(String image){
        
    
    }
    
    
    //////////////// см. то же самое во втором тесте
}
