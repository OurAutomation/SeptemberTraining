package org.training.collectionsExample.map;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        Map<String, String> personalData = new HashMap<>();
        personalData.put("firstname", "Bharghav");
        personalData.put("lastname", "Sravan");
        personalData.put("location", "hyderabad");
        personalData.put("location", "bangalore");//it will override the value
        personalData.putIfAbsent("location", "Mumbai");//it will not override the value
//        personalData.clear(); // This will clear all the entries from the map
//        personalData.remove("location");//It will remove the entry from map
//       boolean isKeyPresent = personalData.containsKey("lastname");// To check if a key is available in the map
        String lastname = personalData.get("lastname");
        System.out.println(personalData.get("firstname"));
        System.out.println(personalData.get("location"));

        Map<String, Integer> marks = new HashMap<>();
        marks.put("science", 100);
        marks.put("maths", 90);
        marks.put("social", 45);
        marks.put("english", 75);
        Integer science = marks.get("science");
        System.out.println(marks.get("science"));
        System.out.println(marks.get("maths"));
    }
}
