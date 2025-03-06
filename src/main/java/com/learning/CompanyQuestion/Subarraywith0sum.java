package com.learning.CompanyQuestion;

import java.util.HashSet;
import java.util.Set;

public class Subarraywith0sum {
    public static boolean findsum(int arr[],int n)
    {
        Set<Integer> set = new HashSet<>();
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum +=arr[i];
            if(arr[i]==0 || sum==0|| set.contains(sum))
                return true;

            set.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr= {5,-4,-3,-1};
        System.out.println(findsum(arr,4));
    }
}
