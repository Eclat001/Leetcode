package Leetcode;

/* You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available.
 * You need to determine whether it is possible to measure exactly z litres using these two jugs. If z liters 
 * of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 * Operations allowed:
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 * Input: x = 3, y = 5, z = 4 Output: True
 * Example 2:
 * Input: x = 2, y = 6, z = 5 Output: False
 * */

public class waterAndJug {
	//there should be only TWO jugs
    //BŽzout's identity (also called BŽzout's lemma) is a theorem in the elementary theory of numbers: let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers x and y such that ax+by=d. In addition, the greatest common divisor d is the smallest positive integer that can be written as ax + by every integer of the form ax + by is a multiple of the greatest common divisor d.
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        return z % help(x, y) == 0;
    }
    private int help(int x, int y) {
        return y == 0 ? x : help(y, x % y);
    }
}
