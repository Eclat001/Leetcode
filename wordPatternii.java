package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty 
 * substring in str.
 * Examples:
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * Notes: You may assume both pattern and str contains only lowercase letters.
 * */

public class wordPatternii {
	public static boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        return isMatch(str, 0, pattern, 0, map, set);
    }
    public static boolean isMatch(String str, int i, String pattern, int j, Map<Character, String> map, Set<String> set) {
        if (i == str.length() && j == pattern.length()) {
            return true;
        }
        if (i == str.length() || j == pattern.length()) {
            return false;
        }
        //get current pattern character
        char c = pattern.charAt(j);
        if (map.containsKey(c)) {
            String s = map.get(c);
            //check if we can use it to match str[i...i+s.length()]
            if (!str.startsWith(s, i)) {
                return false;
            }
            return isMatch(str, i + s.length(), pattern, j + 1, map, set);
        }
        for (int k = i; k < str.length(); k++) {
            String temp = str.substring(i, k + 1);
            if (set.contains(temp)) {
                continue;
            }
            map.put(c, temp);
            set.add(temp);
            if (isMatch(str, k + 1, pattern, j + 1, map, set)) {
                return true;
            }
            //backtracking
            map.remove(c);
            set.remove(temp);
        }
        return false;
    }
    public static void main(String... args) {
    	String str = "aaaaa";
    	String pattern = "abb";
    	System.out.println(wordPatternii.wordPatternMatch(pattern, str));
    }
}
