/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import java.util.List;
import java.util.Map;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

/**
 *
 * @author m.prytkova
 */
public class RegistrationTest extends WebTest{
    
    @Given ("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form(){
        on(CreateAccountPage.class);
    }
    
    @When ("user enter correct data:")
    public void user_enter_correct_data (ExamplesTable activityTable){
        List<Map<String, String>> lmap = activityTable.getRows();
        
    }
    
}
