package Leetcode;

import Structure.TreeNode;

/* Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means 
 * subtree with largest number of nodes in it.
 * Note: A subtree must include all of its descendants.
 * Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
 * The Largest BST Subtree in this case is the highlighted one. 
 * The return value is the subtree's size, which is 3.
 * Hint: You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, 
 * which will result in O(nlogn) time complexity.
 * Follow up: Can you figure out ways to solve it with O(n) time complexity?
 * */

public class BSTSubtree {
	class Result {
        int size;
        int lower;
        int upper;
        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Result res = traverse(root);
        return Math.abs(res.size);
    }
    public Result traverse(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Result left = traverse(root.left);
        Result right = traverse(root.right);
        if (left.size < 0 || right.size < 0 || root.val < left.upper || root.val > right.lower) {
            return new Result(Math.max(Math.abs(left.size), Math.abs(right.size)) * -1, 0, 0);
        }
        else {
            return new Result(left.size + 1 + right.size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
        }
    }
}
