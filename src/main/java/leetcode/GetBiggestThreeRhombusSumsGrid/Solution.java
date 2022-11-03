package leetcode.GetBiggestThreeRhombusSumsGrid;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;


public class Solution {
    public static void main(String[] args) {
        System.out.println(getBiggestThree(
                new int[][] {
                        {20, 17, 9, 13, 5, 2, 9, 1, 5},
                        {14, 9, 9, 9, 16, 18, 3, 4, 12},
                        {18, 15, 10, 20, 19, 20, 15, 12, 11},
                        {19, 16, 19, 18, 8, 13, 15, 14, 11},
                        {4, 19, 5, 2, 19, 17, 7, 2, 2}
                }));
        //        System.out.println(getBiggestThree(
        //                new int[][] {{3, 4, 5, 1, 3}, {3, 3, 4, 2, 3}, {20, 30, 200, 40, 10}, {1, 5, 5, 4, 1},
        //                        {4, 3, 2, 2, 5}}));
    }

    public static int[] getBiggestThree(int[][] grid) {
        Set<Integer> sumSet = new HashSet<>();
        Queue<List<Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sumSet.add(grid[i][j]);
                if (i - 1 >= 0 && i + 1 < grid.length && j - 1 >= 0 && j + 1 < grid[0].length) {
                    int sum = grid[i - 1][j] + grid[i][j - 1] + grid[i][j + 1] + grid[i + 1][j];
                    sumSet.add(sum);
                    List list = new ArrayList();
                    list.add(i); // 横坐标
                    list.add(j); // 纵坐标
                    list.add(2); // 探测长度
                    queue.add(list);
                }
            }
        }
//        System.out.println("queue size:" + queue.size());
        while (!queue.isEmpty()) {
            List<Integer> item = queue.poll();
            int i = item.get(0);
            int j = item.get(1);
            int len = item.get(2);
            if (i - len >= 0 && i + len < grid.length && j - len >= 0 && j + len < grid[0].length) {
                int topi = i - len;
                int buttomi = i + len;
                int leftj = j - len;
                int rightj = j + len;
                int sum = grid[i - len][j] + grid[i][j - len] + grid[i][j + len] + grid[i + len][j];
                int tempi = topi + 1;
                int tempj = j - 1;
                while (tempi < i && tempj > leftj) {
                    sum += grid[tempi][tempj];
                    tempi++; // 向下跑
                    tempj--; // 向左跑
                }
                tempi = (i - len) + 1; // 最上面的i
                tempj = j + 1;  // 向右
                while (tempi < i && tempj < j + len) {
                    sum += grid[tempi][tempj];
                    tempi++;
                    tempj++;
                }
                tempi = i + 1; // i 下方
                tempj = j - len + 1; // 左面
                while (tempi < i + len && tempj < j) {
                    sum += grid[tempi][tempj];
                    tempi++; // 往下跑
                    tempj++;
                }
                tempi = i + 1;
                tempj = j + len - 1;
                while (tempi < i + len && tempj > j) {
                    sum += grid[tempi][tempj];
                    tempi++;
                    tempj--;
                }
//                System.out.println("i:" + i + " j:" + j + " sum:" + sum + " len:" + len);
                sumSet.add(sum);
                List list = new ArrayList();
                list.add(i); // 横坐标
                list.add(j); // 纵坐标
                list.add(len + 1); // 探测长度
                queue.add(list);
            }
        }
        List<Integer> sortedList = sumSet.stream().collect(Collectors.toList());
        Collections.sort(sortedList, Collections.reverseOrder());
//        System.out.println("sorted list size:" + sortedList.size());
        System.out.println("sorted list:" + sortedList);
        if (sortedList.size() < 3) {
            int[] res = new int[sortedList.size()];
            for (int i = 0; i < sortedList.size(); i++) {
                res[i] = sortedList.get(i);
            }
            return res;
        } else {
            int[] res = new int[3];
            for (int i = 0; i < 3; i++) {
                res[i] = sortedList.get(i);
            }
            return res;
        }
    }
}
