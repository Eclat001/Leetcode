package Leetcode;

import Structure.TreeNode;

/* Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * For example: Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5      return 4.
 * */

public class univalueSubtree {
	int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        all(root, 0);
        return count;
    }
    boolean all(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        // | does not short-circuit the right operand and thus the counting will be on
        if (!all(root.left, root.val) | !all(root.right, root.val)) {
            return false;
        }
        count++;
        return root.val == val;
    }
}
