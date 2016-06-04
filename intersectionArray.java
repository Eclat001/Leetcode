package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/* Given two arrays, write a function to compute their intersection.
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * */

public class intersectionArray {
	public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }
        System.out.println(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
	public static void main(String... args) {
		int[] n1 = {1, 2, 2, 1};
		int[] n2 = {2, 2};
		intersectionArray.intersection(n1, n2);
	}
}
