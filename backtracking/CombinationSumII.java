// Problem  : Combination Sum II
// Link     : https://leetcode.com/problems/combination-sum-ii/
// Difficulty: Medium
// Pattern  : Backtracking
// Time     : O(2^n) | Space: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, combinations, new ArrayList<>());
        return combinations;
    }

    public void helper(int[] candidates, int target, int pivot, List<List<Integer>> combinations, List<Integer> path) {
        if (target == 0) {
            combinations.add(new ArrayList<>(path));
            return;
        }
        if (pivot == candidates.length || target < 0) return;
        for (int i = pivot; i < candidates.length; i++) {
            if (i > pivot && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, combinations, path);
            path.remove(path.size() - 1);
        }
    }
}