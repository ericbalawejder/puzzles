package com.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingCoins {

    public static void main(String[] args) {
        System.out.println(countCoins(new int[]{1, 10, 5}, 25));
        combinationsOfNChooseR(5, 2);
    }

    static int countCoins(int[] coins, int amount) {
        final int[] combinations = new int[amount + 1];
        combinations[0] = 0;
        for (int i = 1; i <= amount; i++) {
            combinations[i] = amount + 1;
        }
        for (int coin : coins) {
            for (int amt = 1; amt <= amount; amt++) {
                if (amt >= coin) {
                    combinations[amt] = Math.min(combinations[amt], 1 + combinations[amt - coin]);
                }
            }
        }
        return combinations[amount] != amount + 1 ? combinations[amount] : -1;
    }

    static void combinationsOfNChooseR(int N, int R) {
        final List<int[]> combinations = generate(N, R);
        for (int[] combination : combinations) {
            System.out.println(Arrays.toString(combination));
        }
        System.out.printf("generated %d combinations of %d items from %d ", combinations.size(), R, N);
    }

    static List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n - 1, 0);
        return combinations;
    }

    private static void helper(List<int[]> combinations, int[] data, int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

}

/*
// counting change
// Write a function, changeCount, that takes an array that represents
//  a stack of coins and a target amount of change.
// the function should return the number of different ways it is possible
// to make change for the target amount using the coins.

//countingChange(4, [1, 2, 3]); // 4

// Brute-force combinations.


//        1
//      / | \
//     1  2 *3
//   /  \  \
//  *2   3  *1

//         4
//      / | \ \
//     3  3 2  1
//   /    |
//  2     1


//n + (n+1) || n

// 1. Base case: Is value 0? We're done.
// 2. Base case: Is value < 0? We're done.
//

function coindfs(coins, target, i = 0, visited={}) {
  // bases
  const key = `${i}|${target}`;
  const coin = coins[i];

   if (visited[key]) {
    console.log("hit visited")
     return visited[key];
  }

  if(target === 0) {
    return 1;
  }

  if (i >= coins.length || target < 0){
    return 0;
  }

  //for loop to multiply index until it reaches target value
  let count = 0;
  for (let quantity = 0; coin * quantity <= target; quantity++) {
    let remainder = target - (coin * quantity);

    console.log({key,remainder,coin,quantity});

    count = count + coindfs(coins, remainder, i + 1, visited);
  }
  // console.log(visited);
  visited[key] = count;

  return count;
}


console.log(coindfs( [1, 2, 3],8));
// console.log(coindfs([1, 5, 10, 25],512));


// function combinations(target = 4, coins = [1, 2, 3]) {
//   const combos = [];
//   const results = [];

//   for (let i=0; i<coins.length; i++) {
//     const c1 = coins[i];

//     for (let j=i+1; j<coins.length; j++) {
//       const c2 = coins[j];
//       combos.push([c1, c2]);
//     }
//   }



//   const sumFn = (previousValue, currentValue) => previousValue + currentValue;

//   // Calculate the sum across the combos.
//   for (const combo of combos) {
//     const total = combo.reduce(sumFn);
//     if (total === target) {
//       results.push(combo);
//     }
//   }

//   return results;
// }

// console.log(combinations());
 */