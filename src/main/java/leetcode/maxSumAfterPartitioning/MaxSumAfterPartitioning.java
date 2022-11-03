package leetcode.maxSumAfterPartitioning;

public class MaxSumAfterPartitioning {
    public static void main(String[] args) {
        //        int[] arr = new int[] {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        //        Arrays.sort(arr);
        //        for (int i = 0; i < arr.length; i++) {
        //            System.out.print(arr[i] + ",");
        //        }
        int[] arr = new int[] {1, 4, 1, 5};
        System.out.println(maxSumAfterPartitioning(arr, 3));
    }

    //    public static int maxSumAfterPartitioning(int[] A, int K) {
    //        int[][] dp = new int[A.length][A.length];
    //        for (int i = 0; i < A.length; i++) {
    //            dp[i][i] = A[i];
    //        }
    //        System.out.println("dp");
    //        for (int i = 0; i < dp.length; i++) {
    //            for (int j = 0; j < dp[0].length; j++) {
    //                System.out.print(dp[i][j] + ",");
    //            }
    //            System.out.println();
    //        }
    //        System.out.println();
    //        System.out.println("------------");
    //        System.out.println();
    //        System.out.println("dp");
    //        // dp[i][j] 表示 i 到 j 的最大值
    //        for (int i = 0; i < dp.length; i++) {
    //            for (int j = i + 1; j < dp[0].length; j++) {
    //                dp[i][j] = Math.max(dp[i][j - 1], A[j]);
    //            }
    //        }
    //        System.out.println("dp");
    //        for (int i = 0; i < dp.length; i++) {
    //            for (int j = 0; j < dp[0].length; j++) {
    //                System.out.print(dp[i][j] + ",");
    //            }
    //            System.out.println();
    //        }
    //        System.out.println();
    //        System.out.println("------------");
    //        return 0;
    //    }


    public static int maxSumAfterPartitioning(int[] A, int K) {
        System.out.println("origin");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ",");
        }
        System.out.println();
        int N = A.length, dp[] = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            int curMax = 0, best = 0;
            for (int k = 1; k <= K && i - k >= 0; ++k) {
                curMax = Math.max(curMax, A[i - k]);
                best = Math.max(best, dp[i - k] + curMax * k);
            }
            System.out.println("i:" + i + " best:" + best);
            dp[i] = best;
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[j] + ",");
            }
            System.out.println();
            System.out.println();
        }

        return dp[N];
    }
}
