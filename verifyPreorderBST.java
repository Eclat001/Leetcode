package Leetcode;

/* Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search 
 * tree. You may assume each number in the sequence is unique.
 * Follow up: Could you do it using only constant space complexity?
 * */

public class verifyPreorderBST {
	//abusing the given array for the stack
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        int i = -1;
        for (int p : preorder) {
            if (p < low) {
                return false;
            }
            while (i >= 0 && p > preorder[i]) {
                low = preorder[i--];
            }
            preorder[++i] = p;
        }
        return true;
    }
}
