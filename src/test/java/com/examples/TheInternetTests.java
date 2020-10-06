package com.examples;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.files.FileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TheInternetTests {

    //public SelenideElement DISAPPEARING_GALERY = $(by("href","/gallery/"));
    public String URL_DISAPPEAR = "https://the-internet.herokuapp.com/disappearing_elements";
    public String URL_DOWNLOAD = "https://the-internet.herokuapp.com/download";
    public String URL_HOVER = "https://the-internet.herokuapp.com/hovers";
    public String URL_FRAME = "https://the-internet.herokuapp.com/frames";
    public String URL_UPLOADER = "https://the-internet.herokuapp.com/upload";
    public SelenideElement DISAPPEARING_GALERY = $$(".example>ul>li>a").get(4);
    public SelenideElement DOWNLOAD_LINK = $$(".example>a").get(0);
    public String DISAPPEARING_TEXT = "Gallery";
    public SelenideElement UPLOADED_FILE_ID = $("#uploaded-files");

    @Test
    public void disappearingElements() {

        open(URL_DISAPPEAR);
        WebDriverRunner.getWebDriver().navigate().refresh();
        try {
            if(DISAPPEARING_GALERY.is(Condition.visible)) {
                Assert.assertEquals(DISAPPEARING_GALERY.text(),DISAPPEARING_TEXT);
            } else {
                WebDriverRunner.getWebDriver().navigate().refresh();
                if (DISAPPEARING_GALERY.is(Condition.visible)) {
                    Assert.assertEquals(DISAPPEARING_GALERY.text(),DISAPPEARING_TEXT);
                }
            }
        } catch (NoSuchElementException ne) {
            throw new RuntimeException("Web element with text 'Gallery' not visible");
        }
    }


    @Test
    public void downloadFile() {
        open(URL_DOWNLOAD);
        try {
            String file = DOWNLOAD_LINK.download().toString();
               Assert.assertTrue(file.contains(DOWNLOAD_LINK.text()));
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void hoversElement() {
        open(URL_HOVER);
        $$(".example>div").get(0).hover();
        WebElement divElement = WebDriverRunner.getWebDriver().findElement(By.className("figcaption"));
        String str = divElement.getText();
        Assert.assertTrue(str.contains("user1"));
    }

    @Test
    public void frames() {
        open(URL_FRAME);
        WebDriverRunner.getWebDriver().findElement(By.xpath("//a[contains(text(),'iFrame')]")).click();
        WebElement frameElement = WebDriverRunner.getWebDriver().findElement(By.id("mce_0_ifr"));
        WebDriverRunner.getWebDriver().switchTo().frame(frameElement);
        $(By.id("tinymce")).setValue("Text for test!!!");
        String textInsideFrame = $$("#tinymce>p").get(0).text();
        Assert.assertTrue(textInsideFrame.contains("Text for test!!!"));
    }


    @Test
    public void uploadFile() {
        open(URL_UPLOADER);
        $("#file-upload").sendKeys("D:\\uploadTest.jpg");
        $("#file-submit").click();
        Assert.assertTrue(UPLOADED_FILE_ID.is(Condition.visible));
        Assert.assertTrue(UPLOADED_FILE_ID.text().contains("uploadTest"));
        WebDriverRunner.getWebDriver().navigate().back();
        File file = new File("D:\\uploadTest.jpg");
        //WebElement element = WebDriverRunner.getWebDriver().findElement(By.xpath("//div[@id='drag-drop-upload']")).click();
        WebDriverRunner.getWebDriver().findElement(By.xpath("//div[@id='drag-drop-upload']")).click();
        //JavascriptExecutor executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
       // WebDriverRunner.getWebDriver().switchTo()
        // WebElement input =  (WebElement)jse.executeScript
       // SelenideElement element = $("#drag-drop-upload");
       // JavascriptExecutor executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
      //  executor.executeScript("str", element);
        // Selenide.executeJavaScript("");
       // actions().moveToElement(element).click(element).perform();
      //  Actions actions = new Actions(WebDriverRunner.getWebDriver());
     //   actions.dragAndDropBy(element, 1, 2).perform();
//        actions.moveToElement(element);
//        actions.click();
//        actions.build().perform();
       //executeJavaScript(str);
        System.out.println("dfg");
    }
}

//    $('div#drag-drop-upload').dropzone({
//        url: '/upload',
//        previewTemplate: $('#preview-template').html()
//        });