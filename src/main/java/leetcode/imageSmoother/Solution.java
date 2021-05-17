package leetcode.imageSmoother;

/**
 * Created by luyan on 17/10/22.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] M = new int[][] { { 6, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        M = solution.imageSmoother(M);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Math.floor(1.9));
        System.out.println(Math.floor(0.4));
        System.out.println(Math.floor(0.2));
    }

    private boolean islegal(int i, int j, int[][] M) {
        if (i < 0 || i >= M.length || j < 0 || j >= M[0].length) {
            return false;
        }
        return true;
    }

    private int findAvg(int row, int line, int[][] M) {
        int cnt = 0;
        int sum = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = line - 1; j <= line + 1; j++) {
                if (islegal(i, j, M)) {
                    cnt++;
                    sum += M[i][j];
                }
            }
        }
        return (int) Math.floor(sum / cnt);
    }

    public int[][] imageSmoother(int[][] M) {
        if (M == null) return null;
        int[][] N = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                N[i][j] = findAvg(i, j, M);
            }
        }
        return N;
    }
}
