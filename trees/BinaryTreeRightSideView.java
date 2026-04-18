// Problem  : Binary Tree Right Side View
// Link     : https://leetcode.com/problems/binary-tree-right-side-view/
// Difficulty: Medium
// Pattern  : Tree BFS
// Time     : O(n) | Space: O(n)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        if (root == null) return rightSide;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                if (i == size - 1) rightSide.add(current.val);
            }
        }
        return rightSide;
    }
}