package clientQuestion;

public class CapacityToShipPackagesWithinDDays {
    //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    // tc=O(nlogD),D= days
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int val : weights) {
            high = high + val;
            low = Math.max(low, val);
        }
        int ans = 0;
        while (low <= high) {
            int currentWight = low + (high - low) / 2;
            if (isPossible(weights, currentWight, days)) {
                ans = currentWight;
                high = currentWight - 1;
            } else {
                low = currentWight + 1;
            }
        }
        return ans;

    }

    private boolean isPossible(int[] weights, int currentWight, int days) {
        int d = 1;
        int sum = 0;
        for (int val : weights) {
            sum += val;
            if (sum > currentWight) {
                d++;
                sum = val;
            }
        }
        return d <= days;
    }

    public static void main(String[] args) {
      /*  Example 1:

        Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
        Output: 15
        Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
        1st day: 1, 2, 3, 4, 5
        2nd day: 6, 7
        3rd day: 8
        4th day: 9
        5th day: 10*/

    }
}
