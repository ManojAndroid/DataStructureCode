package clientQuestion;

import java.util.Arrays;

public class TaskSchedulerVVI {
    //https://leetcode.com/problems/task-scheduler/
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {// 1 count frequency
            freq[ch - 'A']++;// using 'A' bcz task is in upper case
        }
        Arrays.sort(freq);// 2. sort
        int maxFreq = freq[25] - 1;
        int ideaSpt = maxFreq * n;// 3.countIdealspot
        for (int i = 24; i >= 0; i--) {
            ideaSpt = ideaSpt - Math.min(maxFreq, freq[i]);// 5. decrement ideal spot
        }
        // if idealspot is -v then ans will tasks length else ans will task
        // length+remaining ideal spot
        return ideaSpt < 0 ? tasks.length : ideaSpt + tasks.length;
    }

    public static void main(String[] args) {
      /*  Example 1:
        Input: tasks = ["A","A","A","B","B","B"], n = 2
        Output: 8
        Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
        Input: tasks = ["A","A","A", "B","B","B"], n = 3
        Output: 10
        Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
          */
    }
}
