package org.training.loops.forLoop;

public class PrintSecondHalfOfTheArray {
    static String[] strArr = new String[]{"abc", "sdff", "afggh", "test", "trtr", "yuuu", "abcd", "try"};
    static String[] strArr1 = new String[]{"abc", "sdff", "afggh", "test", "trtr", "yuuu", "abcd"};

    public static void main(String[] args) {
        for (int i = strArr.length / 2; i < strArr.length; i++) {
            System.out.println(strArr[i]);
        }
        for (int i = strArr.length / 2; i < strArr1.length; i++) {
            System.out.println(strArr[i]);
        }
    }
}
