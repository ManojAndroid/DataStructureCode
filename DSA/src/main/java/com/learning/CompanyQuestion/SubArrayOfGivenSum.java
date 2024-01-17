package com.learning.CompanyQuestion;

public class  SubArrayOfGivenSum {
 /* Time Complexity: O(N)
  Auxiliary Space: O(1). Since no extra space has been taken*/
  static void findSubArrayOfGivenSum(int arr[], int sum) {

    int currentSum = arr[0], start = 0;
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      while (currentSum > sum && start < i-1 ) {
        currentSum = currentSum - arr[start++];
      }

      if (currentSum == sum) {
        System.out.println("found between "+start+" and "+(i-1) );
        System.out.print("subarray:");
        for (int j = start; j < i; j++) {
          System.out.print(arr[j] + " ");
        }
      }
      currentSum = currentSum + arr[i];
    }
  }

  public static void main(String[] args) {
    int arr[] = {15, 36,2, 4, 8, 9, 5, 10, 23};
    int sum = 23;
    findSubArrayOfGivenSum(arr, sum);
  }

}
