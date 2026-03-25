// Problem  : Min Stack
// Link     : https://leetcode.com/problems/min-stack/
// Difficulty: Medium
// Pattern  : Stack
// Time     : O(1) | Space: O(n)

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
        stack.push(val);
    }

    public void pop() {
        if (minStack.peek().equals(stack.pop())) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}