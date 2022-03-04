package com.combinations;

import org.paukov.combinatorics3.Generator;

import java.util.List;

// https://github.com/dpaukov/combinatoricslib3
public class Combinations {

    public static void main(String[] args) {
        System.out.println("Combinations of length 3 of integers [0, 5]");
        Generator.combination(0, 1, 2, 3, 4, 5)
                .simple(3)
                .stream()
                .forEach(System.out::println);

        System.out.println("Combinations of length 2 of a, b, c, d:");
        Generator.combination('a', 'b', 'c', 'd')
                .simple(2)
                .stream()
                .forEach(System.out::println);

        System.out.println("Permutations of a, b, c:");
        Generator.permutation('a', 'b', 'c')
                .simple()
                .stream()
                .forEach(System.out::println);

        System.out.println("Permutations of a, b, c:");
        final List<List<Character>> permutations = Generator.permutation('a', 'b', 'c')
                .simple()
                .stream()
                .toList();
        System.out.println(permutations);

        System.out.println("Cartesian product of Lists [1, 2] x [4, 5]");
        Generator.cartesianProduct(List.of(1, 2), List.of(4, 5))
                .stream()
                .forEach(System.out::println);

        System.out.println("Partition of 10");
        Generator.partition(10)
                .stream()
                .forEach(System.out::println);

        System.out.println("Subsets");
        Generator.subset(List.of(2, 3, 5))
                .simple()
                .stream()
                .forEach(System.out::println);
    }

}
