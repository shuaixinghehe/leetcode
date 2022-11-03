package leetcode.lengthOfLIS;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS(new int[] {7, 7, 7, 7, 7, 7, 7}));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] sortedNums =
                Arrays.stream(nums).distinct().toArray();

        Arrays.sort(sortedNums);
        int[][] dp = new int[nums.length + 1][sortedNums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j < sortedNums.length + 1; j++) {
                if (nums[i - 1] == sortedNums[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
//        System.out.println("dp:");
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j] + ",");
//            }
//            System.out.println();
//        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
