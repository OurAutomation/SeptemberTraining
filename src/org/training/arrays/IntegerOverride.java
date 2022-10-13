package org.training.arrays;

public class IntegerOverride {
    public static void main(String[] args) {
        int i=10;
        i--;
        ++i;
        i=11;
        System.out.println(i);//11,10

        int[] iArr = new int[]{12444, 4, 5, 6, 72, 3, 2, 2, 3, 455, 6, 6};
        iArr[0]=122;
        System.out.println(iArr[0]);

        String[] strArr = new String[] {"abc","bca","abc"};
        strArr[0] = "abdc";
        System.out.println(strArr[0]);
    }
}
