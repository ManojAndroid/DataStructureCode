package clientQuestion;

public class ContainerwithMostWater {
    //https://www.youtube.com/watch?v=KVU4JNNJkVg
    //https://leetcode.com/problems/container-with-most-water/
    public static int maxWaterContainer(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxWater = 0;
        while (left < right) {
            int w = right - left;// width
            int h = Math.min(height[left], height[right]);
            int area = w * h;
            maxWater = Math.max(maxWater, area);
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return maxWater;

    }

    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        //Output: 49
        System.out.println(maxWaterContainer(height));
    }
}
