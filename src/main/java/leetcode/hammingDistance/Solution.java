package leetcode.hammingDistance;

/**
 * Created by luyan on 17/1/18.
 */
public class Solution {

    public static void main(String[] args) {
        int x = 4;
        int y = 4;
        System.out.println(hammingDistance(x,y));
    }

    public static int hammingDistance(int x, int y) {
        int val = x ^ y;
        int count = 0;
        while (val > 0) {
            if ((val & 1) == 1) {
                count++;
            }
            val = val >> 1;
        }
        return count;
    }
}
