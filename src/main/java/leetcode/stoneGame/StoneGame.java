package leetcode.stoneGame;

public class StoneGame {
    public static void main(String[] args) {
        System.out.println(stoneGame(new int[] {5, 3, 4, 5}));
    }

    //    dp[i][j] means the biggest number of stones you can get
    //    more than opponent picking piles in piles[i] ~ piles[j].
    //    You can first pick piles[i] or piles[j].
    //
    //    If you pick piles[i], your result will be piles[i] - dp[i + 1][j]
    //    If you pick piles[j], your result will be piles[j] - dp[i][j - 1]
    //    So we get:
    //    dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
    //    We start from smaller subarray and then we use that to calculate bigger subarray.

    public static boolean stoneGame(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = p[i];
        }
        System.out.println("init dp:");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("---");
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("(i:" + i + " j:" + j + "),");
                System.out.println("dp[j][j + i]:dp[" + j + "][" + (j + i) + "]");
                dp[j][j + i] = Math.max(p[j] - dp[j + 1][j + i], p[j + i] - dp[j][j + i - 1]);
            }
            System.out.println("dp: i:" + i);
            for (int k = 0; k < dp.length; k++) {
                for (int l = 0; l < dp[0].length; l++) {
                    System.out.print(dp[k][l] + ",");
                }
                System.out.println();
            }
            System.out.println("---");
        }
        return dp[0][n - 1] > 0;
    }
}
