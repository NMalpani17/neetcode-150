// Problem  : Container With Most Water
// Link     : https://leetcode.com/problems/container-with-most-water/
// Difficulty: Medium
// Pattern  : Two Pointers
// Time     : O(n) | Space: O(1)

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int i = 0, j = height.length - 1;
        while (i <= j) {
            int currentMax = Math.min(height[i], height[j]) * (j - i);
            maxWater = Math.max(maxWater, currentMax);
            if (height[i] > height[j]) j--;
            else i++;
        }
        return maxWater;
    }
}