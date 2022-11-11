package org.training.collectionsExample.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Linkedlist {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(12345);
//        list.add(10,1233);
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(123);
        list.set(3, 45456);
        list.remove(2);
        List<Integer> subList = new LinkedList<>();
        subList.add(45456);
        subList.add(123);
        subList.add(198);
        list.addAll(subList);
//        list.removeAll(subList);
        List<Integer> integers = list.subList(3, 6);
        for (int j : integers) {
            System.out.println(j);
        }
    }
}
