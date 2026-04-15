// Problem  : Invert Binary Tree
// Link     : https://leetcode.com/problems/invert-binary-tree/
// Difficulty: Easy
// Pattern  : Tree DFS
// Time     : O(n) | Space: O(h)

class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}