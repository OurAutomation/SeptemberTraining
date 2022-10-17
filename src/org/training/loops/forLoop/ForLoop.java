package org.training.loops.forLoop;

public class ForLoop {
    public static void main(String[] args) {
        int[] arr = new int[]
                {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int i=0;

        //Infinite for loop
        /*for(;;) {
            System.out.println(arr[i]);
            i++;
        }*/
        for(int i=0;i<4;++i) {
            int presentNumber = arr[i];
            System.out.println(presentNumber);
        }

        System.out.println("Printed all numbers");
    }
}
