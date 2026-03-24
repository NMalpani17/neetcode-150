// Problem  : Sliding Window Maximum
// Link     : https://leetcode.com/problems/sliding-window-maximum/
// Difficulty: Hard
// Pattern  : Sliding Window + Monotonic Deque
// Time     : O(n) | Space: O(k)

import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int j = 0; j < nums.length; j++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) dq.pollLast();
            dq.offerLast(j);
            int i = j - k + 1;
            if (dq.peekFirst() < i) dq.pollFirst();
            if (j >= k - 1) ans[idx++] = nums[dq.peekFirst()];
        }
        return ans;
    }
}