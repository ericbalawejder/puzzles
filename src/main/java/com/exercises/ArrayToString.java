package com.exercises;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayToString {

    public static void main(String[] args) {
        final int[] values = {12, 3, 55, 789, 0, -1, 34, 22};
        System.out.println(convertToCommaDelimitedString(values));
    }

    static String convertToCommaDelimitedString(int[] values) {
        return Arrays.stream(values)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
