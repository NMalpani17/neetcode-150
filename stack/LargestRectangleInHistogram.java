// Problem  : Largest Rectangle in Histogram
// Link     : https://leetcode.com/problems/largest-rectangle-in-histogram/
// Difficulty: Hard
// Pattern  : Monotonic Stack
// Time     : O(n) | Space: O(n)

import java.util.Stack;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) return heights[0];
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                int bar = heights[stack.pop()];
                int leftMin = stack.isEmpty() ? -1 : stack.peek();
                int currArea = bar * (i - leftMin - 1);
                area = Math.max(currArea, area);
            }
            stack.push(i);
        }
        return area;
    }
}