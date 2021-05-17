package leetcode.IslandPerimeter;

/**
 * Created by luyan on 17/1/18.
 */
public class Solution {

    public static void main(String[] args) {
        int[][] a = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }
        System.out.println(f(a));
    }

    public static int f(int[][] grid) {
        if (grid.length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;
        int[][] XMatrix = new int[x + 1][y];
        int[][] YMatrix = new int[x][y + 1];
        int onesCounter = 0;
        int twosCounter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    onesCounter++;
                    XMatrix[i][j]++;
                    XMatrix[i + 1][j]++;
                    YMatrix[i][j]++;
                    YMatrix[i][j + 1]++;
                }
            }
        }
        for (int i = 0; i < XMatrix.length; i++) {
            for (int j = 0; j < XMatrix[i].length; j++) {
                if (XMatrix[i][j] == 2) {
                    twosCounter++;
                }
            }
        }
        for (int i = 0; i < YMatrix.length; i++) {
            for (int j = 0; j < YMatrix[i].length; j++) {
                if (YMatrix[i][j] == 2) {
                    twosCounter++;
                }
            }
        }
        return onesCounter * 4 - twosCounter * 2;
    }
}
