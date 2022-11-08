package org.training.collectionsExample.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class DifferentWaysOfReadingDataFromList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < 95000; i++) {
            arrayList.add(i);
        }
        arrayList.contains(141);

        //Using for each loop
        /*for (int i:arrayList) {
            System.out.println(i);
        }*/
        //Using for loop
        /*for(int i=0;i<arrayList.size();i++) {
            System.out.println(arrayList.get(i));
        }*/
        //using iterator
        /*Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
        //Using list iterator
        /*ListIterator<Integer> integerListIterator = arrayList.listIterator();
        while (integerListIterator.hasNext()) {
            System.out.println(integerListIterator.next());
        }
        while (integerListIterator.hasPrevious()) {
            System.out.println(integerListIterator.previous());
        }*/
        //Using lambda expression
        arrayList.stream().forEach(e-> System.out.println(e));
    }
}
