// Problem  : Product of Array Except Self
// Link     : https://leetcode.com/problems/product-of-array-except-self/
// Difficulty: Medium
// Pattern  : Prefix & Suffix Product
// Time     : O(n) | Space: O(1)

import java.util.Arrays;

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        Arrays.fill(leftProduct, 1);

        for (int i = 1; i < leftProduct.length; i++) {
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1];
        }

        int rightProduct = 1;
        for (int i = leftProduct.length - 2; i >= 0; i--) {
            rightProduct = nums[i + 1] * rightProduct;
            leftProduct[i] *= rightProduct;
        }

        return leftProduct;
    }
}