// Problem  : Kth Largest Element in an Array
// Link     : https://leetcode.com/problems/kth-largest-element-in-an-array/
// Difficulty: Medium
// Pattern  : Heap / Priority Queue
// Time     : O(n log k) | Space: O(k)

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}