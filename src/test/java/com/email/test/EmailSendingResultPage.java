package com.email.test;

import static com.codeborne.selenide.Selenide.$;


public class EmailSendingResultPage {

    private final String MSG_SENT_TITLE = ".layer__link";
    private final String CONFIRMATION_TEXT = "Письмо отправлено";

    public EmailSendingResultPage() {

    }

    public boolean isMailSendingConfirmationShown() {
        String confirmation = $(MSG_SENT_TITLE).text();
        return CONFIRMATION_TEXT.equals(confirmation);
    }

}
