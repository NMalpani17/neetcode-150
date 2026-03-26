// Problem  : Evaluate Reverse Polish Notation
// Link     : https://leetcode.com/problems/evaluate-reverse-polish-notation/
// Difficulty: Medium
// Pattern  : Stack
// Time     : O(n) | Space: O(n)

import java.util.Stack;

class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+", "-", "*", "/" -> {
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();
                    stack.push(switch (token) {
                        case "+" -> operand1 + operand2;
                        case "-" -> operand1 - operand2;
                        case "/" -> operand1 / operand2;
                        case "*" -> operand1 * operand2;
                        default -> 0;
                    });
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}