package leetcode.hardestWorker;

public class Solution {

    public static void main(String[] args) {
        System.out.println(hardestWorker(10, new int[][] {
                new int[] {0, 3}, new int[] {2, 5}, new int[] {0, 9}, new int[] {1, 15}
        }));

        System.out.println(hardestWorker(26, new int[][] {
                new int[] {1,1}, new int[] {3, 7}, new int[] {2, 12}, new int[] {7, 17}
        }));

        System.out.println(hardestWorker(2, new int[][] {
                new int[] {0,10}, new int[] {1, 20}}));
    }

    public static int hardestWorker(int n, int[][] logs) {

        int longTime = 0;
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < logs.length; i++) {
            if (i == 0) {
//                System.out.println(logs[i][1] - 0);
                if (logs[i][1] - 0 > longTime) {
                    longTime = logs[i][1] - 0;
                    minIndex = logs[i][0];
                }

            } else {
//                System.out.println(logs[i][1] - logs[i - 1][1]);
                if (logs[i][1] - logs[i - 1][1] > longTime) {
                    longTime = logs[i][1] - logs[i - 1][1];
                    minIndex = logs[i][0];
                } else if (logs[i][1] - logs[i - 1][1] == longTime && minIndex > logs[i][0]) {
                    minIndex = logs[i][0];
                }
            }
//            System.out.println("longtime" + longTime);
        }
        return minIndex;
    }
}
