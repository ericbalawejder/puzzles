package com.exercises;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DrawDoodle {

    public static void main(String[] args) {
        //System.out.println(draw("***********"));
        //System.out.println(drawDoodle("+++++++++++"));
    }

    static String draw(String sequence) {
        String[] characters = sequence.split("");
        StringBuilder drawing = new StringBuilder();
        for (int i = 0; i < sequence.length(); i++) {
            for (int j = 0; j < i; j++) {
                drawing.append(" ");
            }
            drawing.append(characters[i] + "\n");
        }
        return drawing.toString();
    }

//    static List<String> drawDoodle(String sequence) {
//        return sequence.chars()
//                .mapToObj(c -> (char) c)
//                .map(x -> IntStream.range(0, sequence.length()).mapToObj(s -> s + "-"))
//                .flatMap(x -> x.stream())
//                .collect(Collectors.toUnmodifiableList());
//    }

}
