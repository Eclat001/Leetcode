/*Given a positive integer n, find the least number of perfect square numbers 
 * (for example, 1, 4, 9, 16, ...) which sum to n. For example, given n = 12, return 3 
 * because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
	// Time O(n * sqrt(n))
    public static int numSquares(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            res[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                if (res[i + j * j] == 0 || res[i + j * j] > res[i] + 1) {
                    res[i + j * j] = res[i] + 1;
                }
            }
        }
        return res[n];
    }
    public static void main(String... args) {
    	int n = 12;
    	System.out.println(numSquares(n));
    	int m = 13;
    	System.out.println(numSquares(m));
    }
}
