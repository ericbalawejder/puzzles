package com.Hackerrank;

import java.util.Arrays;
import java.util.List;

public class TripleThreat {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 6, 17, 8, 99, 11, 12, 13);
        System.out.println(consecutiveIntegers(numbers));
    }

    static int consecutiveIntegers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 2; i++) {
            if (numbers.get(i) + 1 == numbers.get(i + 1) &&
                    numbers.get(i) + 2 == numbers.get(i + 2)) {
                return 1;
            }
        }
        return 0;
    }
}
