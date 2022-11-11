package org.training.loops.forLoop;

public class PrintSecondHalfOfAnArrayUsingForEach {
    static String[] strArr = new String[]{"abc", "sdff", "afggh", "test", "trtr", "yuuu", "abcd", "try"};

    public static void main(String[] args) {
        int length = strArr.length;
        int index = 0;
        for (String str : strArr) {
            if (index < length / 2) {

            } else {
                System.out.println(str);
            }
            index++;
        }

        for (String str : strArr) {
            if (index > length / 2) {
                System.out.println(str);
            }
            index++;
        }
    }
}
