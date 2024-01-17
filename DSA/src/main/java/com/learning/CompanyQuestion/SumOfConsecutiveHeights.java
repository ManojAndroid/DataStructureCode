package com.learning.CompanyQuestion;

public class SumOfConsecutiveHeights {

  /*public static int sumOfConsecutiveHeights(int[] heights) {
    int n = heights.length;
    int[] prefixSum = new int[n];
    prefixSum[0] = heights[0];
    for (int i = 1; i < n; i++) {
      prefixSum[i] = prefixSum[i-1] + heights[i];
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int consecutiveSum = prefixSum[j] - prefixSum[i] + heights[i];
        sum += consecutiveSum;
      }
    }
    return sum;
  }*/
//The expression heights[i] * (i + 1) * (n - i) is a formula used to calculate the contribution of the height of a building at index i to the total sum of all possible heights that Zapy climbs consecutively. Let's break down the components of this formula:
//
//heights[i]: The height of the building at index i.
//(i + 1): The factor that represents the position of the building in the consecutive climb. It starts from 1 because Zapy starts climbing from the first building.
//(n - i): The factor that represents the number of buildings remaining to climb after the current building. It decreases as Zapy climbs higher buildings.
//So, by multiplying these factors, you get the contribution of the height of the building at index i to the total sum of all possible heights climbed consecutively.
//
//In the context of the entire loop, this formula is used for each building, and the results are accumulated to calculate the overall sum. The loop iterates through all buildings, and for each building, it adds up the contribution to the total sum.
  public static int sumOfConsecutiveHeights(int[] heights,int n) {
    int totalSum = 0;

    for (int i = 0; i < n; i++) {
      totalSum += heights[i] * (i + 1) * (n - i);
    }

    return totalSum;
  }


  public static void main(String[] args) {
    int arr[]={1,2,3,4};
    //int arr[]={2,3};
    System.out.println(sumOfConsecutiveHeights(arr,arr.length));
  }

}
