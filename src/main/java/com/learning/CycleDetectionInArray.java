package com.learning;

public class CycleDetectionInArray {

    static int findCycleLength(int arr[]) {
        int slow = 0;
        int fast = 0;
        while (fast < arr.length && arr[fast] < arr.length) {
            slow = arr[slow];
            fast = arr[arr[fast]];
            if (slow == fast) {
                return findLength(arr, slow);
            }
        }
        return -1;
    }

    static int findLength(int arr[], int start) {
        int current = start;
        int count = 1;
        while (arr[current] != start) {
            current = arr[current];
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        int arr[] = {5,6,1, 2, 3,4,5,6, 1};
        System.out.println("result " + findCycleLength(arr));

    }
}
