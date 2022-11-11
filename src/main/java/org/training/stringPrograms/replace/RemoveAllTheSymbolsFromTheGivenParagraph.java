package org.training.stringPrograms.replace;

import java.util.Scanner;

public class RemoveAllTheSymbolsFromTheGivenParagraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the paragraph :: ");
        String paragraph = scanner.nextLine();
        System.out.println(paragraph.replaceAll("[^A-Za-z0-9]", "").trim());//remove all except symbols
    }
}
