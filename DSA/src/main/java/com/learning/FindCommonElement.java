package com.learning;

import java.util.ArrayList;

public class FindCommonElement {
    //The time complexity of this solution is O(n), where n is the total number of elements in the arrays.
    ArrayList<Integer> commonElements(int arr1[], int arr2[], int arr3[], int n1, int n2, int n3)
    {
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                // Found a common element
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
    }
}
