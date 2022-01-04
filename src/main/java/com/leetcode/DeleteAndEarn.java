package com.leetcode;

import java.util.Arrays;

public class DeleteAndEarn {

    public static void main(String[] args) {
        final int[] numbers = {2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn(numbers));
        int[] bucket = new int[10001];
        for (int i : numbers) {
            bucket[i] += i;
        }
        System.out.println(Arrays.toString(bucket));
    }

    static int deleteAndEarn(int[] values) {
        int[] bucket = new int[10001];
        for (int i : values) {
            bucket[i] += i;
        }

        int prev1 = 0, prev2 = 0;
        for (int i = 0; i < 10001; i++) {
            int taken = Math.max(prev1 + bucket[i], prev2);
            prev1 = prev2;
            prev2 = taken;

        }
        return Math.max(prev1, prev2);
    }
}
