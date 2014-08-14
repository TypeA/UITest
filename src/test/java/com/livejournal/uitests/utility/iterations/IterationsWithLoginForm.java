package com.livejournal.uitests.utility.iterations;

import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;

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
