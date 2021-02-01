package com.exercises;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class DNA {

    private static final Map<Character, Character> RNA_TRANSCRIPTION =
            Map.of('C', 'G', 'G', 'C',
                    'T', 'A', 'A', 'U'
            );

    public static void main(String[] args) throws IOException {
        //String path = "src/main/java/com/exercises/DNA.txt";
        //writeToFile(generateDNA2(8000, 80), path);
        // Create readFile feature.

        System.out.println(transcribe(generateDNA(100)));
    }

    static String transcribe(String dnaStrand) {
        return dnaStrand.chars()
                .mapToObj(c -> (char) c)
                .map(c -> RNA_TRANSCRIPTION.getOrDefault(c, c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static String generateDNA(long length) {
        final List<Character> dna = new ArrayList<>(RNA_TRANSCRIPTION.keySet());

        return LongStream.rangeClosed(1, length)
                .mapToObj(i -> dna.get((int) (dna.size() * Math.random())))
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
    }

    private static String generateDNA2(long length, int numberPerLine) {
        final List<Character> dna = new ArrayList<>(RNA_TRANSCRIPTION.keySet());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= length; i++) {
            Character nucleotide = dna.get((int) (dna.size() * Math.random()));
            stringBuilder.append(nucleotide);
            if (i % numberPerLine == 0) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private static void writeToFile(String content, String path) throws IOException {
        final PrintWriter printWriter = new PrintWriter(new FileWriter(path));
        printWriter.print(content);
        printWriter.close();
    }

}
