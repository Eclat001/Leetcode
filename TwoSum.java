package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Design and implement a TwoSum class. It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * */

public class TwoSum {
	//Using list, you access memory linearly. Basically, the entrySet is an iterator, you can't guarantee to access memory linearly, so the CPU cache doesn't work well.
    List<Integer> list = new ArrayList<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    list.add(number);
	    if (map.containsKey(number)) {
	        map.put(number, map.get(number) + 1);
	    }
	    else {
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < list.size(); i++) {
	        int num1 = list.get(i);
	        int num2 = value - num1;
	        if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) {
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
