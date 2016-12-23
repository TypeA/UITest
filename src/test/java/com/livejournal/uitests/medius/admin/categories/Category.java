package com.livejournal.uitests.medius.admin.categories;

/**
 * Created by d.maslovskaya on 23.12.2016.
 */
public class Category {
    private String name;
    private final String keyword;
    private String genitive;
    private final boolean stiker;
    private boolean active;

    public Category(String name, String keyword, String genitive, boolean isStiker) {
        this.name = name;
        this.keyword = keyword;
        this.genitive = genitive;
        this.stiker = isStiker;
        this.active = false;
    }

    public String getName() {
        return name;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getGenitive() {
        return genitive;
    }

    public boolean isStiker() {
        return stiker;
    }

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenitive(String genitive) {
        this.genitive = genitive;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Name: " + this.name
                + " Keyword: " + this.keyword
                + " Genetive: " + this.genitive
                + " Sticker: " + this.stiker
                + " Active: " + this.active;
    }


}
