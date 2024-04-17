package com.learning;

import java.util.Arrays;
import java.util.Comparator;

public class FormTheLargestNumberFromArray {
    //tc=O(n log n)
    static String prontLargestNumber(Integer arr[]) {
        Arrays.sort(arr, (a, b) -> {
            // Concatenate both numbers in different orders
            String ab = a + "" + b;
            String ba = b + "" + a;

            // Compare the concatenated values
            return ba.compareTo(ab);
        });
        // Form the largest number
        StringBuilder largestNumber = new StringBuilder();
        for(Integer num :arr)
        {
            largestNumber.append(num);
        }
        return largestNumber.toString();
    }

    public static void main(String[] args) {
        Integer[] numbers = {3, 30, 34, 5, 9};
        String result = prontLargestNumber(numbers);
        System.out.println("Largest Number: " + result);
    }

}
