// Problem  : Number of Connected Components in an Undirected Graph
// Link     : https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
// Difficulty: Medium
// Pattern  : Graph BFS
// Time     : O(V+E) | Space: O(V+E)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] i : edges) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }

    public void bfs(List<List<Integer>> graph, int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int j : graph.get(current)) {
                if (!visited[j]) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}