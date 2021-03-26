package com.exercises;

import java.util.stream.DoubleStream;

public class TestStuff {

    public static void main(String[] args) {
        System.out.println(DoubleStream.of(1.0f, 1e-16f).sum());


        System.out.println(new StringBuilder("eds").toString());

        Integer a = 129;
        Integer b = 129;
        System.out.println(a.compareTo(b));
        System.out.println(a == b);

        String string = "Garbage collection is the process of automatic " +
                "memory management during the lifetime of a program.";
        System.out.println(string.length());
    }
}
