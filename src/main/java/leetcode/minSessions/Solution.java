package leetcode.minSessions;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //        System.out.println(minSessions(new int[] {1, 2, 3}, 3));
        //        System.out.println(minSessions(new int[] {3, 1, 3, 1, 1}, 8));
        //        System.out.println(minSessions(new int[] {1, 2, 3, 4, 5}, 15));
        System.out.println(minSessions(new int[] {7, 4, 3, 8, 10}, 12));
    }

    public static int minSessions(int[] tasks, int sessionTime) {
        int res = 0;
        Arrays.sort(tasks);
        int[][] dp = new int[tasks.length + 1][sessionTime + 1];
        for (int i = 1; i < dp.length; i++) { // 商品
            for (int j = 1; j < dp[i].length; j++) { // 包的大小
                if (j - tasks[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - tasks[i - 1]] + tasks[i - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                }
            }
        }
        System.out.println("dp:");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }
        return res;
    }
}
