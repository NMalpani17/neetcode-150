// Problem  : Daily Temperatures
// Link     : https://leetcode.com/problems/daily-temperatures/
// Difficulty: Medium
// Pattern  : Monotonic Stack
// Time     : O(n) | Space: O(n)

import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                days[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return days;
    }
}