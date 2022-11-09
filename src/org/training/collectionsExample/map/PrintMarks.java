package org.training.collectionsExample.map;

import java.util.*;

public class PrintMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the marks comma separated :: ");
        String[] str = scanner.nextLine().split(",");
        Map<String, Integer> marks = new LinkedHashMap<>();
        marks.put("Science",Integer.parseInt(str[0]));
        marks.put("Maths",Integer.parseInt(str[1]));
        marks.put("Social",Integer.parseInt(str[2]));
        marks.put("English",Integer.parseInt(str[3]));
        Set<String> keySet = marks.keySet();
        float total=0;
        for (String subject:keySet ) {
            int marksInSubject = marks.get(subject);
            total += marksInSubject;
            System.out.println(subject + " :: "+ marksInSubject);
        }
        System.out.println("Total :: " + total);
        float percentage = (total/400)*100;
        System.out.println("Percentage :: " + percentage);
    }
}
