// Problem  : Permutations
// Link     : https://leetcode.com/problems/permutations/
// Difficulty: Medium
// Pattern  : Backtracking
// Time     : O(n * n!) | Space: O(n)

import java.util.ArrayList;
import java.util.List;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutation = new ArrayList<>();
        List<Integer> remaining = new ArrayList<>();
        for (int i : nums) remaining.add(i);
        helper(permutation, new ArrayList<>(), remaining);
        return permutation;
    }

    private void helper(List<List<Integer>> permutation, List<Integer> path, List<Integer> remaining) {
        if (remaining.isEmpty()) {
            permutation.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < remaining.size(); i++) {
            path.add(remaining.get(i));
            remaining.remove(i);
            helper(permutation, path, remaining);
            remaining.add(i, path.remove(path.size() - 1));
        }
    }
}