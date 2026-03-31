// Problem  : Search a 2D Matrix
// Link     : https://leetcode.com/problems/search-a-2d-matrix/
// Difficulty: Medium
// Pattern  : Binary Search
// Time     : O(log m*n) | Space: O(1)

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = m * n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (matrix[mid / n][mid % n] == target) return true;
            else if (matrix[mid / n][mid % n] > target) j = mid - 1;
            else i = mid + 1;
        }
        return false;
    }
}