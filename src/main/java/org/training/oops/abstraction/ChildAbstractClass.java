package org.training.oops.abstraction;

public class ChildAbstractClass extends AbstractCalculator {
    @Override
    public int multiply(int i, int j) {
        return i * j;
    }

    @Override
    public int divide(int i, int j) {
        return i / j;
    }
}
