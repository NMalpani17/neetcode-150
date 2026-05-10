// Problem  : Number of Islands
// Link     : https://leetcode.com/problems/number-of-islands/
// Difficulty: Medium
// Pattern  : Graph DFS
// Time     : O(m*n) | Space: O(m*n)

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, dir);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c, int[][] dir) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return;
        grid[r][c] = '0';
        for (int[] d : dir) dfs(grid, r + d[0], c + d[1], dir);
    }
}