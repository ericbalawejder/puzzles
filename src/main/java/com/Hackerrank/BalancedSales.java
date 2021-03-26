package com.Hackerrank;

public class BalancedSales {

    public static void main(String[] args) {
        final int[] sales = {1, 2, 3, 4, 6};
        System.out.println(indexOfSmallestElement(sales));
    }

    static int indexOfSmallestElement(int[] sales) {
        int sum = 0;
        for (int sale : sales) {
            sum += sale;
        }
        int leftSum = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sum - sales[i] - leftSum == leftSum) {
                return i;
            }
            leftSum += sales[i];
        }
        return -1;
    }

}
