package clientQuestion;

import java.util.Stack;

public class RedundantBraces {
    public static boolean hasRedundantBraces(String str) {

        if (str.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == ')') {
                char top = stack.pop();
                boolean isValid = false;
                while (top != '(') {
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        isValid = true;
                    }
                    top = stack.pop();
                }
                if (!isValid) {
                    return true;
                }

            }
            stack.push(ch);
        }
        return false;
    }
    public static void main(String[] args) {
        String expression1 = "((a + b) + (c + d))";
        String expression2 = "(a + b) + ((c + d))";

        System.out.println(hasRedundantBraces(expression1)); // Output: false
        System.out.println(hasRedundantBraces(expression2)); // Output: true
    }
}
