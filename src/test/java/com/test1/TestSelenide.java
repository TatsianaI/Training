package com.test1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Listeners(com.test1.CustomListener.class)
public class TestSelenide {

    @Test
    public void findCoffee() {

        open("https://e-dostavka.by");
        $(By.xpath("//div[@class='main_menu__inner']//i[@class='fa fa-search']")).click();
        $(By.xpath("//input[@id='searchtext']")).val("Кофе натуральный молотый «Barista Mio» 100% арабика, 250");
        $(By.xpath("//div[@class='products_card products_card_739099 trademark_6205']//div[@class='title']")).click();
        $(By.xpath("//div[@class='products_card']//h2")).shouldHave(text("«Barista Mio» 100%"));

    }
}

  //  $$(".products_block__wrapper products_3_columns div").findBy(text("trademark_6205")).$(By.xpath("//div[@class='title']")).click();