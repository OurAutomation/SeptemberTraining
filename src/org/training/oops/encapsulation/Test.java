package org.training.oops.encapsulation;

public class Test {
    public static void main(String[] args) {
        CalculateSimpleInterest calculateSimpleInterest = new CalculateSimpleInterest();
        calculateSimpleInterest.setPrincipal(100);
        calculateSimpleInterest.setRate(12);
        calculateSimpleInterest.setTime(36);
        System.out.println(calculateSimpleInterest.getInterest());
    }
}
