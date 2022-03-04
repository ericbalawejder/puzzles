package com.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(getPermutation("abc"));
        System.out.println(generatePermutations(new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd'))));
    }

    public static Set<String> getPermutation(String str) {
        Set<String> permutations = new HashSet<String>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            // terminating condition for recursion
            permutations.add("");
            return permutations;
        }
        // get the first character
        char first = str.charAt(0);

        // get the remaining substring
        String sub = str.substring(1);

        // make recursive call to getPermutation()
        Set<String> words = getPermutation(sub);

        // access each element from words
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++) {
                // insert the permutation to the set
                permutations.add(strNew.substring(0, i) + first + strNew.substring(i));
            }
        }
        return permutations;
    }

    public static <E> List<List<E>> generatePermutations(List<E> original) {
        if (original.isEmpty()) {
            List<List<E>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        E firstElement = original.remove(0);
        List<List<E>> returnValue = new ArrayList<>();
        List<List<E>> permutations = generatePermutations(original);
        for (List<E> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                List<E> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }

}


/*
// write a function that takes in this array.
// find the largest sum of geometrically increasing values.
const array = [75, 105, 120, 75, 90, 135];
//
const array2 = [10, 5, 20, 25, 15, 5, 5, 15, 3, 15, 5, 5, 15] // 138?
//90-15 -15 -15 -20
function subsetSum(array, i = 0, memo={}) {
  if (i >= array.length) {
    return 0;
  }

  if (memo[i]) {
    return memo[i];
  }
  console.log({memo})
  const included = array[i] + subsetSum(array, i + 2, memo);
  const notIncluded = subsetSum(array, i + 1, memo);
  // console.log({included});
  // console.log({notIncluded});
  memo[i] = Math.max(included, notIncluded);

  return memo[i];
}

console.log(subsetSum(array2)); //330

 */