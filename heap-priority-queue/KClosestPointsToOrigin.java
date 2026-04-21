// Problem  : K Closest Points to Origin
// Link     : https://leetcode.com/problems/k-closest-points-to-origin/
// Difficulty: Medium
// Pattern  : Heap / Priority Queue
// Time     : O(n log k) | Space: O(k)

import java.util.PriorityQueue;
import java.util.Queue;

class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            int disA = a[0] * a[0] + a[1] * a[1];
            int disB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(disB, disA);
        });
        for (int[] point : points) {
            queue.offer(point);
            if (queue.size() > k) queue.poll();
        }
        int[][] ans = new int[k][2];
        int j = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            ans[j][0] = curr[0];
            ans[j][1] = curr[1];
            j++;
        }
        return ans;
    }
}