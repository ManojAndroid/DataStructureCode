package com.learning;

import java.util.PriorityQueue;

public class ConnectnRopesWithMinimumCost {

    /*Time Complexity: O(n log n)
    Space Complexity: O(n)*/
    static long findMinCost(long  rope[], int n){
        if(rope==null|| rope.length==0){
            return 0;
        }
        PriorityQueue<Long> priorityQueue=new PriorityQueue<>();
        for(long value:rope){
            priorityQueue.add(value);
        }
        long cost=0;
        while(priorityQueue.size()>1){
            long a=priorityQueue.poll();
            long b=priorityQueue.poll();
            long currentCost=a+b;
            cost+=currentCost;
            priorityQueue.add(currentCost);
        }
        return cost;
    }

    public static void main(String[] args) {
        long[] rope={4,3,2,6};
        System.out.println(findMinCost(rope,rope.length));
    }
}
