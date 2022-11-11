package org.training.collectionsExample.list;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListImpl {
    static ArrayList<String> stringArrayList = new ArrayList<>();
    static ArrayList<Integer> intArrayList = new ArrayList<>();
    static ArrayList<Object> objList = new ArrayList<>();
    static ArrayList<ArrayListImpl> classList = new ArrayList<>();
    static String[] sarr = new String[10];
    static Object[] objArr = new Object[10];

    public static void main(String[] args) {
        objArr[1]=1;
        objArr[0]= "Str";
        objArr[2]=new ArrayListImpl();
        classList.add(new ArrayListImpl());
        objList.add(1);
        objList.add("str");
        objList.add(1.01);
        for (Object o: objList
             ) {
            System.out.println(o);
        }
        sarr[0] = "10";
//        stringArrayList.add("10");
        sarr[1] = "11";
        sarr[2] = "15";
//        stringArrayList.add("11");
        for (int i = 0; i < 10; i++) {
            stringArrayList.add(i + "");
        }
//        objList.removeAll(stringArrayList);
      /*  stringArrayList.remove(2);
        stringArrayList.set(2,"15");
        for (int i=0;i<stringArrayList.size();i++){
            System.out.println(stringArrayList.get(i));
        }*/

        /*ListIterator<String> stringListIterator = stringArrayList.listIterator();
        while(stringListIterator.hasNext()) {
            System.out.println(stringListIterator.next());
        }*/

        /*Iterator<String> iterator = stringArrayList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        //lambda expressions
        Date presentDate = new Date();
        stringArrayList.parallelStream().forEach(e -> {
            System.out.println(e);
        });
        Date endDate = new Date();
        System.out.println(endDate.getTime() - presentDate.getTime() + " in millis for parallel stream");
        presentDate = new Date();
        stringArrayList.stream().forEach(e -> {
            System.out.println(e);
        });
        endDate = new Date();
        System.out.println(endDate.getTime() - presentDate.getTime() + " in millis for stream");
    }
}
