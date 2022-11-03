package leetcode.longestConsecutive;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> list = set.stream().collect(Collectors.toList());
        Collections.sort(list);
        //        for (int i = 0; i < nums.length; i++) {
        //            System.out.print(nums[i] + ",");
        //        }
        //        System.out.println();
        //        System.out.println();
        int longest = 1;
        int res = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) == 1) {
                longest++;
            } else {
                res = Math.max(res, longest);
                longest = 1;
            }
        }
        res = Math.max(res, longest);
        return res;
    }
}
