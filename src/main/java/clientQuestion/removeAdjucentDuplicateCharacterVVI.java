package clientQuestion;

import java.util.Stack;

public class removeAdjucentDuplicateCharacterVVI {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && Character.toLowerCase(ch) == stack.peek()) {
                stack.pop();
            }else
            stack.push(Character.toLowerCase(ch));
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();

    }

    public static void main(String[] args) {
        String str="abbaca";
        String result=removeDuplicates(str);
        System.out.println(result);
    }
}
