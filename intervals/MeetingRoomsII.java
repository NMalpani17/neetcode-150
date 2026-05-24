// Problem  : Meeting Rooms II
// Link     : https://leetcode.com/problems/meeting-rooms-ii/
// Difficulty: Medium
// Pattern  : Intervals + Heap
// Time     : O(n log n) | Space: O(n)

import java.util.Arrays;
import java.util.PriorityQueue;

class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && interval[0] >= pq.peek()) pq.poll();
            pq.offer(interval[1]);
        }
        return pq.size();
    }
}