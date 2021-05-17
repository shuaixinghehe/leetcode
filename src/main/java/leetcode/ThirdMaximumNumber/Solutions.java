package leetcode.ThirdMaximumNumber;

/**
 * Created by luyan on 17/4/28.
 */
public class Solutions {

    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        System.out.println(solutions.thirdMax(new int[]{1, 2, 3, 4, 56, 6}));
    }

    public int thirdMax(int[] nums) {
        int maxFirst = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            maxFirst = Math.max(maxFirst, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (min == maxFirst) {
            return maxFirst;
        }
        int maxSecond = min;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < maxFirst) {
                maxSecond = Math.max(maxSecond, nums[i]);
            }
        }
        if (min == maxSecond) {
            return maxFirst;
        }
        int maxThird = min;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < maxSecond) {
                maxThird = Math.max(maxThird, nums[i]);
            }
        }

        return maxThird;

    }

    public int thirdMax0(int[] nums) {
        int[] thirdMax = new int[3];
        for (int i = 0; i < thirdMax.length; i++) {
            System.out.println(i + " : " + thirdMax[i]);
        }
        int SMALL_INDEX = 0;
        int MIN_INDEX = 1;
        int BIG_INDEX = 2;
        int max = nums[0];
        if (nums.length < 3) {
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }
        thirdMax[BIG_INDEX] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > thirdMax[BIG_INDEX]) {
                thirdMax[SMALL_INDEX] = thirdMax[MIN_INDEX];
                thirdMax[MIN_INDEX] = thirdMax[BIG_INDEX];
                thirdMax[BIG_INDEX] = nums[i];
                continue;
            }
            if (nums[i] > thirdMax[MIN_INDEX]) {
                thirdMax[SMALL_INDEX] = thirdMax[MIN_INDEX];
                thirdMax[MIN_INDEX] = nums[i];
                continue;
            }
            if (nums[i] > thirdMax[SMALL_INDEX]) {
                thirdMax[SMALL_INDEX] = nums[i];
                continue;
            }
        }
        for (int i = 0; i < thirdMax.length; i++) {
            System.out.println(i + " : " + thirdMax[i]);
        }
        return thirdMax[SMALL_INDEX];
    }

}
