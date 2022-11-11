package org.training.collectionsExample.list;

import java.util.LinkedList;

public class LinkedListImpl {
    static LinkedList<String> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        linkedList.add("abc");
        linkedList.add("dsfs");
        linkedList.add("dffd");
        linkedList.add("absdwdc");
        linkedList.add("abwdwdc");
        for (String str : linkedList) {
            System.out.println(str);
        }
    }
}
