package com.learning;

import java.util.Arrays;

public class RotateArray {
   /* Time Complexity: O(N * d)
    Auxiliary Space: O(1)*/

    public static void rotateArray(int[] arr, int d) {

        int p = 0;
        int result = 0;
        while (p < d) {
            int tempForLastIndex = arr[0];
            int temp = 0;
            System.out.print("rotation count " + p + " array : " + Arrays.toString(arr) + "  ");
            for (int i = 0; i < arr.length; i++) {
                temp = temp + i * arr[i];
                System.out.print(i + "*" + arr[i]);
                if (i < arr.length-1) {
                    System.out.print(" + ");
                }

            }
            System.out.print(" = " + temp);

            System.out.println(" ");

            if (temp > result) {
                result = temp;
            }
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = tempForLastIndex;
            p++;

        }
        System.out.println(" Result " + result);


    }


    public static void reverse(int [] nums, int i, int j){
        int li = i;
        int ri = j;

        while(li < ri){
            int temp = nums[li];
            nums[li] = nums[ri];
            nums[ri] = temp;

            li++;
            ri--;
        }
    }
    public static  int [] rotate(int[] nums, int k) {
        int n=nums.length;
        reverse(nums, 0, n-1);//reverse all
        reverse(nums, 0, k-1);// reverse 0 to k-1;
        reverse(nums, k+1, n-1);// reverse k+1 to n-1
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = arr.length;
        rotateArray(arr, d);
        System.out.println("Rotate");
        System.out.println(Arrays.toString(rotate(arr,3)));
    }
}
