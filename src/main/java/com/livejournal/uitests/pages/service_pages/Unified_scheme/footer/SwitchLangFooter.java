/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.Unified_scheme.footer;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".b-selectus"))
public class SwitchLangFooter extends UIBlock {

    @FindBy(css = ".button")
    public Link dropDownbutton;

    @FindBy(css = ".label")
    public Link langFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[1]")
    public Link enFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[2]")
    public Link enUKFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[3]")
    public Link deFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[4]")
    public Link daFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[5]")
    public Link esFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[6]")
    public Link frFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[7]")
    public Link itFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[8]")
    public Link ruFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[9]")
    public Link ukFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[10]")
    public Link blFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[11]")
    public Link jpFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[12]")
    public Link ptFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[13]")
    public Link esperantoFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[14]")
    public Link hebrewFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[15]")
    public Link neFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[16]")
    public Link maFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[17]")
    public Link geFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[18]")
    public Link isFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[19]")
    public Link suFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[20]")
    public Link grFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[21]")
    public Link noboFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[22]")
    public Link svFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[23]")
    public Link poFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[24]")
    public Link chsimpleFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[25]")
    public Link laFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[26]")
    public Link tuFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[27]")
    public Link malayFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[28]")
    public Link hiFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[29]")
    public Link portFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[30]")
    public Link chtraditionalFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[31]")
    public Link liFooter;

    @FindBy(xpath = ".//*[@class='b-selectus-items']//li[32]")
    public Link nonyFooter;

}
