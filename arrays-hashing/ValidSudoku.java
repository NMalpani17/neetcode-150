// Problem  : Valid Sudoku
// Link     : https://leetcode.com/problems/valid-sudoku/
// Difficulty: Medium
// Pattern  : Hashing
// Time     : O(1) | Space: O(1)

import java.util.HashSet;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                if (row[i].contains(board[i][j])) return false;
                row[i].add(board[i][j]);

                if (col[j].contains(board[i][j])) return false;
                col[j].add(board[i][j]);

                int b = (i / 3) * 3 + j / 3;
                if (box[b].contains(board[i][j])) return false;
                box[b].add(board[i][j]);
            }
        }
        return true;
    }
}