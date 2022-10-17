package org.training.loops.forLoop;

public class GetThePositionOfYourNameInWaitingList {
    static String[] strArr = new String[]{"adam", "scott", "mark", "jennings", "cook", "root", "ross"};
    static String name = "cook";

    public static void main(String[] args) {
        for (int i = 0; i < strArr.length; i++) {
            String presentName = strArr[i];
            System.out.println("Number of times loop is getting executed :: " + (i+1));
            if (presentName.equals(name)) {
                System.out.println("Position of the person in the array :: " + i);
//                stop the loop
                break;
            }
        }
    }
}
