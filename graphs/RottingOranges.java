// Problem  : Rotting Oranges
// Link     : https://leetcode.com/problems/rotting-oranges/
// Difficulty: Medium
// Pattern  : Graph BFS (Multi-source)
// Time     : O(m*n) | Space: O(m*n)

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }
        if (fresh == 0) return 0;
        int time = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] d : dir) {
                    int nr = current[0] + d[0], nc = current[1] + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
            if (fresh == 0) return time;
        }
        return -1;
    }
}