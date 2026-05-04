// Problem  : Word Search
// Link     : https://leetcode.com/problems/word-search/
// Difficulty: Medium
// Pattern  : Backtracking
// Time     : O(m * n * 4^L) | Space: O(L)

class WordSearch {
    boolean flag = false;

    public boolean exist(char[][] board, String word) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, dir, word, i, j, visited, 0);
            }
        }
        return flag;
    }

    public void helper(char[][] board, int[][] dir, String word, int row, int col, boolean[][] visited, int idx) {
        if (idx == word.length()) { flag = true; return; }
        if (flag) return;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(idx)) return;
        visited[row][col] = true;
        for (int[] d : dir) helper(board, dir, word, row + d[0], col + d[1], visited, idx + 1);
        visited[row][col] = false;
    }
}