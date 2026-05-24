// Problem  : Graph Valid Tree
// Link     : https://leetcode.com/problems/graph-valid-tree/
// Difficulty: Medium
// Pattern  : Graph BFS
// Time     : O(V+E) | Space: O(V+E)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] i : edges) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1});
        visited[0] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i : graph.get(current[0])) {
                if (i == current[1]) continue;
                if (visited[i]) return false;
                queue.offer(new int[]{i, current[0]});
                visited[i] = true;
                count++;
            }
        }
        return n == count;
    }
}