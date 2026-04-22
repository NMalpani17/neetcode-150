// Problem  : Task Scheduler
// Link     : https://leetcode.com/problems/task-scheduler/
// Difficulty: Medium
// Pattern  : Heap / Priority Queue + Greedy
// Time     : O(n) | Space: O(1)

import java.util.Arrays;

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) count[task - 'A']++;
        Arrays.sort(count);
        int charCount = count[25];
        int maxCharCount = 0;
        for (int current : count) {
            if (current == charCount) maxCharCount++;
        }
        return Math.max(tasks.length, (charCount - 1) * (n + 1) + maxCharCount);
    }
}