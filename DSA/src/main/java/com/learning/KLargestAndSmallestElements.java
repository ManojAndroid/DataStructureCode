package com.learning;

import java.util.PriorityQueue;

public class KLargestAndSmallestElements {
   /* Time Complexity: O(N * log(K))
    Auxiliary Space: O(K)*/
    public static void KLargest(int [] arr,int n, int k){
        PriorityQueue<Integer> queue= new PriorityQueue<>();
        for(int i=0;i<n;i++){
            queue.offer(arr[i]);
            if(queue.size()>k)
                queue.poll();
        }
        for(Integer data: queue) {
            System.out.print(data + ",");
        }
    }

    public static void KSmallest(int [] arr,int n, int k){
        PriorityQueue<Integer> queue= new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++){
            queue.offer(arr[i]);
            if(queue.size()>k)
                queue.poll();
        }
        for(Integer data: queue) {
            System.out.print(data + ",");
        }
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();

    }

    public static void main(String[] args) {
        int a[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
        int n = a.length;
        int k = 3;
        System.out.print(k + " largest elements are : ");
        // Function Call
        KLargest(a, n, k);

        System.out.print("   "+k + " Smallest elements are : ");
        // Function Call
        KSmallest(a, n, k);
    }
}
