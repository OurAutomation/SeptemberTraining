package org.training.io_operations;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteDataInToTextFile {
    public static void main(String[] args) throws IOException {
        FileUtilsData.createAFile("ABC.txt");
        FileWriter fileWriter = new FileWriter(FileUtilsData.PROJECT_HOME + File.separator + "ABC.txt");
        fileWriter.write("test adding data to text file line 1\n");
        fileWriter.write("test adding data to text file line 2\n");
        fileWriter.write("test adding data to text file line 3\n");
        fileWriter.write("test adding data to text file line 4\n");
        fileWriter.close();
        FileReader fileReader = new FileReader(FileUtilsData.PROJECT_HOME + File.separator + "ABC.txt");
        int i;
        while ((i = fileReader.read()) != -1) {
            System.out.print((char) i);
        }
    }
}
