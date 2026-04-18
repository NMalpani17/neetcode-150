// Problem  : Count Good Nodes in Binary Tree
// Link     : https://leetcode.com/problems/count-good-nodes-in-binary-tree/
// Difficulty: Medium
// Pattern  : Tree DFS
// Time     : O(n) | Space: O(h)

class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) return 0;
        int curr = (root.val >= max) ? 1 : 0;
        if (root.val >= max) max = root.val;
        return curr + dfs(root.left, max) + dfs(root.right, max);
    }
}