// Problem  : Maximum Product Subarray
// Link     : https://leetcode.com/problems/maximum-product-subarray/
// Difficulty: Medium
// Pattern  : 1D Dynamic Programming
// Time     : O(n) | Space: O(1)

class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int product = nums[0], min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            max = temp;
            product = Math.max(product, max);
        }
        return product;
    }
}