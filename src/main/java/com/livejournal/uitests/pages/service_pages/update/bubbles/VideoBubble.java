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

@Block(
        @FindBy(css = ".b-bubble-video"))
public class VideoBubble extends UIBlock {

    @FindBy(css = "li a[lj-ml='videouploader.embed.title']")
    private Button tabFromUrl;

    @FindBy(id = "updateform-video-url")
    private TextField enterVideoUrl;

    @FindBy(css = ".b-flatbutton.b-flatbutton-simple[lj-ml='talk.video.insert']")
    private Button insertVideoByUrl;

    @FindBy(css = ".b-menu-item-link[lj-ml='videouploader.album.title']")
    private Button tabFromAlbum;

    @FindBy(xpath = "//select[@ng-model='video.albums.current']")
    private Select selectVideoAlbum;

    @FindBy(css = ".b-flatbutton.b-flatbutton-simple[lj-ml='videouploader.album.insert']")
    private Button insertVideoFromAlbum;

    public void enterVideoByUrl(String video) {
        tabFromUrl.click();
        enterVideoUrl.sendKeys(video);
        insertVideoByUrl.click();
    }

    public void enterVideoFromAlbum(String album, String video) {
        tabFromAlbum.click();
        selectVideoAlbum.selectByVisibleText(album);
        boolean videoIsPresent = false;
        while (!videoIsPresent) {
            startScript("function getElementByXpath(path) {\n"
                    + "  return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\n"
                    + "};"
                    + "var scrolling=getElementByXpath(\"//div[@ng-include[contains(.,'video')]]//div[@class='b-photouploader-albums-inner']\");"
                    + "scrolling.scrollTop = scrolling.scrollHeight;");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(VideoBubble.class.getName()).log(Level.SEVERE, null, ex);
            }
            videoIsPresent = Boolean.valueOf(startScript("return jQuery(\".b-photouploader-pictures-title.ng-binding[ng-show='record.name']:contains('" + video + "')\").length>0;").toString());
        }
        WebElement element = getDriver().findElement(By.xpath("//li[@ng-repeat='record in video.records.all']//strong[text()='" + video + "']"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        insertVideoFromAlbum.click();
    }
}
