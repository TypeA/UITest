package com.livejournal.uitests.databases_data;

import com.livejournal.uisteps.thucydides.Databases;

/**
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

    public Photo photo() {
        return new Photo();
    }

    public Video video() {
        return new Video();
    }

    public Profile profile() {
        return new Profile();
    }

    public Medius medius() {
        return new Medius();
    }

}
