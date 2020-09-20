package com.collection.task2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class Data {

    @JsonProperty
    public Set<String> namesCollection1;

    @JsonProperty
    public Set<String> namesCollection2;

    public Data() {
    }

    public Data(Set<String> namesCollection1, Set<String> namesCollection2) {
        this.namesCollection1 = namesCollection1;
        this.namesCollection2 = namesCollection2;
    }

    public Set<String> getNamesCollection1() {
        return namesCollection1;
    }

    public void setNamesCollection1(Set<String> namesCollection1) {
        this.namesCollection1 = namesCollection1;
    }

    public Set<String> getNamesCollection2() {
        return namesCollection2;
    }

    public void setNamesCollection2(Set<String> namesCollection2) {
        this.namesCollection2 = namesCollection2;
    }
}
