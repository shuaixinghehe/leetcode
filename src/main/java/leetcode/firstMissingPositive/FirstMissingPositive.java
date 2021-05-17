package leetcode.firstMissingPositive;

/**
 * Created by luyan on 17/10/31.
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(
                firstMissingPositive.firstMissingPositive(new int[] { -1, 0, 1, 2, 3, 4, 5, 7 }));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] { 1, 2, 0 }));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
    }

    public int firstMissingPositive(int[] nums) {
        int min = 0;
        int max = 0;
        long sum = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] <= 0) {
                return 1;
            } else if (nums[0] > 1) {
                return nums[0] - 1;
            } else if (nums[0] == 1) {
                return 2;
            }
        } else {
            min = 0;
            max = 0;
            int i = 0;
            while (nums[i] <= 0) {
                i++;
            }
            min = nums[i];
            max = nums[i];
            for (; i < nums.length && nums[i] >= 0; i++) {
                min = Math.min(nums[i], min);
                max = Math.max(nums[i], max);
                sum += nums[i];
            }
            long sum2 = (min + max) * (max - min + 1) / 2;
            if (sum2 == sum) {
                return min > 2 ? min - 1 : max + 1;
            } else {
                return (int) (sum2 - sum);
            }
        }
        return 0;

    }
}
