package leetcode.LongestPalindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luyan on 17/1/21.
 */
public class Solutions {

    public static void main(String[] args) {

    }

    /***
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice in the array,
     * and it should return false if every element is distinct.
    
     Subscribe to see which companies asked this question
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        return 0;
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}
