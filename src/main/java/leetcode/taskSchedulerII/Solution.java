package leetcode.taskSchedulerII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(taskSchedulerII(new int[] {1, 2, 1, 2, 3, 1}, 3));
        System.out.println(taskSchedulerII(new int[] {5, 8, 8, 5}, 2));
        System.out.println(taskSchedulerII(new int[] {5, 8,}, 2));
        System.out.println(taskSchedulerII(new int[] {8,}, 2));
    }

    public static long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> taskBeginIndexMap = new HashMap<>();
        Long days = 1L;
        for (int i = 0; i < tasks.length; i++) {
            int taskType = tasks[i];
            if (taskBeginIndexMap.containsKey(taskType)) {
                if ((days - taskBeginIndexMap.getOrDefault(taskType, 200000L) <= space)) {
                    days = taskBeginIndexMap.getOrDefault(taskType, 200000L) + space + 1;
                    taskBeginIndexMap.put(taskType, days);
                    days++;
                } else {
                    taskBeginIndexMap.put(taskType, days);
                    days++;
                }

            } else {
                // 第一次见
                taskBeginIndexMap.put(taskType, days);
                days++;
            }


        }
        return days - 1;

    }
}
