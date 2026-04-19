// Problem  : Construct Binary Tree from Preorder and Inorder Traversal
// Link     : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Difficulty: Medium
// Pattern  : Tree DFS + HashMap
// Time     : O(n) | Space: O(n)

import java.util.HashMap;

class ConstructBinaryTreeFromPreorderAndInorder {
    private int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(preorder, map, 0, preorder.length - 1);
    }

    public TreeNode build(int[] preorder, HashMap<Integer, Integer> map, int start, int end) {
        if (start > end) return null;
        int curr = preorder[idx++];
        TreeNode root = new TreeNode(curr);
        int index = map.get(curr);
        root.left = build(preorder, map, start, index - 1);
        root.right = build(preorder, map, index + 1, end);
        return root;
    }
}