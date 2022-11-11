package org.training.loops.whileLoop;

public class DoWhile {
    public static void main(String[] args) {
        boolean isUserFound = false;
        while (isUserFound) {
            System.out.println("Executing while loop");
        }

        do {
            System.out.println("Executing do while loop");
        } while (isUserFound);
    }
}
