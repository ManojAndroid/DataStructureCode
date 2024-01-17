package com.learning;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInWindow {
 /*   Time complexity: O(N)
    Space complexity: O(K)*/
    public static void countDistinct(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count distinct elements in the first window
        for (int i = 0; i < k; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        // Output the count of distinct elements in the first window
        System.out.println("Window 1: " + frequencyMap.size());

        // Move the window and update the count of distinct elements
        for (int i = k; i < arr.length; i++) {
            // Remove the leftmost element from the window
            int leftElement = arr[i - k];//point to remember
            if (frequencyMap.get(leftElement) == 1) {
                frequencyMap.remove(leftElement);// if key=1 value 2 means 1 present two time then don't remove one decrement value
            } else {
                frequencyMap.put(leftElement, frequencyMap.get(leftElement) - 1);//then don't remove one decrement value
            }

            // Add the current element to the window
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);

            // Output the count of distinct elements in the current window
            System.out.println("Window " + (i - k + 2) + ": " + frequencyMap.size());
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 3;
        countDistinct(arr, k);

    }
}
