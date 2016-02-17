package com.livejournal.uitests.pages.service_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import java.util.ArrayList;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("/manage/notes/")
public class ManageNote extends ServicePageLogged {

    @FindBy(css = ".manage-notes-add__name")
    private TextField inputUsername;

    @FindBy(css = ".manage-notes-add__note")
    private TextField inputNote;

    @FindBy(css = ".b-flatbutton[ng-disabled*=removeEnabled]")
    private Button deleteNote;

    public boolean noteIsDisplayed(String user, String note) {
        int countSize = getDriver().findElements(By.xpath("//ul[@class='b-pager-pages']//li")).size();
        int i = 1;
        boolean noteIsDisplay = getDriver().findElements(By.xpath("//div//span[@class[contains(.,'ljuser')] and @data-ljuser='"+user+"']//a/b[contains(text(),'" + user + "')]/following::span[contains(text(),'" + note + "')]")).size()>0;
        while (i < countSize&&!noteIsDisplay) {
            noteIsDisplay = getDriver().findElement(By.xpath("//div//span[@class[contains(.,'ljuser')] and @data-ljuser='"+user+"']//a/b[contains(text(),'" + user + "')]/following::span[contains(text(),'" + note + "')]")).isDisplayed();
        i++;
        }
        return noteIsDisplay;
    }

    public ManageNote selectNote(String user) {
        getDriver().findElement(By.xpath("//div/span/span[@data-ljuser='" + user + "']/parent::*/preceding-sibling::input")).click();
        return this;
    }

    public ManageNote addNote(String user, String note) {
        inputUsername.sendKeys(user);
        inputNote.sendKeys(note);
        return this;
    }

    public ArrayList<String> getAllUserNote() {
        int countSize = getDriver().findElements(By.xpath("//ul[@class='b-pager-pages']//li")).size();
        ArrayList<String> userNote = new ArrayList();
        int size = 0;
        for (int j = 1; j < countSize + 1; j++) {
            if (countSize > 1) {
                getDriver().findElement(By.xpath("//ul[@class='b-pager-pages']//li[" + j + "]/a")).click();
            }
            size = getDriver().findElements(By.xpath("//ul[@class='manage-notes__list']/li[@class='manage-notes__item note-item ng-scope']")).size();
            for (int i = 1; i < size + 1; i++) {
                userNote.add(getDriver().findElement(By.xpath("//ul[@class='manage-notes__list']/li[" + i + "]//span[@class[contains(.,'ljuser')]]")).getAttribute("data-ljuser"));

                System.out.println("!!!!!!!!!!!" + getDriver().findElement(By.xpath("//ul[@class='manage-notes__list']/li[" + i + "]//span[@class[contains(.,'ljuser')]]")));
            }
        }
        System.out.println("!!!!!!!!!!!" + userNote);
        return userNote;
    }
}
