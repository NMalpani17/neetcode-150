// Problem  : Climbing Stairs
// Link     : https://leetcode.com/problems/climbing-stairs/
// Difficulty: Easy
// Pattern  : 1D Dynamic Programming
// Time     : O(n) | Space: O(1)

class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }
}