// Problem  : Longest Consecutive Sequence
// Link     : https://leetcode.com/problems/longest-consecutive-sequence/
// Difficulty: Medium
// Pattern  : Hashing
// Time     : O(n) | Space: O(n)

import java.util.HashSet;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> consecutive = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            consecutive.add(num);
        }
        for (int num : consecutive) {
            if (!consecutive.contains(num - 1)) {
                int count = 1;
                while (consecutive.contains(++num)) {
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}