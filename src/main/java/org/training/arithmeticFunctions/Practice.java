package org.training.arithmeticFunctions;


public class Practice {
    static boolean isAgeAbove18 = true;
    static char character = 'C';
    static String myName="Bharghav";
    static byte lessNumber = 127; //-128 to 127
    static short shortD = -32768;//-32768 to 32767
    static int intNumber = 396945641;//-2^31 to 2^31-1 (-2147483648 to 2147483647)
    static long longNumber = 1l; //-2^63 to 2^63-1  (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)
    static float floatNumber = 9223372036854775809.02F;
    static double doubleNumber = 1021561561515155656415645456455456465456465415645646545454566.1d;

// GIT

    public static void main(String[] args) {
        /*int a =10;
        //short, byte,integer,long,float,double
        System.out.println(a+2);
        System.out.println(11-2);
        System.out.println(11*2);
        System.out.println(11/2);*//*
        *//*AirthmeticOperations airthmeticOperations = new AirthmeticOperations();// Syntax to create an object of the class
        int sumOfTwoNumbers = airthmeticOperations.add(11,22);
        System.out.println(sumOfTwoNumbers);
        sumOfTwoNumbers = airthmeticOperations.add(45,68);
        System.out.println(sumOfTwoNumbers);
        sumOfTwoNumbers = airthmeticOperations.add(88,128);
        System.out.println(sumOfTwoNumbers);
        airthmeticOperations.addTwo=19345;
        System.out.println(airthmeticOperations.addTwo);*//*
        System.out.println(AirthmeticOperations.addThreeNumbers(45,56,65));
        System.out.println(AirthmeticOperations.staticVariable);
//       long abc = AirthmeticOperations.addingTwoLongNumbers(12,23);
        AirthmeticOperations operations = new AirthmeticOperations();
        int sum = operations.add(12,23);
        operations.subtractTwoNumbers(2,3);

        AirthmeticOperationsForHyderabad airthmeticOperationsForHyderabad = new AirthmeticOperationsForHyderabad();
        airthmeticOperationsForHyderabad.add(1, 2);
        airthmeticOperationsForHyderabad.addTwoDoubleNumbers(2, 3);
//        AirthmeticOperationsForHyderabad.addTwoDoubleNumbers(2, 3);*/
    }
}
