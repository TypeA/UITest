package com.livejournal.uitests.service;

import com.livejournal.uitests.LJTest;
import org.jbehave.core.annotations.Given;

/**
 * Created by sergey.savinykh on 18.04.17.
 */
public class service extends LJTest {
    @Given("user updating machine")
    public void user_updating_machine() {
        console().collect_trunk();
        console().update_machine();
    }
}
