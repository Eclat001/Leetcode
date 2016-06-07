package Leetcode;

/* Given an input string, reverse the string word by word. A word is defined as a sequence of non-space 
 * characters. The input string does not contain leading or trailing spaces and the words are always separated 
 * by a single space.
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 * */

public class reverseWordii {
	public void reverseWords(char[] s) {
        swap(s, 0, s.length - 1);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                swap(s, start, i - 1);
                start = i + 1;
            }
        }
        //reverse the last word, if there is only one word, this will solve the corner case
        swap(s, start, s.length - 1);
    }
    public void swap(char[] s, int l, int r) {
        while (l < r) {
            char c = s[l];
            s[l++] = s[r];
            s[r--] = c;
        }
    }
}
