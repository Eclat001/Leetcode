package Leetcode;

/* There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second 
 * bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). 
 * For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many 
 * bulbs are on after n rounds.
 * Example:
 * Given n = 3. 
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off]. 
 * So you should return 1, because there is only one bulb is on.
 * 
 * 前10盏灯泡的开闭过程如下所示：
0 0 0 0 0 0 0 0 0 0    0
1 1 1 1 1 1 1 1 1 1    1
1 0 1 0 1 0 1 0 1 0    2
1 0 0 0 1 1 1 0 0 0    3
1 0 0 1 1 1 1 1 0 0    4
1 0 0 1 0 1 1 1 0 1    5
1 0 0 1 0 0 1 1 0 1    6
1 0 0 1 0 0 0 1 0 1    7
1 0 0 1 0 0 0 0 0 1    8
1 0 0 1 0 0 0 0 1 1    9
1 0 0 1 0 0 0 0 1 0    10
 * */

public class bulbSwitcher {
	//对于第i盏灯泡，当i的因子个数为奇数时，最终会保持点亮状态，例如9的因子为1，3，9
    //而当i的因子个数为偶数时，最终会保持熄灭状态，例如8的因子为：1，2，4，8
    //当且仅当i为完全平方数时，其因子个数为奇数--除了完全平方数，其余数字的因子都是成对出现的，而完全平方数的平方根只会统计一次。
    public static int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
    public static void main(String... args) {
    	System.out.println(bulbSwitcher.bulbSwitch(10));
    }
}
