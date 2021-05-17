package leetcode.MinimumPathSum;

/**
 * Created by luyan on 17/4/24.
 */
public class Solutions {

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 2}, {5,6},{1,1}}));
    }

    public static int minPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j], grid[i][j] + grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[grid.length - 1].length - 1];

    }

}
