package com.learning;

import java.util.*;

public class RemoveDuplicatesInPlace {

    public static void removeDuplicates(List<Integer> list, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int writeIndex = 0; // This will be our index where we write to the list

        // Iterate through the list and modify it in place
        for (int readIndex = 0; readIndex < list.size(); readIndex++) {
            int num = list.get(readIndex);

            // Check how many times the current element has occurred
            int count = countMap.getOrDefault(num, 0);

            if (count < k) {
                // If the element has occurred less than k times, we keep it
                list.set(writeIndex++, num);
                // Update the count of the element
                countMap.put(num, count + 1);
            }
        }

        // After the loop, remove the excess elements from the list (after `writeIndex` position)
        while (list.size() > writeIndex) {
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Test case 1
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 5, 5, 6));
        //removeDuplicates(list1, Integer.MAX_VALUE); // No duplicates allowed
        //System.out.println(list1); // Output: [1, 2, 3, 4, 5, 6]

        // Test case 2
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 2, 3, 3, 3, 3));
        removeDuplicates(list2, 3); // Allow at most 3 occurrences
        System.out.println(list2); // Output: [1, 1, 1, 2, 2, 3, 3, 3]
    }
}
