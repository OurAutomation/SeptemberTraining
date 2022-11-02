package org.training.oops.abstraction;

public abstract class AbstractCalculator {
    public int add(int i, int j) {
        return i + j;
    }

    public int subtract(int i, int j) {
        return i - j;
    }

    public abstract int multiply(int i, int j);

    public abstract int divide(int i, int j);
}
