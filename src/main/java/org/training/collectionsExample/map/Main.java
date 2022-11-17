package org.training.collectionsExample.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("firstName", "keerthana");
        hashMap.put("address", "hyd");
        hashMap.put("country", "india");
        System.out.println(hashMap.get("address"));

        Map<String, Integer> marks = new HashMap<>();
        marks.put("Maths", 89);
        marks.put("science", 78);
        System.out.println(marks.get("science"));

        marks.put("Maths", 45);
        marks.putIfAbsent("Maths", 85);

        System.out.println(marks.get("Maths"));
        marks.remove("science");
        System.out.println(marks.containsKey("science"));
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry e : entries) {
            System.out.println(e.getKey() + "::" + e.getValue());
        }
        Set<String> strings = hashMap.keySet();
        for (String key : strings) {
            System.out.println("Value of key :: " + key + " is " + hashMap.get(key));
        }

    }
}
