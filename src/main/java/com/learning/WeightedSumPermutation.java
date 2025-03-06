package com.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeightedSumPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        long maxWeightedSum = findMaxWeightedSum(arr);

        System.out.println("Maximum Weighted Sum: " + maxWeightedSum);
    }

    private static long calculateWeightedSum(int[] arr, List<Integer> permutation) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[permutation.get(i)] * i;
        }

        return sum;
    }

    private static long findMaxWeightedSum(int[] arr) {
        List<Integer> originalIndices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            originalIndices.add(i);
        }

        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutations(originalIndices, permutations, 0);

        long maxWeightedSum = Long.MIN_VALUE;

        for (List<Integer> permutation : permutations) {
            long weightedSum = calculateWeightedSum(arr, permutation);
            maxWeightedSum = Math.max(maxWeightedSum, weightedSum);
        }

        return maxWeightedSum;
    }

    private static void generatePermutations(List<Integer> original, List<List<Integer>> result, int start) {
        if (start == original.size()) {
            result.add(new ArrayList<>(original));
            return;
        }

        for (int i = start; i < original.size(); i++) {
            Collections.swap(original, i, start);
            generatePermutations(original, result, start + 1);
            Collections.swap(original, i, start);
        }
    }
}
