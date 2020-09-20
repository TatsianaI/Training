package com.collection.task2;

import java.util.Arrays;
import java.util.Comparator;

import static io.restassured.RestAssured.given;

public class RestAssuredExample {

    public void restAssuredMainProcess() {
        Currency[] currencies = given().baseUri("https://www.nbrb.by")
                .basePath("/api")
                .get("/exrates/rates?periodicity=0")
                .as(Currency[].class);
        Arrays.sort(currencies, new Comparator<Currency>() {
            public int compare(Currency c1, Currency c2) {
                Long var1 = c1.getCurId();
                Long var2 = c2.getCurId();
                if (var1 > var2) {
                    return -1;
                } else if (var1 == var2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        Arrays.asList(currencies).forEach(System.out::println);
    }

}
