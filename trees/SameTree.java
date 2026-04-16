// Problem  : Same Tree
// Link     : https://leetcode.com/problems/same-tree/
// Difficulty: Easy
// Pattern  : Tree DFS
// Time     : O(n) | Space: O(h)

class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}