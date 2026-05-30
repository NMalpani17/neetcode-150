// Problem  : Palindromic Substrings
// Link     : https://leetcode.com/problems/palindromic-substrings/
// Difficulty: Medium
// Pattern  : 1D Dynamic Programming
// Time     : O(n²) | Space: O(n²)

class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length(), count = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j <= 2 || dp[i - 1][j + 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}