package com.exercises;

// Write an efficient function that takes stock_prices and returns the best profit
// I could have made from one purchase and one sale of one share of stock yesterday.
public class StockTradingProfit {

    public static void main(String... args) {
        int[] stockPrices = {10, 7, 5, 8, 11, 9};
        System.out.println(getMaxProfit(stockPrices));
    }

    public static int getMaxProfit(int[] stockPrices) {
        if (stockPrices.length < 2) {
            throw new RuntimeException("Stock input requires at least 2 prices.");
        }

        int minimumPrice = stockPrices[0];
        int maximumProfit = stockPrices[1] - stockPrices[0];

        for (int time = 1; time < stockPrices.length; time++) {
            int currentPrice = stockPrices[time];
            int potentialProfit = currentPrice - minimumPrice;
            maximumProfit = Math.max(potentialProfit, maximumProfit);
            minimumPrice = Math.min(minimumPrice, currentPrice);
        }
        return maximumProfit;
    }
}
