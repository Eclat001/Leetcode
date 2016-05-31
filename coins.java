package Leetcode;

import java.util.Arrays;

/* You are given coins of different denominations and a total amount of money amount. Write a function to 
 * compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be 
 * made up by any combination of the coins, return -1.
 * Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 * Example 2: coins = [2], amount = 3 return -1.
 * Note: You may assume that you have an infinite number of each kind of coin.
 * */

public class coins {
	//Time O(S*n)
	public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        int sum = 0;
        //Early pruning is a nice idea if coins are spread out in a relatively large range. For example, if coins=[99, 50, 11, 4, 1], sorting does save some work when amount-sum becomes less than 100.
        Arrays.sort(coins);
        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum < coin) {
                    break;
                }
                if (dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }
	public static void main(String... args) {
		int[] c1 = {1, 2, 5};
		int s1 = 11;
		int[] c2 = {2};
		int s2 = 3;
		System.out.println(coins.coinChange(c1, s1));
		System.out.println(coins.coinChange(c2, s2));
	}
}
