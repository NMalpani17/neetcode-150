// Problem  : Palindrome Partitioning
// Link     : https://leetcode.com/problems/palindrome-partitioning/
// Difficulty: Medium
// Pattern  : Backtracking
// Time     : O(n * 2^n) | Space: O(n)

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> combination = new ArrayList<>();
        helper(s, combination, new ArrayList<>(), 0);
        return combination;
    }

    public void helper(String s, List<List<String>> combination, List<String> path, int pivot) {
        if (pivot == s.length()) {
            combination.add(new ArrayList<>(path));
            return;
        }
        for (int i = pivot; i < s.length(); i++) {
            String current = s.substring(pivot, i + 1);
            if (!isPalindrome(current)) continue;
            path.add(current);
            helper(s, combination, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}