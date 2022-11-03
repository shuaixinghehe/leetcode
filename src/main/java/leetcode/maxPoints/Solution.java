package leetcode.maxPoints;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][] {{1, 2, 3}, {1, 5, 1}, {3, 1, 1}}));
        System.out.println(maxPoints(new int[][] {{1, 5}, {2, 3}, {4, 2}}));
    }

    public static long maxPoints(int[][] points) {
        long[][] dp = new long[points.length][points[0].length];
        for (int i = 0; i < points[0].length; i++) {
            dp[0][i] = points[0][i];
        }
        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                for (int k = 0; k < points[i].length; k++) {
                    dp[i][j] = Math.max(dp[i][j], points[i][j] + dp[i - 1][k] - Math.abs(j - k));
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
//        System.out.println();
        long res = 0L;
        int lastRowIndex = points.length - 1;
        //        long maxValue = Long.MIN_VALUE;
        for (int i = 0; i < points[0].length; i++) {
            res = Math.max(res, dp[lastRowIndex][i]);
        }
        return res;
    }
}
