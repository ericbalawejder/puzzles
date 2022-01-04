package com.leetcode;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        final int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            min = Math.min(price, min);
            max = Math.max(max, price - min);
        }
        return max;
    }

}
