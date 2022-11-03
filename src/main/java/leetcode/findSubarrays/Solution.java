package leetcode.findSubarrays;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        System.out.println(findSubarrays(new int[]{4,2,4}));
    }

    public static boolean findSubarrays(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        boolean res = false;
        for (int i = 1; i < nums.length; i++) {
            long sum = nums[i - 1] + nums[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            if (map.get(sum) >= 2) {
                res = true;
                break;
            }

        }
        return res;
    }
}
