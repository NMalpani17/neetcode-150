// Problem  : Subsets
// Link     : https://leetcode.com/problems/subsets/
// Difficulty: Medium
// Pattern  : Backtracking
// Time     : O(n * 2^n) | Space: O(n)

import java.util.ArrayList;
import java.util.List;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> path, int pivot) {
        ans.add(new ArrayList<>(path));
        for (int i = pivot; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, ans, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}