package com.email.test;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.codeborne.selenide.Selenide;


@Listeners(com.test1.CustomListener.class)
public class MailTest {

    private static String Username = System.getProperty("username", "squirrel1989");
    private static String Password = System.getProperty("password", "Calipso");
    private static final int MIN_EXPECTED_AMOUNT_OF_IN_EMAILS = 1800;



    @Test
    public void shouldVerifyNumberOfIncomingEmails() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        int actual = new OpenMailAndLoginPage()
                .login(Username, Password)
                .getTotalCountOfIncomingEmails();
        Assert.assertTrue( actual >= MIN_EXPECTED_AMOUNT_OF_IN_EMAILS );
    }

    @Test
    public void shouldSuccessfullySendEmail() {
        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        boolean mailSent = new OpenMailAndLoginPage()
                .login(Username, Password)
                .openFormForCreatingNewEmail()
                .createAndSendNewEmail()
                .isMailSendingConfirmationShown();
        Assert.assertTrue(mailSent);
    }

    @AfterMethod
    public void afterTest() {
        System.out.println("===============================================");
        WebDriverRunner.closeWebDriver();
    }
}
