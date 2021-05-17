package leetcode.findMaxConsecutiveOnes;

/**
 * Created by luyan on 17/1/18.
 */
public class Solution {

    public static void main(String[] args) {
        int [] arr = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;

        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                len++;
                maxLen = Math.max(len, maxLen);
            } else {
                maxLen = Math.max(len, maxLen);
                len = 0;
            }
        }
        return maxLen;
    }
}
