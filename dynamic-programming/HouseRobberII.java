// Problem  : House Robber II
// Link     : https://leetcode.com/problems/house-robber-ii/
// Difficulty: Medium
// Pattern  : 1D Dynamic Programming
// Time     : O(n) | Space: O(1)

class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(helper(0, n - 1, nums), helper(1, n, nums));
    }

    public int helper(int l, int r, int[] nums) {
        int curr = 0, prev = 0;
        for (int i = l; i < r; i++) {
            int temp = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}