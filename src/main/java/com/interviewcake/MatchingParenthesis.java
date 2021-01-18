package com.interviewcake;

public class MatchingParenthesis {

    public static void main(String... args) {
        String sentence = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing";
        System.out.println(getClosingParenthesis(sentence, 10));
    }

    static int getClosingParenthesis(String sentence, int openingParenIndex) {
        int openNestedParenthesis = 0;

        for (int position = openingParenIndex + 1; position < sentence.length(); position++) {
            char c = sentence.charAt(position);

            if (c == '(') {
                openNestedParenthesis++;
            } else if (c == ')') {
                if (openNestedParenthesis == 0) {
                    return position;
                } else {
                    openNestedParenthesis--;
                }
            }
        }
        throw new IllegalArgumentException("No closing parenthesis :(");
    }

}
