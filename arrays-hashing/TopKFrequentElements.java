// Problem  : Top K Frequent Elements
// Link     : https://leetcode.com/problems/top-k-frequent-elements/
// Difficulty: Medium
// Pattern  : Hashing + Heap
// Time     : O(n log k) | Space: O(n)

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> frequency = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> row : count.entrySet()) {
            frequency.offer(row);
            if (frequency.size() > k) frequency.poll();
        }
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = frequency.poll().getKey();
        }
        return ans;
    }
}