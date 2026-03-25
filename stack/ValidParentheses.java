// Problem  : Valid Parentheses
// Link     : https://leetcode.com/problems/valid-parentheses/
// Difficulty: Easy
// Pattern  : Stack
// Time     : O(n) | Space: O(n)

import java.util.HashMap;
import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> pair = new HashMap<>();
        pair.put('}', '{');
        pair.put(')', '(');
        pair.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != pair.get(c)) return false;
            }
        }
        return stack.isEmpty();
    }
}