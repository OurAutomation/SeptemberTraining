package org.training.collectionsExample.map;

import java.util.*;

public class HowToIterateFromAMap {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
//        Map<String, String> personalData = new HashMap<>();// Doesn't follow any order
        Map<String, String> personalData = new LinkedHashMap<>();// follows Insertion order
        personalData.put("firstname", "Bharghav");
        personalData.put("lastname", "Sravan");
        personalData.put("location", "hyderabad");
        personalData.put("location", "bangalore");//it will override the value
        personalData.putIfAbsent("location", "Mumbai");//it will not override the value
        //This is using key set and for each loop
        Set<String> keySet = personalData.keySet();
        for (String key : keySet) {
            System.out.println("Key :: " + key + ", Value :: " + personalData.get(key));
        }
        //This is using entry set
        Set<Map.Entry<String, String>> entries = personalData.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("Key :: " + entry.getKey() + ", Value :: " + entry.getValue());
        }
        //Using lambda expression
        personalData.entrySet().stream().forEach(e-> System.out.println("Key :: " + e.getKey() + ", Value :: " + e.getValue()));
    }
}
