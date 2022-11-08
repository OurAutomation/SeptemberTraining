package org.training.collectionsExample.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetImpl {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet();
        hashSet.add("123");
        hashSet.add("123");
        hashSet.add("123");
        hashSet.add("1425");
        hashSet.add("234");
        System.out.println("The size of the set is :: " + hashSet.size());
        for (String e : hashSet) {
            System.out.println(e);
        }

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        hashSet.stream().forEach(e-> System.out.println(e));
    }
}
