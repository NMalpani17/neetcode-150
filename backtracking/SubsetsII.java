// Problem  : Subsets II
// Link     : https://leetcode.com/problems/subsets-ii/
// Difficulty: Medium
// Pattern  : Backtracking
// Time     : O(n * 2^n) | Space: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> set = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, set, new ArrayList<>(), nums);
        return set;
    }

    public void helper(int pivot, List<List<Integer>> set, List<Integer> path, int[] nums) {
        set.add(new ArrayList<>(path));
        for (int i = pivot; i < nums.length; i++) {
            if (i > pivot && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            helper(i + 1, set, path, nums);
            path.remove(path.size() - 1);
        }
    }
}