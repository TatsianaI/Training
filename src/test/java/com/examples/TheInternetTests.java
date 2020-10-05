package com.examples;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.files.FileFilter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TheInternetTests {

    //public SelenideElement DISAPPEARING_GALERY = $(by("href","/gallery/"));
    public SelenideElement DISAPPEARING_GALERY = $$(".example>ul>li>a").get(4);
    public SelenideElement DOWNLOAD_LINK = $$(".example>a").get(0);

    @Test
    public void disappearingElements() {

        open("https://the-internet.herokuapp.com/disappearing_elements");
        WebDriverRunner.getWebDriver().navigate().refresh();
        try {
            if(DISAPPEARING_GALERY.is(Condition.visible)) {
                Assert.assertEquals(DISAPPEARING_GALERY.text(),"Gallery");
            } else {
                WebDriverRunner.getWebDriver().navigate().refresh();
                if (DISAPPEARING_GALERY.is(Condition.visible)) {
                    Assert.assertEquals(DISAPPEARING_GALERY.text(),"Gallery");
                }
            }
        } catch (NoSuchElementException ne) {
            throw new RuntimeException("Web element with text 'Gallery' not visible");
        }
    }


    @Test
    public void downloadFile() {
        open("https://the-internet.herokuapp.com/download");
        try {
            String file = DOWNLOAD_LINK.download().toString();
               Assert.assertTrue(file.contains(DOWNLOAD_LINK.text()));
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
