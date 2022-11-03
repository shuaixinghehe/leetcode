package leetcode.mostFrequentEven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(mostFrequentEven(new int[] {0, 1, 2, 2, 4, 4, 1}));
        System.out.println(mostFrequentEven(new int[] {4, 4, 4, 9, 2, 4}));
        System.out.println(mostFrequentEven(new int[] {29, 47, 21, 41, 13, 37, 25, 7}));
    }

    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 ) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().collect(Collectors.toList());
        // 找到出现最多的int
        int freq = -1;
        for (int i = 0; i < list.size(); i++) {
            freq = Math.max(list.get(i).getValue(), freq);
        }

        int small = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue()==freq){
                small = Math.min(small,list.get(i).getKey());
            }
        }
        if (map.entrySet().size() == 0) {
            return -1;
        }
        return small;
    }
}
