package leetcode.SingleNumber;

/**
 * Created by luyan on 17/4/14.
 */
public class Solutions {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] { 1, 1, 2, 2, 3, 4, 4 }));

    }

    public static int singleNumber(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
