package Leetcode;

/* Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 * Example 1: Input: 16 Returns: True
 * Example 2: Input: 14 Returns: False
 * */

public class validSquare {
	public static boolean isPerfectSquare(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }
	public static void main(String... args) {
		int n1 = 14;
		System.out.println(validSquare.isPerfectSquare(n1));
		int n2 = 16;
		System.out.println(validSquare.isPerfectSquare(n2));
		int n3 = Integer.MAX_VALUE;
		System.out.println(validSquare.isPerfectSquare(n3));
	}
}
