package org.training.oops.abstraction.scientificCalculator;

public class IInterestCalculatorImpl implements IInterestCalculator{
    @Override
    public double compoundInterest(int principal, int time, int rate) {
        return principal*(Math.pow((1+rate),time))-principal ;
    }

    @Override
    public double simpleInterest(int principal, int time, int rate) {
        return (principal * rate * time) / 100;
    }
}
