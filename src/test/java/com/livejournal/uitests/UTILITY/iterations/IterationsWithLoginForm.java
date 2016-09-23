package com.livejournal.uitests.UTILITY.iterations;

import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;

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
        ((LoginPageUnlogged) object).loginForm.authorizeBy(name, password);
    }
}
