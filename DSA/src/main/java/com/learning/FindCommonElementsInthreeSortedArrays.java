package com.learning;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindCommonElementsInthreeSortedArrays {
    /*Time complexity: O(n1 + n2 + n3), where n1, n2 and n3 are sizes of ar1[], ar2[] and ar3[] respectively.
    Auxiliary Space: O(max(n1,n2,n3))*/
   public static ArrayList<Integer> commonElements(int arr1[], int arr2[], int arr3[])
    {
        Set<Integer> result = new LinkedHashSet<>();
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

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 10, 20, 40, 80,120};
        int[] arr2 = {6, 7, 20, 80, 100,120};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(commonElements(arr1, arr2, arr3));
    }
}
