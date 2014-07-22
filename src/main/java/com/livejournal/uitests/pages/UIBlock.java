/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.pages;

import junit.framework.Assert;

/**
 *
 * @author m.prytkova
 */
public class UIBlock extends com.livejournal.uisteps.thucydides.elements.UIBlock {
    public <T extends Object> T elem(T element) {
        if (element == null) {
            Assert.fail("Cannot get element!");
        }
        return element;
    }
}
