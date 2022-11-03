package leetcode.lenLongestFibSubseq;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
                System.out.println(lenLongestFibSubseq(new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
                System.out.println(lenLongestFibSubseq(new int[] {1, 3, 7, 11, 12, 14, 18}));
        System.out.println(lenLongestFibSubseq(new int[] {2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50}));
                System.out.println(lenLongestFibSubseq(new int[] {2, 5, 6, 7, 8, 10, 12, 17, 24, 41, 65}));
    }

    public static int lenLongestFibSubseq(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                int i1 = i;
                int j1 = j;
                int value = arr[i1] + arr[j1];
                int size = 0;
                while (map.keySet().contains(value)) {
                    if (size == 0) {
                        size = 3;
                    } else {
                        size += 1;
                    }
                    res = Math.max(res, size);
                    i1 = j1;
                    j1 = map.get(value);
                    value = arr[i1] + arr[j1];
                }
            }

        }
        return res;
    }
}
