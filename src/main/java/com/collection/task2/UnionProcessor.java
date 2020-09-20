package com.collection.task2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UnionProcessor implements Processor {

    public Collection<String> process(Data data) {
        Set<String> setUnion = new HashSet<String>(data.getNamesCollection1());
        setUnion.addAll(data.getNamesCollection2());
        return setUnion;
    }
}
