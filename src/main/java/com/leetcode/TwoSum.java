package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();
        int[] array = {2, 7, 11, 15};
        print(twoSum1(array, 9));


        List<Integer> list = new ArrayList<>(Arrays.asList(2, 7, 11, 15));
        System.out.println(twoSum.twoSum(list, 17));
    }

    static int[] twoSum1(int[] nums, int target) {
        if(nums == null || nums.length < 2)
            return new int[] {0,0};
     
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{ map.get(nums[i]), i };
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[] {0, 0};
    }

    static boolean twoSum2(List<Integer> numbers, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (set.contains(numbers.get(i))) {
                return true;
            } else {
                set.add(target - numbers.get(i));
            }
        }
        return false;
    }

    boolean twoSum(List<Integer> numbers, int target) {
        return IntStream.range(0, numbers.size())
                .map(i -> target - numbers.get(i))
                .anyMatch(i -> numbers.contains(i));
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
