package org.training.stringPrograms.replace;

import java.util.Scanner;

public class RemoveAllCharactersExceptsAlphabetsFromTheGivenParagraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the paragraph :: ");
        String paragraph = scanner.nextLine();
//        System.out.println(paragraph.replaceAll("[A-Z]","")); //Remove only capital letters
//        System.out.println(paragraph.replaceAll("[a-z]","")); //Remove only small letters
        System.out.println(paragraph.replaceAll("[^A-Za-z]", "").trim());//remove all the alphabets
    }
}
