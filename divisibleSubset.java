package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements 
 * in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 * Example 1: nums: [1,2,3] Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2: nums: [1,2,4,8] Result: [1,2,4,8]
 * */

public class divisibleSubset {
	//dp[j] = max(dp[j], dp[i] + 1)  其中： 0 <= i < j 且 nums[j] % nums[i] == 0
    //返回结果利用辅助数组pre记录  O(N^2) time, O(N) space
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null) {
            return res;
        }
        if (nums.length < 2) {
            for (int n : nums) {
                res.add(n);
            }
            return res;
        }
        Arrays.sort(nums);
        int[] parent = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 0, index = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && count[i] < 1 + count[j]) {
                    count[i] = count[j] + 1;
                    parent[i] = j;
                    if (count[i] > max) {
                        max = count[i];
                        index = i;
                    }
                }
            }
        }
        for (int i = 0; i < max; i++) {
            res.add(nums[index]);
            index = parent[index];
        }
        return res;
    }
}
