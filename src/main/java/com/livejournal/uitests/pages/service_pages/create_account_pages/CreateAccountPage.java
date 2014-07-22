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

    private CreateAccountForm createAccountForm;
    private FinishForm finishForm;
   // private Popups popups;

    @StepGroup
    public void createAccountData(String name, String email, String password, String day, String month, String year, String gender) {
        getCreateAccountForm().createAccountData(name, email, password, day, month, year, gender);
    }

    public CreateAccountForm getCreateAccountForm() {
        return elem(createAccountForm);
    }

    public FinishForm getFinishForm() {
        return elem(finishForm);
    }

   // public Popups getPopups() {
   //     return (Popups) element(popups);
    //}

}
