package com.exercises;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Set;

class DNA {

    // Create an arbitrary size file of RNA
    public static void main(String[] args) {

        String path = "src/com/exercises/java/RNA.txt";
    }

    void writeToFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("Some String");
        //printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();
    }

    String generateDNA(BigInteger terms) {
        final Set<Character> characterSet = Set.of('C', 'G', 'A', 'T');
        return "";
    }
}
