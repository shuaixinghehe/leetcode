package leetcode.longestObstacleCourseAtEachPosition;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestObstacleCourseAtEachPosition(new int[] {3, 1, 5, 6, 4, 2}));

    }

    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] res = new int[obstacles.length];
        int[] sortedArr = Arrays.copyOf(obstacles, obstacles.length);
        Arrays.sort(sortedArr);

        System.out.println();
        lcs(obstacles, sortedArr);
        System.out.println();
        return res;
    }

    public static int[][] lcs(int[] originArr, int[] sortArr) {
        System.out.println("soredArr:");
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + ",");
        }
        System.out.println();
        System.out.println("originArr:");
        for (int i = 0; i < originArr.length; i++) {
            System.out.print(originArr[i] + ",");
        }
        System.out.println();
        int[][] dp = new int[originArr.length + 1][sortArr.length + 1];
        for (int i = 1; i <= originArr.length; i++) {
            int end = originArr[i - 1];
            for (int j = i; j <= sortArr.length; j++) {
                if (sortArr[j - 1] == originArr[i - 1] && sortArr[j - 1] <= end) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
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
        System.out.println();
        return null;
    }

}
