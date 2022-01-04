package com.misc;

import java.util.stream.DoubleStream;

public class Testing {

    public static void main(String[] args) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (char vowel : vowels) {
            vowels[2] = 'X';
        }
        System.out.println(vowels);


        System.out.println(DoubleStream.of(.5, .5, 1e-16).sum());
        System.out.println(DoubleStream.of(.5, .5, 1e-16)
                .reduce(0, Double::sum));

        double a = 13.22;
        double b = 4.88;
        double c = 21.45;

        double abc = a + b + c;
        System.out.println("a + b + c = " + abc); // Outputs: a + b + c = 39.55

        double acb = a + c + b;
        System.out.println("a + c + b = " + acb); // Outputs: a + c + b = 39.550000000000004

        System.out.println(DoubleStream.of(a, b, c).sum());
        System.out.println(DoubleStream.of(a, b, c).reduce(0, Double::sum));
    }
}
