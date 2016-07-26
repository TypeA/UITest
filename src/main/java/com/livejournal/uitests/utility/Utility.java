package com.livejournal.uitests.utility;

import com.livejournal.uitests.console.SSHComands;

/**
 * @author m.prytkova
 */
public class Utility {

    public RandomObject random() {
        return new RandomObject();
    }

    public Convertation convertation() {
        return new Convertation();
    }

    public Verification verification() {
        return new Verification();
    }

    public SSHComands sshCommands() {
        return new SSHComands();
    }
    public Calculation calculation(){
        return new Calculation();
    }

}