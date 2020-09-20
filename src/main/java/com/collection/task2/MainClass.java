package com.collection.task2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class MainClass {

    public static void main(String[] args) throws IOException {
//        NameCollections result = new NameCollections(
//                new HashSet<String>(Arrays.asList(
//                        "Vasia","Kolia","Petr"
//                )),
//                new HashSet<String>(Arrays.asList(
//                        "Masha","Ivan","Petr"
//                )));
////        NameCollections result = new NameCollections();
////        NameCollections result = new NameCollections(20);
//
//        System.out.println("Symmetric Difference: " + result.symmetricDifference());
//        System.out.println("Intersection: " + result.intersection());
//        System.out.println("Subtract: " + result.subtract());
//        System.out.println("Union: " + result.union());
//        System.out.println("Union2: " + result.union2());



        String path = "src/main/resources/names.json";
        Data d = DataReader.toJavaObject(path);
        Processor unionProcessor = new UnionProcessor();
        Processor intersectionProcessor = new IntersectionProcessor();
        Processor symmetricDifferenceProcessor = new SymmetricDifferenceProcessor();
        Processor substractProcessor = new SubstractProcessor();

        List<Processor> listProcessor = Arrays.asList(unionProcessor,intersectionProcessor,symmetricDifferenceProcessor,substractProcessor);

        for (Processor p : listProcessor) {
            Collection<String> result = p.process(d);
            System.out.println(result);
        }

        RestAssuredExample ra = new RestAssuredExample();
        ra.restAssuredMainProcess();

    }
}
