package com.test1;

import com.codeborne.selenide.*;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public abstract class MailTestTask {

    public static final String URL = "https://mail.ru/";
    private static String Username = System.getProperty("username", "squirrel1989");
    private static String Password = System.getProperty("password", "Calipso");

    @BeforeClass
    public void openInbox(){

       Selenide.open(URL);
        login();
    }

   private void login(){

        $(By.name("login")).val(Username).pressEnter();
        $(By.name("password")).val(Password).pressEnter();

   }
}
