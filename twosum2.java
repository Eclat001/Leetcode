package Leetcode;
import java.util.Arrays;


public class twosum2 {
    public static int[] twosum(int[] A, int target){
    	int l = 0;
    	int r = A.length - 1;
    	int[] res = new int[2];
    	while (l < r){
    		int sum = A[l] + A[r];
    		if (sum == target){
    			res[0] = l + 1;
    			res[1] = r + 1;
    			return res;
    		}
    		else if (sum < target){
    			l++;
    		}
    		else{
    			r--;
    		}
    	}
    	res[0] = -1;
    	res[1] = -1;
    	return res;
    }
    public static void main(String[] args){
    	int[] A = {1, 2, 3, 5, 7, 8};
    	int target = 20;
    	System.out.print(Arrays.toString(twosum(A, target)));
    }
}
