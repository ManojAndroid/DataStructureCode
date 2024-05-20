package clientQuestion;

import java.util.Stack;

public class RemoveStarFromString {
    //https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75
    public static String removeStars(String s) {
        String ans = "";
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return ans;
                }
            } else {
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        return ans;

    }
    public String removeStars2(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (char ch : s.toCharArray()) {
            if (ch == '*' && sb.length() > 0)
                sb.setLength(sb.length() - 1);// set length-1 means remove one cha
            else
                sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       String s = "leet**cod*e";
       String ans= removeStars(s);
        System.out.println("Result"+ ans);
    }
}
