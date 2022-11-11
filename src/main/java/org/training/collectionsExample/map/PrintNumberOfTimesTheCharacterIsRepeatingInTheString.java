package org.training.collectionsExample.map;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class PrintNumberOfTimesTheCharacterIsRepeatingInTheString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the String :: ");
        String str = scanner.nextLine().toLowerCase(Locale.ROOT);
        char[] charArray = str.toCharArray();
        Map<Character, Integer> characterAndItsRepetition = new LinkedHashMap<>();
        for (char c : charArray) {
            if (characterAndItsRepetition.containsKey(c)) {
                int numberOfTimesCharacterIsRepeated = characterAndItsRepetition.get(c);
                characterAndItsRepetition.put(c, numberOfTimesCharacterIsRepeated + 1);
            } else {
                characterAndItsRepetition.put(c, 1);
            }
        }
//        characterAndItsRepetition.entrySet().stream().forEach(e-> System.out.println("Key :: " + e.getKey() + "  Value :: " + e.getValue()));
        //Without using maps
        int previousLength = str.length();
        while (!str.isEmpty()) {
            String firstCharacter = str.charAt(0) + "";
            str = str.replace(firstCharacter, "");
            int afterLength = str.length();
            int numberOfTimesCharacterIsRepeated = previousLength - afterLength;
            previousLength = afterLength;
            System.out.println(firstCharacter + " :: " + numberOfTimesCharacterIsRepeated);
        }
    }
}
