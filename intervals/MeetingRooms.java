// Problem  : Meeting Rooms
// Link     : https://leetcode.com/problems/meeting-rooms/
// Difficulty: Easy
// Pattern  : Intervals
// Time     : O(n log n) | Space: O(1)

import java.util.Arrays;

class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) return false;
        }
        return true;
    }
}