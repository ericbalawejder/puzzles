package com.Hackerrank;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortCountSwaps {

    public static void main(String[] args) {
        final List<Integer> list = List.of(1, 0, 1, 0, 1);
        System.out.println(minimumSwap(list));
    }

    static int minimumSwap(List<Integer> numbers) {
        final List<Integer> list = new ArrayList<>(numbers);
        int count = 0;
        int temp;
        boolean is_sorted;

        for (int i = 0; i < list.size(); i++) {
            is_sorted = true;
            for (int j = 1; j < (list.size() - i); j++) {
                if (list.get(j - 1) > list.get(j)) {
                    temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                    is_sorted = false;
                    count++;
                }
            }
            if (is_sorted) {
                return count;
            }
        }
        return count;
    }

}
