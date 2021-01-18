package com.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMatching {

    public static void main(String[] args) {
        String[] words = {"contribute", "geeks", "geeker", "geekist", "ide", "practice"};
        List<String> listOfWords = new ArrayList<>(Arrays.asList(words));
        
        System.out.println(listOfWords);
        System.out.println(match(listOfWords));
    }

    static List<String> match(List<String> list) {
        List<String> matchingList = new ArrayList<>();
        for (String word : list) {
            if (word.matches("^gee.*$")) {
                matchingList.add(word);
            }
        }
        return matchingList;
    }

}
