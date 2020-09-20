package com.collection.task2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataReader {

//    private final static String baseFile = "names.json";

//    public static void toJSON(Data data) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(new File(baseFile), data);
//        System.out.println("json created!");
//    }

    public static Data toJavaObject(String baseFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Data.class);
    }
}
