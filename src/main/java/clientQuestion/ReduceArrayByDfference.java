package clientQuestion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ReduceArrayByDfference {
    /* You are given a list of integers. You need to perform an operation on this array
 * which will remove 2 max elements and add the difference back to the list.
             * Find the last element which will remain.
             Example:
             [5,6,15,12] => [5,6,3] => [1,3] => [2]
     ans = 2*/
    public static int[] findLastRemainingElement(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return new int[]{};
        if (n == 1)
            return arr;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : arr) {
            pq.add(num);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int diff = a - b;
            pq.add(diff);
        }
        return new int[]{!pq.isEmpty() ? pq.poll() : 0};
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 15, 12};
        System.out.println("Result : "+ Arrays.toString(findLastRemainingElement(arr)));
    }
}
