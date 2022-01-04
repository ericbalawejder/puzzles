package com.leetcode;

import java.util.List;

// https://leetcode.com/discuss/interview-question/1471584/Amazon-OA
public class ConsecutivelyDecreasing {

    public static void main(String[] args) {
        final List<Integer> ratings = List.of(4, 3, 5, 4, 3);
        System.out.println(consecutiveDecreasing(ratings));
    }

    static int consecutiveDecreasing(List<Integer> ratings) {
        if (ratings.size() == 0) return 0;

        int left, right, total = 0;

        for (int i = 0; i < ratings.size(); i++) {
            left = i;
            right = i;
            while (i < ratings.size() - 1 && ratings.get(i) - ratings.get(i + 1) == 1) {
                i++;
                right = i;
            }
            int sequenceSize = right - left + 1;
            total += (sequenceSize * (sequenceSize + 1)) / 2;
            System.out.println(total);
        }
        return total;
    }

    static boolean validateCoupon(String str) {
        if (str.length() == 0) return true;
        if (str.length() % 2 == 1) return false;

        int left = 0;
        int right = str.length() - 1;

        while (left < right && left < str.length()) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                boolean isMirror = false;
                if (str.charAt(left) == str.charAt(left + 1)) {
                    left += 2;
                    isMirror = true;
                }
                if (str.charAt(right) == str.charAt(right - 1)) {
                    right -= 2;
                    isMirror = true;
                }
                if (!isMirror) {
                    return false;
                }
            }
        }
        return true;
    }

}
