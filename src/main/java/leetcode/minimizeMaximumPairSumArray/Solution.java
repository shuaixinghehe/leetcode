package leetcode.minimizeMaximumPairSumArray;

import java.util.Arrays;

import com.sun.xml.internal.xsom.XSUnionSimpleType;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minPairSum(new int[] {3,5,2,3}));
        System.out.println(minPairSum(new int[] {3,5,4,2,4,6}));
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int minPairSum = nums[start] + nums[end];
        while (start < end) {
            minPairSum = Math.max(minPairSum, nums[start] + nums[end]);
            start++;
            end--;
        }
        return minPairSum;
    }
}
