package org.training.oops.abstraction.scientificCalculator;

public class Practice {
    public static void main(String[] args) {
       /* INormalCalculatorImpl calculator = new INormalCalculatorImpl();
        calculator.add(1, 2);
        WrongCalculatorImpl wrongCalculator = new WrongCalculatorImpl();
        wrongCalculator.add(1, 2);*/
        INormalCalculator calculator;
        calculator = new INormalCalculatorImpl();
        System.out.println(calculator.add(1, 2));
        calculator = new WrongCalculatorImpl();
        System.out.println(calculator.add(1, 2));

    }
}
