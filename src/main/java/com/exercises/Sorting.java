package com.exercises;

import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        final List<Integer> numbers = List.of(8, 4, 2, 33, 8, 0, 21);
        System.out.println(sort(numbers));
    }

    static <T> List<T> sort(List<T> list) {
        return list.stream()
                .sorted()
                .toList();
    }

}
