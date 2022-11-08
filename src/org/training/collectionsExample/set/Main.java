package org.training.collectionsExample.set;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Date d = new Date();
        HashSet a = new HashSet();
        for (int i = 0; i < 95000; i++) {
            a.add(i);
        }
        Date afterDate = new Date();
        System.out.println("total time taken in milliseconds HashSet adding:: " +(afterDate.getTime()-d.getTime()));

        d = new Date();
        LinkedHashSet ab = new LinkedHashSet();
        for (int i = 0; i < 95000; i++) {
            ab.add(i);
        }
        afterDate = new Date();
        System.out.println("total time taken in milliseconds for linked hashset adding :: " +(afterDate.getTime()-d.getTime()));

        d = new Date();
        TreeSet abc = new TreeSet();
        for (int i = 0; i < 95000; i++) {
            abc.add(i);
        }
        afterDate = new Date();
        System.out.println("total time taken in milliseconds for Tree set adding :: " +(afterDate.getTime()-d.getTime()));
        d = new Date();
        a.stream().forEach(e-> {

        });
        afterDate = new Date();
        System.out.println("total time taken in milliseconds for hashset set reading :: " +(afterDate.getTime()-d.getTime()));

        d = new Date();
        ab.stream().forEach(e-> {

        });
        afterDate = new Date();
        System.out.println("total time taken in milliseconds for Linked hashset set reading :: " +(afterDate.getTime()-d.getTime()));

        d = new Date();
        abc.stream().forEach(e-> {

        });
        afterDate = new Date();
        System.out.println("total time taken in milliseconds for treeset set reading :: " +(afterDate.getTime()-d.getTime()));
    }
}
