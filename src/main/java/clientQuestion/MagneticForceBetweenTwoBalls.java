package clientQuestion;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    //https://leetcode.com/problems/magnetic-force-between-two-balls/description/
    //tc  O(nlogn).
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int start = 0;
        int end = position[n - 1];
        //int end = position[n - 1] - position[0];
        int maxDistance = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            //int mid = (start + end ) / 2;
            if (isValid(position, mid, m)) {
                maxDistance = Math.max(maxDistance, mid);
                start = mid + 1;
                //start = mid;
            } else {
                end = mid - 1;
                //end = mid;
            }
        }
        return maxDistance;

    }

    private static boolean isValid(int[] position, int distance, int m) {
        int balls = 1;
        int lastBallPosition = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastBallPosition >= distance) {
                balls++;
                lastBallPosition = position[i];
            }
        }
        return balls >= m;
    }

    public static void main(String[] args) {
       /* Input: position = [1,2,3,4,7], m = 3
        Output: 3
        Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
        Example 2:

        Input: position = [5,4,3,2,1,1000000000], m = 2
        Output: 999999999
        Explanation: We can use baskets 1 and 1000000000.*/
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println("Result :" + maxDistance(position, m));

        int[] position1 = {5,4,3,2,1,1000000000};
        int m1 = 2;
        System.out.println("Result1 : " + maxDistance(position1, m1));
    }
}
