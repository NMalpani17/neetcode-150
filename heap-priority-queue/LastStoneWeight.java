// Problem  : Last Stone Weight
// Link     : https://leetcode.com/problems/last-stone-weight/
// Difficulty: Easy
// Pattern  : Heap / Priority Queue
// Time     : O(n log n) | Space: O(n)

import java.util.PriorityQueue;
import java.util.Queue;

class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) pq.offer(stone);
        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) pq.offer(a - b);
        }
        return pq.size() != 0 ? pq.peek() : 0;
    }
}