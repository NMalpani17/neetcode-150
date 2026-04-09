// Problem  : Find the Duplicate Number
// Link     : https://leetcode.com/problems/find-the-duplicate-number/
// Difficulty: Medium
// Pattern  : Fast & Slow Pointers (Floyd's Cycle Detection)
// Time     : O(n) | Space: O(1)

class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}