// Problem  : Combination Sum
// Link     : https://leetcode.com/problems/combination-sum/
// Difficulty: Medium
// Pattern  : Backtracking
// Time     : O(2^t) | Space: O(t)

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> paths = new ArrayList<>();
        helper(candidates, target, 0, paths, new ArrayList<>());
        return paths;
    }

    public void helper(int[] candidates, int target, int idx, List<List<Integer>> paths, List<Integer> currentPath) {
        if (target < 0 || idx == candidates.length) return;
        if (target == 0) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            currentPath.add(candidates[i]);
            helper(candidates, target - candidates[i], i, paths, currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}