// Problem  : Walls and Gates
// Link     : https://leetcode.com/problems/walls-and-gates/
// Difficulty: Medium
// Pattern  : Graph BFS (Multi-source)
// Time     : O(m*n) | Space: O(m*n)

import java.util.LinkedList;
import java.util.Queue;

class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] d : dir) {
                int nr = d[0] + current[0];
                int nc = d[1] + current[1];
                if (nr >= 0 && nr < rooms.length && nc >= 0 && nc < rooms[0].length && rooms[nr][nc] == Integer.MAX_VALUE) {
                    rooms[nr][nc] = rooms[current[0]][current[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}