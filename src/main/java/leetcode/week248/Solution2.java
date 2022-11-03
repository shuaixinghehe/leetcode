package leetcode.week248;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(eliminateMaximum(new int[] {1, 3, 4}, new int[] {1, 1, 1}));
        System.out.println(eliminateMaximum(new int[] {1, 1, 2, 3}, new int[] {1, 1, 1, 1}));
        System.out.println(eliminateMaximum(new int[] {3, 2, 4}, new int[] {5, 3, 2}));
        System.out.println(eliminateMaximum(new int[] {3, 2, 4}, new int[] {1, 5, 2}));
        System.out.println(eliminateMaximum(new int[] {5}, new int[] {3}));
        System.out.println(eliminateMaximum(new int[] {4, 2, 3}, new int[] {2, 1, 1}));
        System.out.println(eliminateMaximum2(new int[] {4, 2, 3}, new int[] {2, 1, 1}));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        Set<Integer> indexSet = new HashSet<>();
        int killIndex = -1;
        int maxMinute = 0;
        for (int i = 0; i < dist.length; i++) {
            maxMinute = Math.max((int) Math.ceil(dist[i] * 1.0 / speed[i]), maxMinute);
        }
        System.out.println("maxMinute:" + maxMinute);
        for (int m = 0; m < maxMinute; m++) {
            for (int i = 0; i < dist.length; i++) {
                // 目前dist 和 speed 是当前的状态
                // check next status
                int[] nextDist = new int[dist.length];
                for (int j = 0; j < dist.length; j++) {
                    nextDist[j] = dist[j] - speed[j];
                }
                // check status
                int needKillNum = 0;
                boolean killOne = true;
                int minDist = Integer.MAX_VALUE;
                int minDistIndex = -1;
                for (int j = 0; j < nextDist.length; j++) {
                    if (nextDist[j] < minDist && !indexSet.contains(j)) {
                        minDist = nextDist[j];
                        minDistIndex = j;
                    }
                    if (nextDist[j] <= 0 && killOne && !indexSet.contains(j)) {
                        indexSet.add(j);
                        killIndex = j;
                        killOne = false;
                        needKillNum++;
                    } else if (nextDist[j] <= 0 && !indexSet.contains(j)) {
                        needKillNum++;
                    }
                }

                if (needKillNum > 1) {
                    System.out.println("needKillNum > 1 indexSet:" + indexSet);
                    return indexSet.size();
                }
                if (!indexSet.contains(minDistIndex) && minDistIndex >= 0) {
                    indexSet.add(minDistIndex);
                }
                dist = nextDist;
            }
        }

        System.out.println("indexSet:" + indexSet);
        return indexSet.size();
    }

    private static int eliminateMaximum2(int[] dist, int[] speed) {
        int[] needMin = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            needMin[i] = (int) Math.ceil(dist[i] * 1.0 / speed[i]);
        }
        Arrays.sort(needMin);
        System.out.println("sorted needMin:" + needMin);
        for (int i = 0; i < needMin.length; i++) {
            System.out.print(needMin[i] + ",");
        }
        System.out.println();
        int ans = 1;
        for (int i = 1; i < needMin.length; i++) {
            if (i >= needMin[i]) {
                break;
            }
            ans++;
        }
        return ans;
    }
}
