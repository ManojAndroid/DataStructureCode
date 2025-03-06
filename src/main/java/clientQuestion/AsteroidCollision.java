package clientQuestion;

import java.util.Stack;

public class AsteroidCollision {
    //https://leetcode.com/problems/asteroid-collision/?envType=study-plan-v2&envId=leetcode-75
    //tc and sc O(n)
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int num : asteroids) {
            if (stack.isEmpty() || num > 0) {// add in stack if empty or positive
                stack.push(num);
            } else {
                // if num is -ve then peek and chek . if num is grt than peek() then pop bcd
                // will collide and destroyed the the peek
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(num)) {
                    stack.pop();
                }
                // if both are equal then both eill destroyed
                if (!stack.isEmpty() && stack.peek() == Math.abs(num)) {
                    stack.pop();
                } else {// if num is -ve and peek() is small then psh
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(num);
                    }

                }
            }
        }
        int[] ans = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[index--] = stack.pop();
        }
        return ans;

    }

    public static void main(String[] args) {
       /* Example 1:
        Input: asteroids = [5,10,-5]
        Output: [5,10]
        Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
        Example 2:
        Input: asteroids = [8,-8]
        Output: []
        Explanation: The 8 and -8 collide exploding each other.
        Example 3:
        Input: asteroids = [10,2,-5]
        Output: [10]
        Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.*/
    }
}
