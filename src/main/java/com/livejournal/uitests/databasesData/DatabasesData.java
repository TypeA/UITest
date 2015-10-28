package com.livejournal.uitests.databasesData;

import com.livejournal.uisteps.thucydides.Databases;

/**
 *
 * @author m.prytkova
 */
public class DatabasesData extends Databases {

    public UserData userData() {
        return new UserData();
    }

    public UserSettings userSettings() {
        return new UserSettings();
    }

    public Friends friends() {
        return new Friends();
    }

    public BannedUser bannedUser() {
        return new BannedUser();
    }

    public Community community() {
        return new Community();
    }

    public Discovery discovery() {
        return new Discovery();
    }

    public Post posts() {
        return new Post();
    }

    public Privileges privileges() {
        return new Privileges();
    }

}
