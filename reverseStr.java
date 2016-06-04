package Leetcode;

/* Write a function that takes a string as input and returns the string reversed.
 * Example: Given s = "hello", return "olleh".
 * */

public class reverseStr {
	public String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] word = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char temp = word[l];
            word[l++] = word[r];
            word[r--] = temp;
        }
        return new String(word);
    }
}
