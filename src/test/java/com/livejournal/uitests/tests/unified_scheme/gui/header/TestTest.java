/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.tests.unified_scheme.gui.header;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.tests.SimpleTest;

/**
 *
 * @author Asolyankin
 */
public class TestTest  extends SimpleTest {
    
    
    public TestTest() {
        
        BaseStepsListener stepsListener = new BaseStepsListener();
        ThucydidesUtils.registerListner(stepsListener);
        this.openBrowser();
    }
}
