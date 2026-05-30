// Problem  : Decode Ways
// Link     : https://leetcode.com/problems/decode-ways/
// Difficulty: Medium
// Pattern  : 1D Dynamic Programming
// Time     : O(n) | Space: O(n)

class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int prevf = Integer.valueOf(s.substring(i - 1, i));
            int prevs = Integer.valueOf(s.substring(i - 2, i));
            if (prevf >= 1 && prevf <= 9) dp[i] += dp[i - 1];
            if (prevs >= 10 && prevs <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}