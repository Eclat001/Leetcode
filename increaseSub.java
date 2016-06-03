package Leetcode;

/* Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should: Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k] given 
 * 0 ² i < j < k ² n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * Examples: Given [1, 2, 3, 4, 5], return true.
 *           Given [5, 4, 3, 2, 1], return false.
 * */

public class increaseSub {
	//C1 = so far best candidate of end element of a one-cell subsequence to form a triplet subsequence
    //C2 = so far best candidate of end element of a two-cell subsequence to form a triplet subsequence
    public boolean increasingTriplet(int[] nums) {
        int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
        for (int c : nums) {
            if (c <= c1) {
                c1 = c;
            }
            else if (c <= c2) {
                c2 = c;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
