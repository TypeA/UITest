package com.livejournal.uitests.all_site;

import com.livejournal.uitests.DB.DB;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jbehave.core.annotations.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author m.prytkova
 */
public class AllSite extends LJTest {

    @Given("TOS on all pages")
    public void tos_on_all_pages() {
        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");

        ArrayList<String> pages = scanerUrl("C:\\Users\\m.prytkova\\Desktop\\links.txt");

        open(LoginPageUnlogged.class)
                .authorizeBy("test", "test");

        for (int i = 0; i < pages.size(); i++) {

            this.openUrl(pages.get(i));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }

            boolean win = Boolean.valueOf(this.startScript("return jQuery('.flatblue.rutos').is(':visible')").toString());
            if (!win) {
                this.openUrl("http://www.lj-9-new.local.bulyon.com/admin/propedit.bml?prop=legal_tosagree&user=testautotest");
                this.startScript("jQuery('.propedit-value input').attr('checked','checked');");
                this.startScript("jQuery('.propedit-submit input').click()");

                this.openUrl(pages.get(i));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            boolean winOpen = Boolean.valueOf(this.startScript("return jQuery('.flatblue.rutos').is(':visible')").toString());
            verify().that(winOpen)
                    .ifResultIsExpected("Окно появилось на странице " + pages.get(i))
                    .ifElse("Окно НЕ появилось на странице " + winOpen)
                    .finish();

            if (winOpen) {
                this.startScript("jQuery('.rutos__checkbox input').click()");
                this.startScript("jQuery('.rutos__actions button.flatbutton.rutos__action')[1].click()");
            }

            boolean winClosed = Boolean.valueOf(this.startScript("return jQuery('.flatblue.rutos').is(':visible')").toString());
            verify().that(!winClosed)
                    .ifResultIsExpected("Окно закрылось на странице " + pages.get(i))
                    .ifElse("Окно НЕ закрылось на странице ")
                    .finish();

            if (!winClosed) {
                this.openUrl("http://www.lj-9-new.local.bulyon.com/admin/propedit.bml?prop=legal_tosagree&user=testautotest");
                this.startScript("jQuery('.propedit-value input').attr('checked','checked');");
                this.startScript("jQuery('.propedit-submit button').click()");
            }
        }

    }

    @Given("user $name with design $design get all links on all pages")
    public void all_links_all_pages(String name, String design) {
        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");

        ArrayList<String> pages = scanerUrl("C:\\Users\\m.prytkova\\Desktop\\links.txt");

        open(LoginPageUnlogged.class)
                .authorizeBy(name, "test");
        if (design.equals("old")) {
            oldDesign();
        }
        for (int i = 0; i < pages.size(); i++) {

            this.openUrl(pages.get(i));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }

            List<WebElement> links = this.getCurrentBrowser().getDriver().findElements(By.tagName("a"));
            ArrayList<String> errorLinks = new ArrayList();

            for (int j = 0; j < links.size(); j++) {
                try {
                    if (links.get(j).getAttribute("href").toLowerCase().contains("dmca")) {
                        errorLinks.add(links.get(j).getAttribute("href"));
                    }

                } catch (Exception ex) {
                }
            }

            if (errorLinks.size() > 0) {
                addTable().pageOpen(pages.get(i))
                        .importantErrors(errorLinks)
                        .otherErrors(null)
                        .finish();
            }

        }

    }

    private ArrayList<String> scanerUrl(String text) {

        ArrayList<String> pages = new ArrayList<String>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(text));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            pages.add(line);
        }
        return pages;
    }

    private void oldDesign() {
        this.openUrl("http://www.lj-09.local.bulyon.com/manage/settings/?cat=display");
        this.startScript("jQuery('.display_option.last input').click()");
        this.startScript("jQuery('#settings_save button').click()");
    }

}
