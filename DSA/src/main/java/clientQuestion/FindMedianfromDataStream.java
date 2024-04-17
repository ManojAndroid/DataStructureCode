package clientQuestion;

import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;

    public FindMedianfromDataStream() {
        this.leftMaxHeap = new PriorityQueue<>((a, b) -> b - a);//Note to remember
        this.rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {////Note to remember
            leftMaxHeap.offer(num);
        } else {
            rightMinHeap.offer(num);
        }

        // Ensure balance between leftMaxHeap and rightMinHeap
        //Note to remember
        if (leftMaxHeap.size() - rightMinHeap.size() > 1) {
            rightMinHeap.offer(leftMaxHeap.poll());
        } else if (rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        int totalElementCount = leftMaxHeap.size() + rightMinHeap.size();
        if (totalElementCount % 2 == 0) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        } else {
            return leftMaxHeap.peek();
        }

    }
}
