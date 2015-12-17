package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-bubble-photouploader"))
public class PhotoBubble extends UIBlock {

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
                Thread.sleep(5000);//к сожалению без него никак. скрипты выполняются довольно быстро. иначе будет много циклов. 
            } catch (InterruptedException ex) {
                Logger.getLogger(PhotoBubble.class.getName()).log(Level.SEVERE, null, ex);
            }
            elementIsPresent = Boolean.valueOf(startScript("var elementIsPresent  = jQuery(\".b-photouploader-pictures-img[ng-src*='" + photo + "']\").length>0;"
                    + "return elementIsPresent").toString());
        }

        WebElement element = getDriver().findElement(By.xpath("//span[@class='b-photouploader-pictures-pic']//img"
                + "[@class='b-photouploader-pictures-img'"
                + " and @src[contains(.,'" + photo + "')]]"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        startScript("jQuery(\".b-photouploader-pictures-pic img.b-photouploader-pictures-img[src*='"+photo+"']\").click()");
        if (Boolean.valueOf(link)) {
            checkbocLinkToOriginal.click();
        }
        if (size.length() > 0) {
            selectSizePhotoFromAlbum.selectByVisibleText(size);
        }
        insertFromAlbum.click();
            }
  
    }
