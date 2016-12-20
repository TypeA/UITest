package com.livejournal.uitests.DB;

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

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {
        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");

        ArrayList<String> pages = scanerUrl("C:\\Users\\m.prytkova\\Desktop\\links.txt");

        open(LoginPageUnlogged.class)
                .authorizeBy("maxapryg", "Mary1992");
        this.openUrl("http://www.livejournal.com/betatest");
        this.startScript("jQuery('.b-betapage-item .b-betapage-server.b-betapage-serv-omega')[0].click();");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < pages.size(); i++) {

            this.openUrl(pages.get(i));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<ArrayList<String>> loggs = getLoggs();
            addTable().pageOpen(pages.get(i))
                    .importantErrors(loggs.get(0))
                    .otherErrors(null)
                    .finish();

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
}
