// Problem  : Happy Number
// Link     : https://leetcode.com/problems/happy-number/
// Difficulty: Easy
// Pattern  : Math / HashSet
// Time     : O(log n) | Space: O(log n)

import java.util.HashSet;

class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
        return true;
    }
}