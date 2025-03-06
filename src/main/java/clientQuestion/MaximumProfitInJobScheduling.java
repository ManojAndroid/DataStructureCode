package clientQuestion;

import java.util.Arrays;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
    //https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
    // tc O(nlogn) and sc O(n)
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];// create 2d and store start,end time ans profit
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);// sort based on endTime
        TreeMap<Integer, Integer> dpMap = new TreeMap<>();
        dpMap.put(0, 0);// base if job not started then profit will be 0

        for (int[] job : jobs) {
            int val = job[2] + dpMap.floorEntry(job[0]).getValue();// get prev floor value
            if (val > dpMap.lastEntry().getValue()) {// if val > than map las value then add in map
                dpMap.put(job[1], val);// put entime with value
            }
        }
        return dpMap.lastEntry().getValue();// return lastEntry value
    }

    public static void main(String[] args) {
        /*Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
        Output: 150
        Explanation: The subset chosen is the first, fourth and fifth job.
                Profit obtained 150 = 20 + 70 + 60.*/
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};
        int ans = jobScheduling(startTime, endTime, profit);
        System.out.println("Max Profit" + ans);

    }
}
