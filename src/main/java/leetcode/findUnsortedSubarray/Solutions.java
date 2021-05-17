package leetcode.findUnsortedSubarray;

import java.util.Arrays;

/**
 * Created by luyan on 17/5/14.
 */
public class Solutions {

    public static int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(nums);
        int startSame = 0;
        int endSame = 0;

        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == nums[i]) {
                startSame++;
            } else {
                break;
            }
        }
        if (startSame == nums.length) {
            return 0;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (copy[i] == nums[i]) {
                endSame++;
            } else {
                break;
            }
        }
        return nums.length - (startSame + endSame);
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
