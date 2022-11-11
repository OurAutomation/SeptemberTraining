package org.training.oops.abstraction.scientificCalculator;

public class SuperCalculator implements INormalCalculator, IScientificCalculator, IInterestCalculator {
    @Override
    public double compoundInterest(int principal, int time, int rate) {
        return principal * (Math.pow((1 + rate), time)) - principal;
    }

    @Override
    public double simpleInterest(int principal, int time, int rate) {
        return (principal * rate * time) / 100;
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }

    @Override
    public double pow(int a, int b) {
        return Math.pow(a, b);
    }

    @Override
    public float squareRoot(int a) {
        return (float) Math.sqrt(a);
    }

    @Override
    public double square(int a) {
        return a * a;
    }
}
