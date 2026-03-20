// Problem  : Trapping Rain Water
// Link     : https://leetcode.com/problems/trapping-rain-water/
// Difficulty: Hard
// Pattern  : Two Pointers
// Time     : O(n) | Space: O(1)

class TrappingRainWater {
    public int trap(int[] height) {
        int sum = 0;
        int i = 0, j = height.length - 1;
        int leftMax = height[i];
        int rightMax = height[j];
        while (i <= j) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[i]);
                sum += leftMax - height[i];
                i++;
            } else {
                rightMax = Math.max(rightMax, height[j]);
                sum += rightMax - height[j];
                j--;
            }
        }
        return sum;
    }
}