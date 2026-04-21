// Problem  : Kth Largest Element in a Stream
// Link     : https://leetcode.com/problems/kth-largest-element-in-a-stream/
// Difficulty: Easy
// Pattern  : Heap / Priority Queue
// Time     : O(log k) per add | Space: O(k)

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {
    private Queue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}