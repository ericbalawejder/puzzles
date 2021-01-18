package com.interviewcake;

import java.util.Objects;

class CakeType {

    final int weight;
    final int value;

    public static void main(String... args) {
        CakeType[] cakes = new CakeType[] {
                new CakeType(2, 20),
                new CakeType(5, 30),
                new CakeType(1, 10),
                new CakeType(3, 40),
                new CakeType(2, 2),
                new CakeType(8, 21)
        };

        for (CakeType cake : cakes) {
            //System.out.println(cake);
        }

        System.out.println(maxDuffelBagValue(cakes, 11));
    }

    CakeType(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {

        // we make an array to hold the maximum possible value at every
        // duffel bag weight capacity from 0 to weightCapacity
        // starting each index with value 0
        long[] maxValuesAtCapacities = new long[weightCapacity + 1];

        for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {

            // set a variable to hold the max monetary value so far for currentCapacity
            long currentMaxValue = 0;

            for (CakeType cakeType : cakeTypes) {

                // if a cake weighs 0 and has a positive value the value of our duffel bag is
                // infinite!
                if (cakeType.weight == 0 && cakeType.value != 0) {
                    throw new InfinityException();
                }

                // if the current cake weighs as much or less than the current weight capacity
                // it's possible taking the cake would get a better value
                if (cakeType.weight <= currentCapacity) {

                    // so we check: should we use the cake or not?
                    // if we use the cake, the most kilograms we can include in addition to the cake
                    // we're adding is the current capacity minus the cake's weight. we find the max
                    // value at that integer capacity in our array maxValuesAtCapacities
                    long maxValueUsingCake = cakeType.value + maxValuesAtCapacities[currentCapacity - cakeType.weight];

                    // now we see if it's worth taking the cake. how does the
                    // value with the cake compare to the currentMaxValue?
                    currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
                }
            }

            // add each capacity's max value to our array so we can use them
            // when calculating all the remaining capacities
            maxValuesAtCapacities[currentCapacity] = currentMaxValue;
        }

        return maxValuesAtCapacities[weightCapacity];
    }

    @Override
    public String toString() {
        return "{" + weight + " " + value + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CakeType other = (CakeType) obj;
        return value == other.value && weight == other.weight;
    }

    public static class InfinityException extends RuntimeException {
        public InfinityException() {
            super("Max value is infinity!");
        }
    }
}

