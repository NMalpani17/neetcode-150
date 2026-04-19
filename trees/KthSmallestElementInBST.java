// Problem  : Kth Smallest Element in a BST
// Link     : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// Difficulty: Medium
// Pattern  : Tree DFS (Inorder)
// Time     : O(n) | Space: O(h)

class KthSmallestElementInBST {
    private int count, result;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        count++;
        if (count == k) result = root.val;
        inorder(root.right, k);
    }
}