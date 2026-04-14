// Problem  : Counting Bits
// Link     : https://leetcode.com/problems/counting-bits/
// Difficulty: Easy
// Pattern  : Bit Manipulation + DP
// Time     : O(n) | Space: O(n)

class CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}