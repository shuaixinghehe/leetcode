package leetcode.countBadPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(countBadPairs(new int[] {4, 1, 3, 3}));
        System.out.println(countBadPairs(new int[] {1, 2, 3, 4, 5}));
        System.out.println(getC(100000));
    }

    public static long getC(int value) {
        if (value % 2 == 0) {
            return value / 2 * (value - 1L);
        } else {
            return (value - 1L) / 2 * value;
        }
    }

    public static long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0) + 1);
        }
        long equalCnt = 0L;
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            equalCnt += getC(value);
        }
        return getC(nums.length) - equalCnt;
    }
}
