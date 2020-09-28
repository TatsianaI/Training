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

    private static final String NAME_BUTTON_FOR_SENDING_MAIL = "Отправить";
    private static final SelenideElement btnWriteLetter = $(".b-toolbar__item");
    private static final SelenideElement inputTo =  $(by("data-original-name","To"));
    private static final SelenideElement inputSubject = $(By.name("Subject"));
    private static final SelenideElement btnForSendLetter = $(byText(NAME_BUTTON_FOR_SENDING_MAIL));
    private static final SelenideElement msgSentTitle = $(".message-sent__title");

    @Test
    public void createNewEmail() {
        btnWriteLetter.shouldHave(text("Написать письмо")).click();
        inputTo.val("small.crazy.squirrel@gmail.com");
        inputSubject.val("Test").pressTab();

        WebDriverRunner.getWebDriver().switchTo().frame(0);
        $(By.id("tinymce")).setValue("text of the email to be sent");
        WebDriverRunner.getWebDriver().switchTo().defaultContent();
        btnForSendLetter.click();
        String confirmation = msgSentTitle.text();
        Assert.assertEquals("Ваше письмо отправлено. Перейти во Входящие", confirmation);
    }

}
