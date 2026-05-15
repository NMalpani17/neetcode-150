// Problem  : Pacific Atlantic Water Flow
// Link     : https://leetcode.com/problems/pacific-atlantic-water-flow/
// Difficulty: Medium
// Pattern  : Graph BFS (Multi-source)
// Time     : O(m*n) | Space: O(m*n)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) { queue.offer(new int[]{i, 0}); pacific[i][0] = true; }
        for (int i = 0; i < n; i++) { queue.offer(new int[]{0, i}); pacific[0][i] = true; }
        bfs(heights, queue, dir, pacific, m, n);

        for (int i = 0; i < n; i++) { queue.offer(new int[]{m - 1, i}); atlantic[m - 1][i] = true; }
        for (int i = 0; i < m; i++) { queue.offer(new int[]{i, n - 1}); atlantic[i][n - 1] = true; }
        bfs(heights, queue, dir, atlantic, m, n);

        List<List<Integer>> coordinates = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) coordinates.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return coordinates;
    }

    public void bfs(int[][] heights, Queue<int[]> queue, int[][] dir, boolean[][] visited, int m, int n) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int nr = d[0] + cur[0], nc = d[1] + cur[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && heights[nr][nc] >= heights[cur[0]][cur[1]] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}