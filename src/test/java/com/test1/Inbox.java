package com.test1;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Listeners(com.test1.CustomListener.class)
public class Inbox extends MailTestTask{

    private static final int MIN_EXPECTED_AMOUNT_OF_IN_EMAILS = 1800;
    private static final int EXPECTED_NUMBER_OF_WORLDS_IN_MAIL_COUNT_HINT = 5;
    private static final SelenideElement inboxLink = $(".b-nav__link");

    @Test
    public void showsNumberOfMessages(){
        inboxLink.shouldBe(visible);
        String inboxCountDetails = inboxLink.attr("title");
        int totalCountOfIncomingEmails = extractTotalCountOfIncomingEmails(inboxCountDetails);
        Assert.assertTrue(totalCountOfIncomingEmails >= MIN_EXPECTED_AMOUNT_OF_IN_EMAILS);
    }

    //inboxCountDetails="Всего 1871 письмо, 1523 непрочитанных"
    //return=1871
    private int extractTotalCountOfIncomingEmails(String inboxCountDetails) {
        String[] words = inboxCountDetails.split(" ");
        Assert.assertEquals(EXPECTED_NUMBER_OF_WORLDS_IN_MAIL_COUNT_HINT, words.length);
        return Integer.parseInt(words[1]);
    }
}
