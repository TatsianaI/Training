package com.email.test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NewEmailFormPage {

    private final String NAME_BUTTON_FOR_SENDING_MAIL = "Отправить";
   // private final String INPUT_TO = "//div[@class='container--ItIg4 size_s--2eBQT size_s--3_M-_']//input[@class='container--H9L5q size_s--3_M-_']";
    private final String INPUT_TO = "div[class^='contactsContainer-']";
    private final String INPUT_SUBJECT = "Subject";
    private final String INPUT_MAIN_TEXT = "cke_editable";

    public EmailSendingResultPage  createAndSendNewEmail() {
        //     $("div[class^='contactsContainer-']").find("input").setValue("aaaa@sss.cc");
       // $(By.xpath(INPUT_TO)).val("small.crazy.squirrel@gmail.com");
        $(INPUT_TO).find("input").val("small.crazy.squirrel@gmail.com");
        $(By.name(INPUT_SUBJECT)).val("Test").pressTab();
        $(By.className(INPUT_MAIN_TEXT)).setValue("text of the email to be sent");
        $(byText(NAME_BUTTON_FOR_SENDING_MAIL)).click();
        return new EmailSendingResultPage();
    }

}
