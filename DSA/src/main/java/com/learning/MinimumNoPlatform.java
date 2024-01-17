package com.learning;

import java.util.Arrays;

public class MinimumNoPlatform {
   /* Time Complexity: O(n2), Two nested loops traverse the array.
    Auxiliary space: O(1), As no extra space is required.*/
    public static int minimumPlatform(int[] arr, int[] dep, int m) {

        Arrays.sort(arr);
        Arrays.sort(dep);
        int required = 1, platformNeed = 1;

        int i = 1;
        int j = 0;

        while (i < m && j < m) {

            if (arr[i] <= dep[j]) {
                platformNeed++;
                i++;
            } else if(arr[i]>dep[j]) {
                platformNeed--;
                j++;
            }
            if (platformNeed > required) {
                required = platformNeed;
            }
        }
        return required;
    }

    public static void main(String[] args) {
        int arr[] = {100, 300, 500};
        int dep[] = {900, 400, 600};
        int n = 3;
        System.out.println(minimumPlatform(arr, dep, n));
    }
}
