package clientQuestion;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        if (n < k)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);

        for (int num : nums) {
            if (pq.size() > k) {
                pq.poll();
            }
            pq.add(num);

        }
        return pq.poll();

    }

    public static void main(String[] args) {
        int [] arr={3,2,1,5,6,4};
        int result=findKthLargest(arr,2);
        System.out.println("findKthLargest "+result);
    }
}
