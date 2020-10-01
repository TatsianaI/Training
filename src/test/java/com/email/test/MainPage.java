package com.email.test;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {


    private static final int EXPECTED_NUMBER_OF_WORLDS_IN_MAIL_COUNT_HINT = 5;
    private static final String BTN_WRITE_LETTER = ".compose-button";
    private static final String BTN_WRITE_LETTER_TEXT = "Написать письмо";

    public int getTotalCountOfIncomingEmails(){
        $(".nav__item").waitUntil(appear, 20000);
        String inboxCountDetails = $(".nav__item").attr("title");
        return extractTotalCountOfIncomingEmails(inboxCountDetails);
    //    Assert.assertTrue(totalCountOfIncomingEmails >= MIN_EXPECTED_AMOUNT_OF_IN_EMAILS);
    //    return this;
    }

    //inboxCountDetails="Всего 1871 письмо, 1523 непрочитанных"
    //return=1871
    private int extractTotalCountOfIncomingEmails(String inboxCountDetails) {
        String[] words = inboxCountDetails.split(" ");
        Assert.assertEquals(EXPECTED_NUMBER_OF_WORLDS_IN_MAIL_COUNT_HINT, words.length);
        return Integer.parseInt(words[1]);
    }


    public NewEmailFormPage openFormForCreatingNewEmail () {
        $(BTN_WRITE_LETTER).waitUntil(appear, 20000);
        $(BTN_WRITE_LETTER).shouldBe(visible);
        $(BTN_WRITE_LETTER).click();
        return new NewEmailFormPage();
    }
}
