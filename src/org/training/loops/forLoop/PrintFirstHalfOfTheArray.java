package org.training.loops.forLoop;

public class PrintFirstHalfOfTheArray {
    static String[] strArr = new String[]{"abc", "sdff", "afggh", "test", "trtr", "yuuu", "abcd", "try"};
    static String[] strArr1 = new String[]{"abc", "sdff", "afggh", "test", "trtr", "yuuu", "abcd"};

    public static void main(String[] args) {
        for (int i = 0; i < strArr.length / 2; i++) {
            System.out.println(strArr[i]);
        }
        for (int i = 0; i < strArr1.length / 2; i++) {
            System.out.println(strArr[i]);
        }
    }
}
