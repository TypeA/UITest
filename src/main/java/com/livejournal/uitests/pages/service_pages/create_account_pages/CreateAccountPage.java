package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uitests.pages.service_pages.ServicePage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/create")
public class CreateAccountPage extends ServicePage {

    public CreateAccountForm createAccountForm;
    
    public FinishForm finishForm;

    @StepGroup
    public void createAccountData(String name, String email, String password, String day, String month, String year, String gender) {
        createAccountForm.createAccountData(name, email, password, day, month, year, gender);
    }

}
