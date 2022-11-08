package org.training.collectionsExample.set;

import java.util.*;

public class RemoveDuplicatesFromGivenNumbersAndIterateInDescendingOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Numbers :: ");
        String str = scanner.nextLine();
        List<String> numbers = Arrays.asList(str.split(","));
        Set<Integer> numbersSet = new TreeSet<>();
//        numbersSet.addAll(numbers);
        for (String i : numbers) {
            numbersSet.add(Integer.parseInt(i));
        }
       List<Integer> numbersList = new ArrayList<>();
        numbersList.addAll(numbersSet);
        Collections.reverse(numbersList);
        for (int i : numbersList) {
            System.out.print(i + ",");
        }
    }
}
