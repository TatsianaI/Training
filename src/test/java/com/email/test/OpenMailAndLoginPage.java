package com.email.test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.WebDriverRunner.*;

public class OpenMailAndLoginPage {

    public static final String URL = "https://mail.ru/";
    private final String INPUT_LOGIN = "login";
    private final String INPUT_PASSWORD = "password";

    public OpenMailAndLoginPage() {
        Selenide.open(URL);
        if (!url().contains(URL)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
    }

    public MainPage login (String username, String password) {
        $(By.name(INPUT_LOGIN)).val(username).pressEnter();
        $(By.name(INPUT_PASSWORD)).val(password).pressEnter();
        return new MainPage();
    }

}
