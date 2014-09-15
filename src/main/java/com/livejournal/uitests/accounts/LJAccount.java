package com.livejournal.uitests.accounts;

/**
 *
 * @author ASolyankin
 */
public class LJAccount {

    private final JournalType journalType;
    private final String communityOwner;
    private final boolean cyrillic;
    private final boolean isPaid;
    private final String name;
    private final String password;
    private final Integer socCap;

    private LJAccount(JournalType journalType, String communityOwner, boolean cyrillic, boolean isPaid, String name, String password, Integer socCap) {
        this.journalType = journalType;
        this.communityOwner = communityOwner;
        this.cyrillic = cyrillic;
        this.isPaid = isPaid;
        this.name = name;
        this.password = password;
        this.socCap = socCap;
    }

    public static LJAccount createJournal(boolean cyrillic, boolean isPaid, String name, String password, Integer socCap) {
        return new LJAccount(JournalType.PERSONAL, "", cyrillic, isPaid, name, password, socCap);
    }

    public static LJAccount createCommunity(String communityOwner, boolean cyrillic, boolean isPaid, String name, Integer socCap) {
        return new LJAccount(JournalType.COMMUNITY, communityOwner, cyrillic, isPaid, name, "", socCap);
    }

    public JournalType getJournalType() {
        return journalType;
    }

    public String getCommunityOwner() {
        return communityOwner;
    }

    public boolean isCyrillic() {
        return cyrillic;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Integer getSocCap() {
        return socCap;
    }
    
    
}
