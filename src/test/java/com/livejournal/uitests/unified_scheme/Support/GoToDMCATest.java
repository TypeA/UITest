
package com.livejournal.uitests.unified_scheme.Support;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.Unified_scheme.header.FullscreenHeader;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageForUnsignedInUser;
import com.livejournal.uitests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author s.savinykh
 */
public class GoToDMCATest extends WebTest
{
        @Steps
        Verificate verify;
        
        @When("user on Main page moves cursor on Help menu item and user clicks on DMCA in dropdown menu")
        public void user_on_main_page_move_cursor_on_help_menu_item_and_click_dmca()
        {
           // on(MainPageUnlogged.class).getFullscreenHeader().getHelpMenuItem().getHelpBigLink().moveMouseOver();
           // on(MainPageUnlogged.class).getFullscreenHeader().getHelpMenuItem().dmca.click();
        }
        
        @Then("user should be on DMCA page")
        public void user_should_be_on_DMCA_page()
        {
         /*   verifyExpectedResult("Menu is opened", true).showMessageIfVerificationFailed("Menu is not opened");
            this.verify()
                    .expectedResult(DEFAULT_STORY_NAME, true).showMessageIfVerificationFailed(DEFAULT_STORY_NAME)
                    .and()
                    .expectedResult(DEFAULT_STORY_NAME, true).showMessageIfVerificationFailed(DEFAULT_STORY_NAME)
                    .finish();
            String dmcaURL = "/legal/dmca.bml";
            String currentURL = this.getCurrentBrowser().getDriver().getCurrentUrl();
            verify.verifyText("Incorrect URL!", currentURL, dmcaURL);*/
        }
    
}
