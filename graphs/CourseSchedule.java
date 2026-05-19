// Problem  : Course Schedule
// Link     : https://leetcode.com/problems/course-schedule/
// Difficulty: Medium
// Pattern  : Graph BFS (Topological Sort / Kahn's Algorithm)
// Time     : O(V+E) | Space: O(V+E)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] dependent = new int[numCourses];
        for (int[] i : prerequisites) {
            if (!map.containsKey(i[1])) map.put(i[1], new ArrayList<>());
            map.get(i[1]).add(i[0]);
            dependent[i[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (dependent[i] == 0) queue.offer(i);
        if (queue.isEmpty()) return false;
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            List<Integer> d = map.get(current);
            if (d == null) continue;
            for (int i : d) {
                dependent[i]--;
                if (dependent[i] == 0) queue.offer(i);
            }
        }
        return numCourses == count;
    }
}