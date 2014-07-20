package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.tests.utility.RandomName;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author m.prytkova
 */
//@RunWith(ThucydidesRunner.class)
public class IncorrectAge extends WebTest {

    private String name = "test1234rnd";
    private String email = "test@test.ru";
    private String password = "Test123";
    private String day = "1";
    private String month = "4";
    private String year = "2010";
    private String gender = "M";
    private String message = "Проверка возраста";

    @Steps
    Verificate verify;

    @Ignore @Test
    public void incorrect_age() {
        on(CreateAccountPage.class);
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                day,
                month,
                year,
                gender);
        on(CreateAccountPage.class).createAccountForm.createAccountButton.click();
        verify.verifyText("Incorrect text on Finish Registration Form!", on(CreateAccountPage.class).finishForm.finishText.getText(), message);
        on(CreateAccountPage.class).finishForm.createFirstPostButton.click();

    }
}
