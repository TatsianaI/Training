package com.email.test;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.*;
import com.codeborne.selenide.Selenide;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


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


    @Test(dataProvider ="emailProvider", dataProviderClass = EmailDataProvider.class)
    public void shouldSuccessfullySendEmail(String email) {
        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        boolean mailSent = new OpenMailAndLoginPage()
                .login(Username, Password)
                .openFormForCreatingNewEmail()
                .createAndSendNewEmail(email)
                .isMailSendingConfirmationShown();
        Assert.assertTrue(mailSent);
    }

    @AfterMethod
    public void afterTest() {
        System.out.println("===============================================");
        WebDriverRunner.closeWebDriver();
    }


}
