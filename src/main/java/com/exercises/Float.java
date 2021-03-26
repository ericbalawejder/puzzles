package com.exercises;

import java.util.stream.DoubleStream;

public class Float {

    public static void main(String[] args) {


        System.out.println(DoubleStream.of(1.0, 1e-16).reduce(0, Double::sum));
        System.out.println(DoubleStream.of(1.0, 1e-16).sum());
        // 1.0
        // 0.9999999999999999


        System.out.println(kahanSummation(1.0d, 1e-16));
    }

    static double kahanSummation(double... numbers) {
        double sum = 0.0;
        double error = 0.0;

        for (double value : numbers) {
            double y = value - error;
            double z = sum + y;
            error = (z - sum) - y;
            sum = z;
        }
        return sum;
    }

    static double sum(double... n) {
        double sum = 0;
        for (double v : n) {
            sum += v;
        }
        return sum;
    }

}
