// Problem  : Merge Intervals
// Link     : https://leetcode.com/problems/merge-intervals/
// Difficulty: Medium
// Pattern  : Intervals
// Time     : O(n log n) | Space: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > prev[1]) {
                ans.add(prev);
                prev = intervals[i];
            } else {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
        }
        ans.add(prev);
        return ans.toArray(new int[0][]);
    }
}