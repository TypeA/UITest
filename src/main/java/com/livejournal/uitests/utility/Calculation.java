
package com.livejournal.uitests.utility;

import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;


public class Calculation {
    public String createUrlToPost(String user, String ditemid) {
        return "http://"+user + "." +
                Injectors.getInjector().getInstance(EnvironmentVariables.class).copy().getProperty("webdriver.base.url") +
                "/" + ditemid + ".html";
    }
    
}
