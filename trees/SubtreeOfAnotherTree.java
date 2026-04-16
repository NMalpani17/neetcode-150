// Problem  : Subtree of Another Tree
// Link     : https://leetcode.com/problems/subtree-of-another-tree/
// Difficulty: Easy
// Pattern  : Tree DFS
// Time     : O(m*n) | Space: O(h)

class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}