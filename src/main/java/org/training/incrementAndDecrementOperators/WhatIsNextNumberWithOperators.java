package org.training.incrementAndDecrementOperators;

import java.util.Scanner;

public class WhatIsNextNumberWithOperators {
    public static void main(String[] args) {
        int numberGiven = 5;
        int number =numberGiven;
        //numberGiven++ === (numberGiven=numberGiven+1)
        //numberGiven-- === (numberGiven=numberGiven-1;)
        System.out.println(numberGiven++);//5
        System.out.println(++numberGiven);//7
        System.out.println(--numberGiven);//6
        System.out.println(numberGiven--);//6
        System.out.println(numberGiven);//5
        System.out.println(++number);
        number--;
        System.out.println(--number);
    }
}
