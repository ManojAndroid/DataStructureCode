package clientQuestion;

import java.util.Arrays;

public class PrintFirstlargestAndFirstSmallet {
    /* Given an array of integers, print the array in such a way that the first element is first maximum and second element is first minimum and so on
     EX :
     Input : arr[] = {7, 1, 2, 3, 4, 5, 6}
     Output : 7 1 6 2 5 3 4
     Input : arr[] = {1, 6, 9, 4, 3, 7, 8, 2}
     Output : 9 1 8 2 7 3 6 4*/
// 0(nlogn)
    public static void printFirstLargestAndSmallest(int[] arr) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            if (left == right) {
                System.out.print(arr[right--] + ",");
            } else {
                System.out.print(arr[right--] + "," + arr[left++] + ",");
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {7, 1, 2, 3, 4, 5, 6};
        printFirstLargestAndSmallest(arr);
        System.out.println("sample 2--------");
        int [] arr1={1, 6, 9, 4, 3, 7, 8, 2};
        printFirstLargestAndSmallest(arr1);

    }
}
