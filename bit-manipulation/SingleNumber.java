// Problem  : Single Number
// Link     : https://leetcode.com/problems/single-number/
// Difficulty: Easy
// Pattern  : Bit Manipulation (XOR)
// Time     : O(n) | Space: O(1)

class SingleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}