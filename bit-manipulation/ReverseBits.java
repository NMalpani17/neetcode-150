// Problem  : Reverse Bits
// Link     : https://leetcode.com/problems/reverse-bits/
// Difficulty: Easy
// Pattern  : Bit Manipulation
// Time     : O(1) | Space: O(1)

class ReverseBits {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            rev |= (n & 1);
            n >>>= 1;
        }
        return rev;
    }
}