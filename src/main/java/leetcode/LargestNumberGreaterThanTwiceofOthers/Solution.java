package leetcode.LargestNumberGreaterThanTwiceofOthers;

/**
 * Created by luyan on 17/12/24.
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dominantIndex(new int[] { 0, 0, 3, 2 }));
    }

    public int dominantIndex(int[] nums) {
        Integer maxBigNumer = Integer.MIN_VALUE;
        boolean isBig2times = false;
        int maxBigNumberIndex = -1;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > maxBigNumer) {
                maxBigNumberIndex = i;
                maxBigNumer = nums[i];
            }

        }
        System.out.println(maxBigNumer);
        for (int i = 0; i < nums.length; i++) {
            if (i != maxBigNumberIndex && nums[i] * 2 > maxBigNumer) {
                return -1;
            }
        }

        return maxBigNumberIndex;
    }
}
