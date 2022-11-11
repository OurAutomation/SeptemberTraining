package org.training.oops.abstraction.scientificCalculator;

public interface IInterestCalculator {
    double compoundInterest(int principal, int time, int rate);

    double simpleInterest(int principal, int time, int rate);
}
