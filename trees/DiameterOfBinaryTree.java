// Problem  : Diameter of Binary Tree
// Link     : https://leetcode.com/problems/diameter-of-binary-tree/
// Difficulty: Easy
// Pattern  : Tree DFS
// Time     : O(n) | Space: O(h)

class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        diameter = Math.max(diameter, leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }
}