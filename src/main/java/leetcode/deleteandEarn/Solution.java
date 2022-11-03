package leetcode.deleteandEarn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));
    }

    //    Given an array nums of integers, you can perform operations on the array.
    //
    //    In each operation, you pick any nums[i] and delete it to earn nums[i] points.
    //    After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
    //
    //    You start with 0 points. Return the maximum number of points you can earn by
    //    applying such operations.
    //
    //
    //
    //            Example 1:
    //
    //    Input: nums = [3,4,2]
    //    Output: 6
    //    Explanation: Delete 4 to earn 4 points, consequently 3 is also deleted.
    //            Then, delete 2 to earn 2 points.
    //6 total points are earned.
    //    Example 2:
    //
    //    Input: nums = [2,2,3,3,3,4]
    //    Output: 9
    //    Explanation: Delete 3 to earn 3 points, deleting both 2's and the 4.
    //    Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
    //9 total points are earned.
    //
    //
    //    Constraints:
    //
    //            1 <= nums.length <= 2 * 104
    //            1 <= nums[i] <= 104

    public static int deleteAndEarn(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0L) + (long) nums[i]);
        }
        System.out.println(map);
        map.keySet().stream().forEach(selectedItem -> {
            long sum = 0;
            Set<Integer> inValidSet = new HashSet<>();
            Set<Integer> selectedSet = new HashSet<>();
            selectedSet.add(selectedItem);
            sum += map.get(selectedItem);
            inValidSet.add(selectedItem + 1);
            inValidSet.add(selectedItem - 1);
            map.keySet().stream().forEach(other -> {
                if (!selectedSet.contains(other) && inValidSet.contains(other)){
//                    sum+=map.get(other);
                }
            });
        });
        return 0;
    }
}
