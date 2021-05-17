package leetcode.LastStoneWeight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by luyan on 2019/5/19.
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(new int[] { 1, 2, 5, 2, 1, 5, 2, 9, 1, 4 }));
        System.out.println(solution.lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
        System.out.println(solution.lastStoneWeight(new int[] { 1,1 }));
    }

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> integerPriorityQueue = new PriorityQueue(new Comparator<Integer>() {

            public int compare(Integer e1, Integer e2) {
                return e2 - e1;///重载优先级使其变为大根堆
            }
        });
        int res = 0;
        Arrays.stream(stones).forEach(u -> {
            integerPriorityQueue.add(u);
        });
        while (!integerPriorityQueue.isEmpty()) {
            if (integerPriorityQueue.size() >= 2) {
                int first = integerPriorityQueue.poll();
                int second = integerPriorityQueue.poll();
                if (first == second) {
                    continue;
                } else {
                    integerPriorityQueue.add(first - second);
                }

            } else {
                res = integerPriorityQueue.poll();
                break;
            }
        }
        return res;
    }
}
