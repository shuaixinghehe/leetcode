package leetcode.minMoves;

/**
 * Created by luyan on 17/1/19.
 */
public class Solutions {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        //        System.out.println(leetcode.minMoves(a));
        //        a = new int[] { 1, 2 };
        //        System.out.println(leetcode.minMoves(a));
        a = new int[] { -100, 0, 100 };
        System.out.println(minMoves(a));
        a = new int[] { 0, 100, 200 };
        System.out.println(minMoves(a));
        a = new int[] { 4, 5, 5,5 };
        System.out.println(minMoves1(a));
    }

    public static int minMoves(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }
        long sum = 0;
        long maxValue = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxValue = maxValue > nums[i] ? maxValue : nums[i];
        }
        boolean allSameFlag = false;
        for (; maxValue < 600L; maxValue++) {
            long value = (maxValue * nums.length - sum);
            if (value % (nums.length - 1) == 0) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] + value / (nums.length - 1) == maxValue) {
                        allSameFlag = true;
                    } else {
                        allSameFlag = false;
                    }
                }
                if (allSameFlag) {
                    break;
                }
                allSameFlag = false;
            }
        }
        return (int) ((maxValue * nums.length - sum) / (nums.length - 1));

    }

    /**
     * The effect of increasing n-1 elements by one is equal to decrease
     * the left element by one. The goal is to decrease every element
     * larger than the minimum element to the minimum element. So,
     * the number of operation needed is sum-min*(nums.length).
     * @param nums
     * @return
     */

    public static int minMoves1(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums)
            min = Math.min(min, n);
        int res = 0;
        for (int n : nums)
            res += n - min;
        return res;
    }
}
