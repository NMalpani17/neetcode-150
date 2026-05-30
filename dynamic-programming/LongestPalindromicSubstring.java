// Problem  : Longest Palindromic Substring
// Link     : https://leetcode.com/problems/longest-palindromic-substring/
// Difficulty: Medium
// Pattern  : 1D Dynamic Programming / Expand Around Center
// Time     : O(n²) | Space: O(1)

class LongestPalindromicSubstring {
    int start, end;

    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            expand(s, i, i);
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) expand(s, i, i + 1);
        }
        return s.substring(start, end + 1);
    }

    public void expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) { i--; j++; }
        i++; j--;
        if (j - i > end - start) { start = i; end = j; }
    }
}