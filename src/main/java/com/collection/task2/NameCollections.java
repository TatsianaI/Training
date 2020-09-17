package com.collection.task2;

import org.ajbrown.namemachine.NameGenerator;

import org.ajbrown.namemachine.Name;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class NameCollections {

    public Set<String> collectionNames1;
    public Set<String> collectionNames2;

    public NameCollections(Set<String> collectionNames1, Set<String> collectionNames2) {
        this.collectionNames1 = collectionNames1;
        this.collectionNames2 = collectionNames2;
        System.out.println("First collection: " + this.collectionNames1);
        System.out.println("-----------------------------");
        System.out.println("Second collection: " + this.collectionNames2);
        System.out.println("-----------------------------");
    }

    public NameCollections() {
        this(10);
    }

    public NameCollections(int a) {
        collectionNames1 = generateSetName(a);
        collectionNames2 = generateSetName(a);
        System.out.println("First collection: " + collectionNames1);
        System.out.println("-----------------------------");
        System.out.println("Second collection: " + collectionNames2);
        System.out.println("-----------------------------");
    }



    private Set<String> generateSetName(int a) {
        NameGenerator generator = new NameGenerator();
        List<Name> names = generator.generateNames(a);
        Set<String> nameSet = new HashSet<String>();
        for (Name name : names) {
            nameSet.add(name.getFirstName());
        }
        return nameSet;
    }

    public Collection<String> symmetricDifference() {
        return  CollectionUtils.disjunction(collectionNames1, collectionNames2);
    }

    public Collection<String> intersection() {
        return  CollectionUtils.intersection(collectionNames1, collectionNames2);
    }

    public Collection<String> subtract() {
        return  CollectionUtils.subtract(collectionNames1, collectionNames2);
    }

    public Collection<String> union() {
        return  CollectionUtils.union(collectionNames1, collectionNames2);
    }

    public Collection<String> union2() {
        Set<String> setUnion = new HashSet<String>(collectionNames1);
        setUnion.addAll(collectionNames2);
        return setUnion;
    }

}
