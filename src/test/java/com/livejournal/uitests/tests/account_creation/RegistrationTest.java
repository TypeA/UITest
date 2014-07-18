package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.tests.utility.Date;
import com.livejournal.uitests.tests.utility.RandomName;
import com.livejournal.uitests.tests.utility.Verificate;
import java.util.Arrays;
import java.util.Collection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.jbehave.core.annotations.Pending;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author m.prytkova
 */
@RunWith(ThucydidesParameterizedRunner.class)
//@UseTestDataFrom(value = "C://Tests/UITests/src/test/java/com/livejournal/uitests/tests/account_creation/Registration.csv", separator = '|')
public class RegistrationTest extends WebTest {

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
            {"test1234rnd", "test@test.ru", "Test123", "1", "4", "1990", "M", "Добро пожаловать"},
            {"123test1234rnd", "test@test.ru", "Test123", "1", "4", "1990", "M", "Добро пожаловать"}
        });
    }


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

    public RegistrationTest(String name, String email, String password, String day, String month, String year, String gender, String message) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.gender = gender;
        this.message = message;
    }

    @Test
    public void registration() {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        on(CreateAccountPage.class).createAccountForm.createAccountButton.click();
       // String finishText = on(CreateAccountPage.class).finishForm.finishText.getText();
       // verify.verifyText("Incorrect text on Finish Registration Form!", finishText, message);

    }

}
