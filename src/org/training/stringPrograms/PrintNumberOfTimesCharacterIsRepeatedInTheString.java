package org.training.stringPrograms;

public class PrintNumberOfTimesCharacterIsRepeatedInTheString {
    static String str = "I am a automation tester from na";

    public static void main(String[] args) {
        int previousLength, presentLength;
        while (str.length() > 0) {
            char firstCharacter = str.charAt(0);// first character
            previousLength = str.length();
            str = str.replace(firstCharacter + "", "");
            presentLength = str.length();
            System.out.println("After replacing the first character string is :: " + str);
            System.out.println(firstCharacter + " :: " + (previousLength - presentLength));
        }
    }
}
