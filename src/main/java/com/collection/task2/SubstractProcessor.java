package com.collection.task2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SubstractProcessor implements Processor {
    public Collection<String> process(Data data) {
        Set<String> symmetricDifference = new HashSet<String>(data.getNamesCollection1());

        for (String str : data.getNamesCollection2()) {
            if(symmetricDifference.contains(str)) {
                symmetricDifference.remove(str);
            }
        }

        return symmetricDifference;
    }

}
