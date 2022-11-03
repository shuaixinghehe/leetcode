package leetcode.bestCoordinate;

public class Solution {

    public static int[] bestCoordinate(int[][] towers, int radius) {
        //0 <= xi, yi, qi <= 50
        int[][] arr = new int[51][51];

        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                for (int i = 0; i < towers.length; i++) {
                    int[] point = towers[i];
                    double dis = Math.sqrt((point[0] - x) * (point[0] - x) + (point[1] - y) * (point[1] - y));
                    if (dis <= radius) {
                        arr[x][y] += Math.floor(point[2] / (1 + dis));
                    }
                }
            }
        }
        int value = -1;
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > value) {
                    x = i;
                    y = j;
                    value = arr[i][j];
                }
                                System.out.print(arr[i][j] + ",");
            }
                        System.out.println();
        }
                System.out.println();
        int[] res = new int[2];
        res[0] = x;
        res[1] = y;
        System.out.println("x:" + x + " y:" + y);
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(bestCoordinate(new int[][] {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}}, 2));
//        System.out.println(bestCoordinate(new int[][] {{23, 11, 21}}, 9));
//        System.out.println(bestCoordinate(new int[][] {{1, 2, 13}, {2, 1, 7}, {0, 1, 9}}, 2));
        System.out.println(bestCoordinate(new int[][] {{0,1,2},{2,1,2},{1,0,2},{1,2,2}}, 1));
    }
}
