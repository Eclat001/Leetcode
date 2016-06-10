package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid 
 * of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using 
 * Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * For example, given three people living at (0,0), (0,4), and (2,2):
1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 * Hint: Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 * */

public class bestMeetPoint {
	public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> I = new ArrayList<Integer>(m);
        List<Integer> J = new ArrayList<Integer>(n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                    J.add(j);
                }
            }
        }
        Collections.sort(J);    //I is already in sort order
        return getMin(I) + getMin(J);
    }
    public int getMin(List<Integer> list) {
        int res = 0;
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            res += list.get(r--) - list.get(l++);    //the min distance is to get the median point
        }
        return res;
    }
}
