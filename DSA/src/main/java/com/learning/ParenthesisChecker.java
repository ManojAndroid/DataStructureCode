package com.learning;

import java.util.Stack;

public class ParenthesisChecker {
    static boolean ispar(String a)
    {
        Stack<Character> stack
                = new Stack<>();

        // Traversing the Expression
        for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check != '(')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check != '{')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check != '[')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
       // ParenthesisChecker.ispar();
    }
}
