package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Select;

@Block(
        @FindBy(css = ".p-openpopup"))
public class BubblesUpdateBml extends UIBlock {

    @StepGroup
    public ColorBubble openColorBubble() {
        return new ColorBubble();
    }

    @StepGroup
    public LinkBubble openLinkBubble() {
        return new LinkBubble();
    }

    @StepGroup
    public LJUserBubble openLJUserBubble() {
        return new LJUserBubble();
    }

    @StepGroup
    public LJCutBubble openLJCutBubble() {
        return new LJCutBubble();
    }

    @StepGroup
    public SpolierBubble openSpoilerBubble() {
        return new SpolierBubble();
    }

    @StepGroup
    public FontBubble openFontBubble() {
        return new FontBubble();
    }

    @StepGroup
    public PhotoBubble openPhotoBubble() {
        return new PhotoBubble();
    }

    @FindBy(css = ".b-colorpicker-controls-hex")
    private TextField codeColor;

    @FindBy(css = "button.b-flatbutton[ng-click='submitColor()']")
    private Button chooseColorButton;

    @Block(
            @FindBy(css = ".b-bubble-color"))
    public class ColorBubble extends UIBlock {

        public void setTextColor(String color) {
            codeColor.enter(color);
            chooseColorButton.click();
        }
    }

    @FindBy(css = ".b-updateform-bubble-input")
    private TextField inputUrl;

    @FindBy(css = ".b-updateform-bubble-checkbox")
    private Button checkboxNewWindow;

    @FindBy(xpath = "//button[@class='b-flatbutton b-flatbutton-simple  ng-binding' and @lj-disabled[contains(.,'link')]]")
    private Button addButtonLink;

    @Block(
            @FindBy(css = ".b-bubble-link"))
    public class LinkBubble extends UIBlock {

        @StepGroup
        public void addLink(String url, Boolean newWindow) {
            inputUrl.enter(url);
            if (newWindow) {
                checkboxNewWindow.click();
            }
            addButtonLink.click();
        }
    }

    @FindBy(css = ".b-updateform-bubble-input-wrapper.b-updateform-bubble-input-username input")
    private TextField username;

    @FindBy(css = ".b-bubble-cut .b-updateform-bubble-input")
    private TextField ljcutText;

    @FindBy(css = ".b-bubble-spoiler .b-updateform-bubble-input")
    private TextField spoilerText;

    @Block(
            @FindBy(css = ".b-bubble-user"))
    public class LJUserBubble extends UIBlock {

