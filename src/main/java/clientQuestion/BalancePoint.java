package clientQuestion;

public class BalancePoint {

    public static int findBalancePoint(int[] arr) {
        // Check if the array is empty or has less than 3 elements
        if (arr == null || arr.length < 3) {
            return -1; // No balance point possible
        }

        // Initialize left sum as 0
        int leftSum = 0;

        // Total sum of all elements
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Right sum is total sum minus the current element and left sum
            int rightSum = totalSum - leftSum - arr[i];

            // If left sum equals right sum, we found the balance point
            if (leftSum == rightSum) {
                return i;
            }

            // Update left sum by adding the current element
            leftSum += arr[i];
        }

        // If no balance point is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2,1};
        int balancePoint = findBalancePoint(arr);
        System.out.println(balancePoint); // Output should be 2
    }
}

