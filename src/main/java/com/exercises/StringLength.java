package com.exercises;

public class StringLength {

    public static void main(String[] args) {
        System.out.println(length("jumpingjack"));
    }

    static int length(String s) {
        return s.isEmpty() ? 0 : length(s.substring(1)) + 1;
    }

}
