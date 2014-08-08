/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.utility.iterations;

import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
import net.thucydides.core.annotations.Step;

/**
 *
 * @author m.prytkova
 */
public class IterationsWithLoginForm extends IterationsWithObject {

    private final String name;
    private final String password;

    public IterationsWithLoginForm(Object object, int counter, String name, String password) {
        super(object, counter);
        this.name = name;
        this.password = password;
    }

    @Override
    protected void toRun() {
        ((LoginPage) object).getLoginForm().authorizeBy(name, password);
    }
}
