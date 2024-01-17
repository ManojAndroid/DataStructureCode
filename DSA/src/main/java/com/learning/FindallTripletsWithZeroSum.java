package com.learning;

import java.util.HashSet;
import java.util.Set;

public class FindallTripletsWithZeroSum {
    /*Create a HashSet to store a unique element.
    Run a nested loop with two loops, the outer loop from 0 to n-2 and the inner loop from i+1 to n-1
    Check if the sum of ith and jth element multiplied with -1 is present in the HashSet or not
    If the element is present in the HashSet, print the triplet else insert the jth element in the HashSet.*/

   /* Time Complexity: O(n2)
    Auxiliary Space: O(n)
*/

    public static  boolean findTriplets(int arr[] , int n)
    {
        for(int i=0; i<n-1;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i+1;j<n;j++){
                int temp=-(arr[i]+arr[j]);

                if(set.contains(temp))
                {
                    System.out.println("["+arr[i]+","+arr[j]+","+temp+"]");
                    //return true;
                }
                else {
                    set.add(arr[j]);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 0, -1, 2, -3, 1 };
        int n = arr.length;
        System.out.println(findTriplets(arr, n));
    }
}
