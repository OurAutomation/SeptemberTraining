package org.training.collectionsExample.set;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetImpl {
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
        System.out.println("****************************************************");
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("123");
        treeSet.add("456");
        treeSet.add("234");
        treeSet.add("909");
        treeSet.add("564");
        for (String e : treeSet) {
            System.out.println(e);
        }
    }
}
