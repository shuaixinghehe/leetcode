package leetcode.maximumRobots;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        maximumRobots(new int[] {3, 6, 1, 3, 4},
                new int[] {2, 1, 3, 4, 5},
                25);
    }

    public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {

        int[] copyRunning = new int[runningCosts.length];
        for (int i = 0; i < runningCosts.length; i++) {
            copyRunning[i] = runningCosts[i];
        }
        Arrays.sort(runningCosts);
        int checkRunningCnt = 0;
        long[] runningCostArr = new long[runningCosts.length];
        runningCostArr[0] = runningCosts[0];
        for (int i = 1; i < runningCosts.length; i++) {
            runningCostArr[i] = runningCostArr[i - 1] + runningCosts[i];
        }
        for (int i = 0; i < runningCosts.length; i++) {
            System.out.println(runningCosts[i] + "," + runningCostArr[i]);
            if (runningCostArr[i] * Math.max(checkRunningCnt, 1) <= budget) {
                checkRunningCnt++;
            }
        }
        // 算出最多可以几个
        System.out.println("checkRunningCnt:" + checkRunningCnt);
        return 0;
    }
}
