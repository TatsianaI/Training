package com.collection.task2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class IntersectionProcessor implements Processor {

    public Collection<String> process(Data data) {
        Set<String> intersection = new HashSet<String>();

        for (String coll1 : data.getNamesCollection1()) {
            if(data.getNamesCollection2().contains(coll1)) {
                intersection.add(coll1);
            }
        }

        return intersection;

    }
}
