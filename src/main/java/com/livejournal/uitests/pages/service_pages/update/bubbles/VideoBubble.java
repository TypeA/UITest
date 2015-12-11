package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;



@Block(
        @FindBy(css = ".b-bubble-video"))
public class VideoBubble extends UIBlock {

    @FindBy(css = "li a[lj-ml='videouploader.embed.title']")
    private Button tabFromUrl;
    
    @FindBy(id = "updateform-video-url")
    private TextField enterVideoUrl;  
    
    @FindBy(css = ".b-flatbutton.b-flatbutton-simple[lj-ml='talk.video.insert']")
    private Button insertVideoByUrl;
    
    @FindBy(css = ".b-menu-item-link[lj-ml='videouploader.album.title]'")
    private Button tabFromAlbum;
    
    public void enterVideoByUrl(String video) {
        tabFromUrl.click();
        enterVideoUrl.sendKeys(video);      
        insertVideoByUrl.click();
    }
    
    public void enterVideoFromAlbum(String album, String video){
    tabFromAlbum.click();
    
    }
}
