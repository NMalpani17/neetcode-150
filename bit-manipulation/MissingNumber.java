// Problem  : Missing Number
// Link     : https://leetcode.com/problems/missing-number/
// Difficulty: Easy
// Pattern  : Bit Manipulation (XOR)
// Time     : O(n) | Space: O(1)

class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i] ^ (i + 1);
        }
        return sum;
    }
}