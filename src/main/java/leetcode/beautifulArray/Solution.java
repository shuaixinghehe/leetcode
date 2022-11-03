package leetcode.beautifulArray;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        //        System.out.println(beautifulArray2(1));
        //        System.out.println(beautifulArray2(4));
        //        System.out.println(beautifulArray2(5));
        //        System.out.println(beautifulArray2(10));
        System.out.println(beautifulArray2(100));
        //        System.out.println(beautifulArray2(1000));
    }

    public static int[] beautifulArray(int n) {
        int[] res = new int[n];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                deque.addFirst(i);
            } else {
                deque.addLast(i);
            }
        }
        //        System.out.println("deque" + deque);
        for (int i = 0; i < deque.size(); i++) {
            res[i] = deque.get(i);
        }
        //        for (int i = 0; i < res.length; i++) {
        //            System.out.print("-" + res[i] + ",");
        //        }
        //        System.out.println();
        return res;
    }

    public static int[] beautifulArray2(int n) {
        if (n == 1) {
            return new int[] {1};
        }
        if (n == 2) {
            return new int[] {1, 2};
        }
        if (n == 3) {
            return new int[] {2, 1, 3};
        }
        int[] res = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // value index
        list.add(2);
        list.add(1);
        list.add(3);
        //        System.out.println("init:" + list);
        Queue<List<Integer>> queue = new ArrayDeque<>();
        for (int i = 4; i <= n; i++) {
            for (int j = 0; j < list.size(); j++) {
                map.put(list.get(j), j);
            }
            int left = 0;
            int right = list.size();
            int index = 0;
            for (int j = 0; j < list.size(); j++) {
                int value = list.get(j) * 2 - i;
                if (map.containsKey(value)) {
                    //  当前再j这个问题，另一个位置是map.get(value)
                    if (map.get(value) > j) {
                        left = Math.max(j + 1, left);
                        //                        right = Math.min(map.get(value) + 1, right);
                    } else {
                        left = Math.max(map.get(value), left);
                        right = Math.min((j + 1) - 1, right);
                    }
                }
            }
            if (left <= right) {
                list.add(left, i);
                for (int j = left; j < right; j++) {
                    queue.add(new ArrayList<>(list));
                    list.remove(j);
                    list.add(j + 1, i);
                }
            } else {
//                list =queue.poll();
                System.out.println("add i: " + i + " error left:" + left + " right:" + right);
            }
            System.out.println("add:" + i + " left:" + left + " right:" + right + " list:" + list);
        }
        System.out.println("res list:" + list.size() + " " + list);
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
