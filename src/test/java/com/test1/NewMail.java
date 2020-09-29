package com.test1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.*;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

@Listeners(com.test1.CustomListener.class)
public class NewMail extends MailTestTask{

    private final String NAME_BUTTON_FOR_SENDING_MAIL = "Отправить";
//    private final SelenideElement btnWriteLetter = $(".b-toolbar__item");
//    private final SelenideElement inputTo =  $(by("data-original-name","To"));
//    private final SelenideElement inputSubject = $(By.name("Subject"));
//    private final SelenideElement btnForSendLetter = $(byText(NAME_BUTTON_FOR_SENDING_MAIL));
//    private final SelenideElement msgSentTitle = $(".message-sent__title");
//    private final SelenideElement iframeForMainText = $(By.id("tinymce"));

    @Test
    public void createNewEmail() {
        $(".b-toolbar__item").shouldHave(text("Написать письмо")).click();
        $(by("data-original-name","To")).val("small.crazy.squirrel@gmail.com");
        $(By.name("Subject")).val("Test").pressTab();

        WebDriverRunner.getWebDriver().switchTo().frame(0);
        $(By.id("tinymce")).setValue("text of the email to be sent");
        WebDriverRunner.getWebDriver().switchTo().defaultContent();
        $(byText(NAME_BUTTON_FOR_SENDING_MAIL)).click();
        String confirmation = $(".message-sent__title").text();
        Assert.assertEquals("Ваше письмо отправлено. Перейти во Входящие", confirmation);
    }

}