        @StepGroup
        public void enterUsername(String ljuser, Boolean isCorrectUser) {
            username.enter(ljuser);
            startScript("jQuery('.b-updateform-bubble-user-button .b-flatbutton-simple').click()");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(BubblesUpdateBml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @StepGroup
        public void enterUsernameUsingAutocomplete(String ljuser) {
            String ljuserCutted = ljuser.substring(0, 3);
            username.enter(ljuserCutted);
            boolean flag = true;
            int i = 0;
            while (flag) {
                if (i < 10) {
                    username.sendKeys(Keys.ARROW_DOWN);
                    i++;
                    if (startScript("return jQuery('.ui-autocomplete .ui-state-hover').text()").equals(ljuser)) {
                        username.sendKeys(Keys.ENTER);
                        flag = false;
                    }
                } else {
                    ljuserCutted = ljuser.substring(0, ljuserCutted.length() + 1);
                    username.enter(ljuserCutted);
                    i = 0;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BubblesUpdateBml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Block(
            @FindBy(css = ".b-bubble-cut"))
    public class LJCutBubble extends UIBlock {

        public void useLJCut(String ljcut) {
            if (ljcut.toUpperCase().equals("DEFAULT")) {
                startScript("jQuery('.b-bubble-cut .b-flatbutton').click()");
            } else {
                ljcutText.enter(ljcut);
                startScript("jQuery('.b-bubble-cut .b-flatbutton').click()");
            }
        }

    }

    @Block(
            @FindBy(css = ".b-bubble-spoiler"))
    public class SpolierBubble extends UIBlock {

        public void useSpoiler(String spoiler) {
            if (spoiler.toUpperCase().equals("DEFAULT")) {
                startScript("jQuery('.b-bubble-spoiler .b-flatbutton').click()");
            } else {
                spoilerText.enter(spoiler);
                startScript("jQuery('.b-bubble-spoiler .b-flatbutton').click()");
            }
        }

    }

    @FindBy(css = ".b-fontsize-select-item-tiny")
    private Button tinyFontText;

    @FindBy(css = ".b-fontsize-select-item-small")
    private Button smallFontText;

    @FindBy(css = ".b-fontsize-select-item-normal")
    private Button normalFontText;

    @FindBy(css = ".b-fontsize-select-item-large")
    private Button largeFontText;

    @FindBy(css = ".b-fontsize-select-item-huge")
    private Button hugeFontText;

    @Block(
            @FindBy(css = ".b-bubble-font"))
    public class FontBubble extends UIBlock {

        public void setTextFont(String font_text) {
            switch (font_text) {
                case "TINY":
                    tinyFontText.click();
                    break;
                case "SMALL":
                    smallFontText.click();
                    break;
                case "NORMAL":
                    normalFontText.click();
                    break;
                case "LARGE":
                    largeFontText.click();
                    break;
                case "HUGE":
                    hugeFontText.click();
                    break;
                default:
                    Assert.fail("Incorrect text font " + font_text);
            }
        }
    }

    //Buble photo
    @FindBy(css = ".upload__input")
    private TextField inputPhoto;

    @FindBy(xpath = "//select[@name='privacy' and @class='ng-pristine ng-valid']")
    private Select privacyPhoto;

    @FindBy(css = ".b-flatbutton.b-flatbutton-simple[lj-ml*='paste.insert']")
    private Button insertPhotoByUrlToPost;

    @FindBy(css = ".b-photouploader-byurl-src.ng-pristine.ng-valid[ng-model*='photo.paste.url']")
    private TextField inputPhotoUrl;

    @FindBy(css = ".b-photouploader-byurl-link.ng-pristine.ng-valid[ng-model*='photo.paste.link']")
    private TextField inputPhotoLink;

    @FindBy(css = ".b-photouploader-urlsettings-select.ng-pristine.ng-valid")
    private Select selectSizePhoto;

    @FindBy(css = ".b-menu-item-link[lj-ml='photouploader.paste.title']")
    private Button tabByUrl;

    @FindBy(css = ".b-menu-item-link[lj-ml='photouploader.album.title']")
    private Button tabFromAlbum;

    @FindBy(css = ".ng-pristine.ng-valid[id=albums]")
    private Select selectAlbum;

    @FindBy(css = ".b-flatbutton.b-flatbutton-simple[ng-click*='photo.albums.insert']")
    private Button insertFromAlbum;

    @FindBy(css = ".b-photouploader-albumsettings-check.ng-pristine.ng-valid[id='linktooriginal']")
    private Button checkbocLinkToOriginal;

    @FindBy(css = ".b-photouploader-albumsettings-select.ng-pristine.ng-valid[id='sizepictures']")
    private Select selectSizePhotoFromAlbum;

    @Block(
            @FindBy(css = ".b-bubble-photouploader"))
    public class PhotoBubble extends UIBlock {

        public void uploadPhoto(String adress) {
            String dir = System.getProperty("user.dir") + "\\src\\test\\resources\\fileToUpload\\9bcc135809b4.jpg";
            WebElement element = getDriver().findElement(By.xpath("//div[@class='moxie-shim moxie-shim-html5']"));
            element.sendKeys(dir);
        }

        public void uploadPhotoWithPrivacy(String adress, String privacy) {
            uploadPhoto(adress);
            privacyPhoto.selectByVisibleText(privacy);
            enabledButtonAddPhotoToPost();
        }

        public void enabledButtonAddPhotoToPost() {
            startScript("return jQuery('button.b-flatbutton.b-flatbutton-simple[ng-click*=save]').prop('disabled',false)");
        }

        public void enterPhotoByUrl(String photoUrl, String link, String size) {
            tabByUrl.click();
            inputPhotoUrl.enter(photoUrl);;
            if (link.length() > 0) {
                inputPhotoLink.enter(link);
            }
            if (size.length() > 0) {
                selectSizePhoto.selectByVisibleText(size);
            }
            insertPhotoByUrlToPost.click();
        }

        public void enterPhotoFromAlbum(String album, String photo, String link, String size) {
            tabFromAlbum.click();
            selectAlbum.selectByVisibleText(album);
            /*
             Изначально всех фотографий нет в body.
             Так как они подгружаются по скролу, то мы с помошью скрипта иммитируем скролл внутри бабла, 
             до тех пор пока не появится нужная фотография
             */
            boolean elementIsPresent = false;
            while (!elementIsPresent) {
                startScript("var scrolling = document.getElementsByClassName('b-photouploader-albums-inner')[0];"
                        + "scrolling.scrollTop = scrolling.scrollHeight;\n");
                try {
                    Thread.sleep(2000);//к сожалению без него никак. скрипты выполняются довольно быстро. иначе будет много циклов. 
                } catch (InterruptedException ex) {
                    Logger.getLogger(BubblesUpdateBml.class.getName()).log(Level.SEVERE, null, ex);
                }
                elementIsPresent = Boolean.valueOf(startScript("var elementIsPresent  = jQuery(\".b-photouploader-pictures-img[ng-src*='" + photo + "']\").length>0;"
                        + "return elementIsPresent").toString());
            }

            WebElement element = getDriver().findElement(By.xpath("//span[@class='b-photouploader-pictures-pic']//img"
                    + "[@class='b-photouploader-pictures-img'"
                    + " and @src[contains(.,'" + photo + "')]]"));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
            if (Boolean.valueOf(link)) {
                checkbocLinkToOriginal.click();
            }
            if (size.length() > 0) {
                selectSizePhotoFromAlbum.selectByVisibleText(size);
            }
            insertFromAlbum.click();
        }
    }
}
