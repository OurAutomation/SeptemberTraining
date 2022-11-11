package org.training.collectionsExample.list;

import java.util.ArrayList;
import java.util.List;

public class Arraylist {
    public static void main(String[] args) {
        /*int[] iarr = new int[1];
        iarr[5]=10;*/
        List<Integer> list = new ArrayList<>();
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
        List<Integer> subList = new ArrayList<>();
        subList.add(45456);
        subList.add(123);
        subList.add(198);
        list.addAll(subList);
//        list.removeAll(subList);
        List<Integer> integers = list.subList(3, 6);
        for (int j : integers) {
            System.out.println(j);
        }
        /*for (int i : list) {
            System.out.println(i);
        }*/
    }
}
