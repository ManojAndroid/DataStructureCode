package clientQuestion;

public class ReverseArrayInGroupOfKSize {

    /*Given an array arr[] of positive integers of size N. Reverse every sub-array group of size K.
            Note: If at any instance, there are no more sub arrays of size greater than or equal to K, then reverse the last sub array (irrespective of its size).
    Example 1:
    Input:N = 5, K = 3
    arr[] = {1,2,3,4,5}
    Output: 3 2 1 5 4
    O(n)*/
    public static void reverseArray(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            int temp;
            while (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

    }

    public static void main(String[] args) {
       int [] arr= {1, 2, 3, 4, 5, 6, 7, 8};
       int k=3;
        reverseArray(arr,k);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
