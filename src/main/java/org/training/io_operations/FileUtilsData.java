package org.training.io_operations;

import java.io.File;
import java.io.IOException;

public class FileUtilsData {
    final static String PROJECT_HOME = System.getProperty("user.dir");

    public static void createAFile(String filename) {
        File file = new File(PROJECT_HOME + File.separator + filename);
        deleteAFile(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAFile(String filename) {
        File file = new File(PROJECT_HOME + File.separator + filename);
        boolean fileExists = file.exists();
        if (fileExists) {
            file.delete();
        }
    }

    public static void createAFolder(String filename) {
        File file = new File(PROJECT_HOME + File.separator + filename);
        deleteAFile(filename);
        file.mkdir();
    }


   /* public static void main(String[] args) throws IOException {

        System.out.println(PROJECT_HOME);
        //Create a file
        File file = new File(PROJECT_HOME + File.separator + "ABC.txt");
        boolean fileExists = file.exists();
        if (fileExists) {
            file.delete();
        }
        file.createNewFile();
        file = new File(PROJECT_HOME + File.separator + "dummy");
        file.mkdir();
        file.delete();
    }*/
}
