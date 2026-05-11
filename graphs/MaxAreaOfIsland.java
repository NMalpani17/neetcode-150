// Problem  : Max Area of Island
// Link     : https://leetcode.com/problems/max-area-of-island/
// Difficulty: Medium
// Pattern  : Graph DFS
// Time     : O(m*n) | Space: O(m*n)

class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) area = Math.max(area, dfs(grid, i, j, dir));
            }
        }
        return area;
    }

    public int dfs(int[][] grid, int r, int c, int[][] dir) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        int count = 1;
        for (int[] d : dir) count += dfs(grid, r + d[0], c + d[1], dir);
        return count;
    }
}