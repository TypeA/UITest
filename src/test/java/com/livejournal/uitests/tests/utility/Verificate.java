/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.tests.utility;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

/**
 *
 * @author m.prytkova
 */
public class Verificate {

    @Step
    public void verifyText(String erorText, String textDate1, String textDate2) {
        Assert.assertTrue(erorText, textDate1.contains(textDate2));
    }

    @Step
    public void verifyStatus(String erorText, boolean status) {
        Assert.assertTrue(erorText, status);
    }

}
