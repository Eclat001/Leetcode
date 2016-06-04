package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/* Given two arrays, write a function to compute their intersection.
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm? -- Two pointers
 * What if nums1's size is small compared to num2's size? Which algorithm is better?
 * 
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all 
 * elements into the memory at once? 
 * -- If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that 
 * fit into the memory, and record the intersections. 
 * If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort),
 * then read 2 elements from each array at a time in memory, record intersections.
}
 * */

public class intersectionArrayii {
	public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
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
		intersectionArrayii.intersect(n1, n2);
	}
}
