package org.training.collectionsExample.set;

import java.util.*;

public class RemoveDuplicatesFromGivenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Numbers :: ");
        String str = scanner.nextLine();
        List<String> numbers = Arrays.asList(str.split(","));
        Set<String> numbersSet = new HashSet<>();
        numbersSet.addAll(numbers);
        /*for (String i:numbers) {
            numbersSet.add(i);
        }*/
        for (String i:numbersSet ) {
            System.out.print(i+",");
        }
    }
}
