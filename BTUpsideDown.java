package Leetcode;

import Structure.TreeNode;

/* Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares 
 * the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes 
 * turned into left leaf nodes. Return the new root.
 * For example:
 * Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
 * */

public class BTUpsideDown {
	//Just think about how you can save the tree information you need before changing the tree structure.
    //left-subtree: node.left = node.parent.right=>node.parent.left = node.right, node.right = node.parent
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode next = null;
        TreeNode temp = null;
        while (cur != null) {
            next = cur.left;
            cur.left = temp;
            temp = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
