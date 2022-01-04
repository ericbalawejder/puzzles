package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleNumber {

    public static void main(String[] args) {
        final List<Integer> numbers = List.of(2, 1, 2, 2, 4, 1, 9, 2, 5, 4, 5);
        System.out.println(findSingleNumber(numbers));
        final int[] nums = {2, 1, 2, 2, 4, 1, 9, 2, 5, 4, 5};
        System.out.println(findSingleNumber(nums));
    }

    static int findSingleNumber(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(0, value -> 1, Integer::sum)))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    static int findSingleNumber(int[] numbers) {
        return Arrays.stream(numbers)
                .reduce(0, (acc, x) -> acc ^ x);
    }

}
