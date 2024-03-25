package clientQuestion;

import java.util.Arrays;

public class WoodCuttingHeight {

    public static  int findCuttingHeight(int [] heights,int k){
        int n=heights.length;
        //Arrays.sort() generally uses a modified merge sort algorithm known as TimSort.
        //T O(logn) using binary search;
        int maxHeight = 0;
        for (int height : heights) {
            maxHeight = Math.max(maxHeight, height);
        }

        int left = 0;
        int right = maxHeight;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int woodCollected = getWoodCollected(heights, mid);

            if (woodCollected >= k) {
                result = mid;
                left = mid + 1; // Search for higher cutting height
            } else {
                right = mid - 1; // Search for lower cutting height
            }
        }

        return result;
    }
    private static int getWoodCollected(int[] heights, int cuttingHeight) {
        int woodCollected = 0;
        for (int height : heights) {
            woodCollected += Math.max(0, height - cuttingHeight);
        }
        return woodCollected;
    }

    public static void main(String[] args) {
        int[] heights = {7, 4, 9, 2, 1, 8};
        int k = 3;
        int cuttingHeight = findCuttingHeight(heights, k);
        if (cuttingHeight != -1) {
            System.out.println("Height for collecting " + k + " wood: " + cuttingHeight); // Output: 7
        } else {
            System.out.println("No height found");
        }
    }
}
