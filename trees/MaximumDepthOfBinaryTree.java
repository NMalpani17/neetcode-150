// Problem  : Maximum Depth of Binary Tree
// Link     : https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Difficulty: Easy
// Pattern  : Tree DFS
// Time     : O(n) | Space: O(h)

class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}