// Problem  : Sum of Two Integers
// Link     : https://leetcode.com/problems/sum-of-two-integers/
// Difficulty: Medium
// Pattern  : Bit Manipulation
// Time     : O(1) | Space: O(1)

class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}