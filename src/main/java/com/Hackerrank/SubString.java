package com.Hackerrank;

import java.util.Scanner;

public class SubString {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        System.out.println(subString(S, start, end));
    }

    static String subString(String word, int start, int end) {
        return word.substring(start, end);
    }
}
