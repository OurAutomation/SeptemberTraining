package org.training.collectionsExample.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        Date d = new Date();
        ArrayList a = new ArrayList();
        for (int i = 0; i < 95000; i++) {
            a.add(i);
        }
        Date afterDate = new Date();
        System.out.println("total time taken in milliseconds arraylist adding:: " +(afterDate.getTime()-d.getTime()));

        d = new Date();
        LinkedList ab = new LinkedList();
        for (int i = 0; i < 95000; i++) {
            ab.add(i);
        }
        afterDate = new Date();
        System.out.println("total time taken in milliseconds for linked list adding :: " +(afterDate.getTime()-d.getTime()));

        d = new Date();
        double doubleValue=0;
        for (int i = 0; i < 95000; i++) {
             a.get(i);
        }
        afterDate = new Date();
        System.out.println("total time taken in milliseconds for array list reading :: " +(afterDate.getTime()-d.getTime()));

        d = new Date();
        doubleValue=0;
        for (int i = 0; i < 95000; i++) {
           ab.get(i);
        }
        afterDate = new Date();
        System.out.println("total time taken in milliseconds for Linked list reading :: " +(afterDate.getTime()-d.getTime()));
        ListIterator listIterator = a.listIterator();
        d = new Date();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.remove();
        }
        afterDate = new Date();
        System.out.println("total time taken in milliseconds for array list manipulation :: " +(afterDate.getTime()-d.getTime()));

        listIterator = ab.listIterator();
        d = new Date();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.remove();
        }
        afterDate = new Date();
        System.out.println("total time taken in milliseconds for Linked list manipulation :: " +(afterDate.getTime()-d.getTime()));
    }
}
