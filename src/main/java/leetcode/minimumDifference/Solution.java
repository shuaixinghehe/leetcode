package leetcode.minimumDifference;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[] {90}, 1));
        System.out.println(minimumDifference(new int[] {9,4,1,7}, 2));
    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        k = k - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i + k < nums.length) {
                res = Math.min(res, nums[i + k] - nums[i]);
            }
        }
        return res;
    }
}
