// Problem  : Number of 1 Bits
// Link     : https://leetcode.com/problems/number-of-1-bits/
// Difficulty: Easy
// Pattern  : Bit Manipulation
// Time     : O(1) | Space: O(1)

class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) count++;
            n >>= 1;
        }
        return count;
    }
}