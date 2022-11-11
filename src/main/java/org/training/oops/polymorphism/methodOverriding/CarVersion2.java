package org.training.oops.polymorphism.methodOverriding;

public class CarVersion2 extends CarVersion1 {
    //This is called as runtime polymorphism
    public void windows() {
        System.out.println("The windows are automatic");
    }
}
