package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Given a non-empty array of integers, return the k most frequent elements.
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note: 
 * You may assume k is always valid, 1 ² k ² number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * */

public class topK {
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fre = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i : nums) {
            if (fre.containsKey(i)) {
                fre.put(i, fre.get(i) + 1);
            }
            else {
                fre.put(i, 1);
            }
            max = Math.max(max, fre.get(i));
        }
        //here i is the frequency and bucket.get(i) is the numbers that having this frequency
        List<List<Integer>> bucket = new ArrayList<List<Integer>>(max);
        while (max-- >= 0) {
            bucket.add(new ArrayList<Integer>());
        }
        //loop over the entrySet is faster, because you don't query the map twice for each key. 
        for (Map.Entry<Integer, Integer> entry : fre.entrySet()) {
            int frequency = entry.getValue();
            bucket.get(frequency).add(entry.getKey());
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = bucket.size() - 1; i >= 0 && res.size() < k; i--) {
            res.addAll(bucket.get(i));
        }
        return res;
    }
}
