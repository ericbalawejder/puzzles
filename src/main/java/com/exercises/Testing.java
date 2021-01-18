package com.exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Testing {

    public static void main(String... args) {

        int[] distribution = new int[20];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    for (int l = 1; l <= 6; l++) {
                        int min = Math.min(i, Math.min(j, Math.min(k, l)));
                        int sum = i + j + k + l - min;
                        distribution[sum]++;
                        //System.out.format("%d %d %d %d (min=%d) (sum=%d)%n", i, j, k, l, min, sum);
                        //System.out.println(Arrays.toString(distribution));
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(distribution));
        // [0, 0, 0, 1, 4, 10, 21, 38, 62, 91, 122, 148, 167, 172, 160, 131, 94, 54, 21, 0]

        final Set<Object> stuff = new HashSet<>();
        stuff.add("Some string");
        System.out.println(stuff);
    }

}
