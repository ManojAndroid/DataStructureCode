package com.learning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProductExceptSelf {
    public static  int[] productExceptSelf(int[] nums) {

        int n=nums.length;
        int temp1[]=new int[n];
        int value1=1;
        for(int i=0;i<n;i++)
        {
            temp1[i]=value1;
            value1=value1*nums[i];
        }
        int temp2[]=new int[n];

        int value2=1;
        for(int i=n-1;i>=0;i--)
        {
            temp2[i]=value2;
            value2=value2*nums[i];
        }
        int [] result=new int[n];

        for(int i=0;i<n;i++)
        {
            result[i]=temp1[i]*temp2[i];
        }

        return result;

    }

    public static int removeDuplicates(int[] nums) {

        Set<Integer> set=new HashSet<>();
        for(int num:nums)
        {
            set.add(num);
        }
        System.out.println(set);
        return set.size();

    }

    public static void main(String[] args) {

       int [] nums ={1,1,2};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

        System.out.println(removeDuplicates(nums));
    }
}
