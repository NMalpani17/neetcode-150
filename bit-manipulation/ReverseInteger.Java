// Problem  : Reverse Integer
// Link     : https://leetcode.com/problems/reverse-integer/
// Difficulty: Medium
// Pattern  : Math
// Time     : O(log x) | Space: O(1)

class ReverseInteger {
    public int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            int l = x % 10;
            x /= 10;
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && l > 7)) return 0;
            if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && l < -8)) return 0;
            sum = sum * 10 + l;
        }
        return sum;
    }
}