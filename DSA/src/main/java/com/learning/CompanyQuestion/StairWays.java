package com.learning.CompanyQuestion;

public class StairWays {
    /* Time Complexity: O(n).
     Space Complexity: O(n).*/
    static void countStairUsingstep123(int dist) {
        int count[] = new int[dist + 1];
        count[0] = 1;
        if (dist >= 1)
            count[1] = 1;
        if (dist >= 2)
            count[2] = 2;//remove for 1,2,
        for (int i = 3; i <= dist; i++) {
            count[i] = count[i - 1] + count[i - 2] + count[i - 3];
            // result[i]=result[i-1]+result[i-2]; for two 1,2
        }
        System.out.println(count[dist]);
    }

    /*   Time Complexity : O(n)
       Space Complexity : O(1)*/
    static int printCountDP(int dist) {
        // Create the array of size 3.
        int[] ways = new int[3];
        int n = dist;
        // Initialize the bases cases
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        // Run a loop from 3 to n
        // Bottom up approach to fill the array
        for (int i = 3; i <= n; i++)
            ways[i % 3] = ways[(i - 1) % 3] + ways[(i - 2) % 3] + ways[(i - 3) % 3];

        return ways[n % 3];
    }

    public static void main(String[] args) {
        countStairUsingstep123(4);
    }
}
