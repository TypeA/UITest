/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
public class ShopLogged extends ShopMenuItem
{
    @FindBy(css=".s-nav-item-paid-history")
    public Link orderHistory;
}
