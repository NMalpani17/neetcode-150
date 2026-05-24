// Problem  : Non-overlapping Intervals
// Link     : https://leetcode.com/problems/non-overlapping-intervals/
// Difficulty: Medium
// Pattern  : Intervals + Greedy
// Time     : O(n log n) | Space: O(1)

import java.util.Arrays;

class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev[1]) count++;
            else prev = intervals[i];
        }
        return count;
    }
}