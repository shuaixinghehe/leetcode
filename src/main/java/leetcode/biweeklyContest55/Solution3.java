package leetcode.biweeklyContest55;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(maxAlternatingSum(new int[] {4, 2, 5, 3}));
        System.out.println(maxAlternatingSum(new int[] {5, 6, 7, 8}));
        System.out.println(maxAlternatingSum(new int[] {6, 2, 1, 2, 4, 5}));
    }

    public static long maxAlternatingSum(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < dp[i].length; j++) {
                dp[i][j] = nums[j] - nums[i];
            }
        }
        System.out.println("dp");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }
        int value = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            value = Math.max(value, dp[i][i]);
            for (int j = i + 2; j < dp[0].length; j++) {
                value = Math.max(value, dp[i][i] + dp[i + 1][j]);
            }
        }

        return value;
    }
}
