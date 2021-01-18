package com.exercises;

import java.util.Scanner;

public class DrawDiamond {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the size of the diamond.");
        int size = input.nextInt();

        System.out.println("Please enter the character you would like to use");
        String character = input.next();

        int blanks = size / 2;

        int charatersOnLine = (size + 1) / 2;

        // Draws the top half of the diamond.
        while(charatersOnLine <= size && blanks >= 0) {
            int characters = charatersOnLine - blanks;
            printCharacters(blanks, characters, character);
            System.out.println();
            charatersOnLine++;
            blanks--;
        }


        //This is to help check charactersOnLine and blanks.
        //System.out.println("charactersOnLine is " + charatersOnLine);
        //System.out.println("blanks is " + blanks);

        blanks = 1;
        charatersOnLine = size - 1;

        // Draws the bottom half of the diamond.
        while(charatersOnLine >= 0 && blanks <= (size/2)) {
            int characters = charatersOnLine - blanks;
            printCharacters(blanks, characters, character);
            System.out.println();
            charatersOnLine--;
            blanks++;
        }

    }

    public static void printCharacters(int numBlanks, int numCharacters, String character) {
        // This statement is for even valued sizes of the diamond. It prints nothing on the first and last lines.
        if(numCharacters <= 0) {
            return;
        }
        String blank = " ";
        printCharacters(numBlanks, blank);
        printCharacters(numCharacters, character);
    }

    public static void printCharacters(int numCharacters, String character) {
        for(int i = 0; i < numCharacters; i++) {
            System.out.print(character);
        }
    }

}
