package leetcode.MaximumGap;

import java.util.Arrays;

/**
 * Created by luyan on 17/3/10.
 */
public class Solutions {

    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int maxGap = 0;

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            maxGap = (maxGap < nums[i] - nums[i - 1]) ? nums[i] - nums[i - 1] : maxGap;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 51, 5, 3, 7, 19, 99, 34, 94, 100 };
        int[] b = { 1, 2, 3, 4, 51, 5, 3, 7, 19, 99, 34, 94, 100 };
        Arrays.sort(b);
        int maxGap = 0;
        for (int i = 1; i < b.length; i++) {
            maxGap = (maxGap < b[i] - b[i - 1]) ? b[i] - b[i - 1] : maxGap;
        }
        System.out.println(maxGap);
        System.out.println(maximumGap(a));

    }
}
