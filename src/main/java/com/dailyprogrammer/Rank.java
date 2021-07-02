package com.dailyprogrammer;

import java.util.List;
import java.util.stream.Collectors;

public class Rank {

    public static void main(String[] args) {
        // [2, 3, 1, 0]
        final List<Integer> list1 = List.of(4, 5, 2, 0);
        // [2, 1, 0]
        final List<Integer> list2 = List.of(1, 0, -1);

        System.out.println(rank(list1));
        System.out.println(rank(list2));
    }

    private static List<Integer> rank(List<Integer> list) {
        final List<Integer> sorted = list.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());

        return list.stream()
                .map(sorted::indexOf)
                .collect(Collectors.toUnmodifiableList());
    }

}
