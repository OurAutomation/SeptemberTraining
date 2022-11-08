package org.training.collectionsExample.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetImpl {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("123");
        linkedHashSet.add("456");
        linkedHashSet.add("234");
        linkedHashSet.add("909");
        linkedHashSet.add("564");
        for (String e : linkedHashSet) {
            System.out.println(e);
        }
    }
}
