// Problem  : Two Sum
// Link     : https://leetcode.com/problems/two-sum/
// Difficulty: Easy
// Pattern  : Hashing
// Time     : O(n) | Space: O(n)

import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = index.get(target - nums[i]);
                return ans;
            }
            index.put(nums[i], i);
        }
        return ans;
    }
}