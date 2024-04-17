package clientQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ATLSDEVDefferenceIMP {
    /* A)There is an array A made of N integers. Your task is to choose as many integers from A as possible
     so that, when they are put in ascending order, all of the differences between all pairs of consecutive
     Integers are equal.
     For example, for A = [4, 3, 5, 1, 4, 4], you could choose 1, 3 and 5 (with differences equal to 2) or 4, 4 and 4 (with differences equal to 0).
   */
    public static int count(int[] A) {// todo not working correct
        Arrays.sort(A); // Sort the array in ascending order
        int maxCount = 1;
        int count = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                count++;
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 1, 4, 4};
        System.out.println("Result :" + count(arr));

        int[] arr1 = { 12, 12, 12, 15, 10};

        System.out.println("Result1 :" + count(arr1));

        int[] arr3 = {18, 26, 18, 24, 24, 20, 22};

        System.out.println("Result3 :" + count(arr3));

    }
}
