package com.collection.task2;

import java.util.Arrays;
import java.util.HashSet;

public class MainClass {

    public static void main(String[] args) {
        NameCollections result = new NameCollections(
                new HashSet<String>(Arrays.asList(
                        "Vasia","Kolia","Petr"
                )),
                new HashSet<String>(Arrays.asList(
                        "Masha","Ivan","Petr"
                )));
//        NameCollections result = new NameCollections();
//        NameCollections result = new NameCollections(20);

        System.out.println("Symmetric Difference: " + result.symmetricDifference());
        System.out.println("Intersection: " + result.intersection());
        System.out.println("Subtract: " + result.subtract());
        System.out.println("Union: " + result.union());
        System.out.println("Union2: " + result.union2());
    }
}
