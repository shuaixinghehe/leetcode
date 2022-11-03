package leetcode.minStoneSum;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minStoneSum(new int[] {4, 3, 6, 7}, 3));
        System.out.println(minStoneSum(new int[] {5, 4, 9}, 2));
    }

    public static int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < piles.length; i++) {
            queue.add(piles[i]);
        }
//        System.out.println("queue:" + queue);
        for (int i = 0; i < k; i++) {
            int pile = queue.poll();
            int m = (int) Math.floor(pile - pile / 2.0);
            queue.add(pile - m);
//            System.out.println("i:" + i + " m:" + m + " pile:" + pile + " queue:" + queue);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            res += queue.poll();
        }
        return res;
    }
}
