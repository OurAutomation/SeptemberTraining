package org.training.arrays;

public class FirstArray {
    public static void main(String[] args) {
        int i=10;
        int [] iArr = new int[] {1,2,3,4,5,6,7,1238};
        System.out.println(iArr[0]);
        System.out.println(iArr[7]);
        System.out.println(iArr[4]);
        String[] strArr = new String[] {"abc","str","try","at@123"};
        System.out.println(strArr[1]);
//        System.out.println(strArr[14]);
        System.out.println(strArr.length);
        System.out.println(iArr.length);
        System.out.println(iArr[iArr.length-1]);
    }

}
