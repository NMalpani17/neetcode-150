// Problem  : Course Schedule II
// Link     : https://leetcode.com/problems/course-schedule-ii/
// Difficulty: Medium
// Pattern  : Graph BFS (Topological Sort / Kahn's Algorithm)
// Time     : O(V+E) | Space: O(V+E)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] dependent = new int[numCourses];
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] i : prerequisites) {
            graph.get(i[1]).add(i[0]);
            dependent[i[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (dependent[i] == 0) queue.offer(i);
        if (queue.isEmpty()) return new int[0];
        int idx = 0, count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[idx++] = current;
            count++;
            if (count == numCourses) return order;
            for (int m : graph.get(current)) {
                dependent[m]--;
                if (dependent[m] == 0) queue.offer(m);
            }
        }
        return new int[0];
    }
}