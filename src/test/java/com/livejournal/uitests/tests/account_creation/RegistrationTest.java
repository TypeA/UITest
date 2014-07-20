package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.SimpleTest;
import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.tests.utility.Date;
import com.livejournal.uitests.tests.utility.RandomName;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author m.prytkova
 */
//@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("src/test/java/com/livejournal/uitests/tests/account_creation/data/Regisrtation.csv")
public class RegistrationTest extends SimpleTest {

    private String name;
    private String email;
    private String password;
    private String day;
    private String month;
    private String year;
    private String gender;
    private String message;

    @Steps
    Verificate verify;

    @Test
    public void registrationTest() {
        openBrowser();
        on(CreateAccountPage.class)
                .createAccountData(new RandomName(name).get(),
                        email,
                        password,
                        Date.parceDayOrGetCurrent(day).toString(),
                        Date.parceMonthOrGetCurrent(month).toString(),
                        Date.parceYearOrGetCurrent(year).toString(),
                        gender);
        on(CreateAccountPage.class).createAccountForm.createAccountButton.click();
        closeAllBrowsers();
   //     String finishText = on(CreateAccountPage.class).finishForm.finishText.getText();
   //     verify.verifyText("Incorrect text on Finish Registration Form!", finishText, message);

    }

}
