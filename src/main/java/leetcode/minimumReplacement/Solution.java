package leetcode.minimumReplacement;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minimumReplacement(new int[] {3, 9, 3}));
        System.out.println(minimumReplacement(new int[] {1, 2, 3, 4, 5}));
        System.out.println(minimumReplacement(new int[] {2, 10, 20, 19, 1}));
        System.out.println(minimumReplacement(new int[] {19, 7, 2, 24, 11, 16, 1, 11, 23}));
        System.out.println(minimumReplacement(new int[] {12, 9, 7, 6, 17, 19, 21}));
//        System.out.println(cal(9, 6));
    }

    public static long cal(int a1, int a2) {
        if (a2 < a1) {
            return (long) (Math.ceil(1.0 * a1 / a2) * 1L) - 1L;
        }
        return 0L;
    }


    public static long minimumReplacement(int[] nums) {
        long oprations = 0L;
        int[] minNums = new int[nums.length];
        for (int i = 0; i < minNums.length; i++) {
            minNums[i] = 1000_000_000 + 1;
        }
        minNums[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            minNums[i] = Math.min(nums[i], minNums[i + 1]);
            if (nums[i] % minNums[i] != 0) {
                minNums[i] = Math.min(minNums[i], nums[i] % minNums[i]);
            }
        }


        for (int i = 0; i < minNums.length; i++) {
            System.out.print(minNums[i] + ",");
        }
        System.out.println();
        for (int i = 0; i < nums.length; ) {
            if (i + 1 < nums.length && nums[i] > minNums[i + 1]) {
                oprations += cal(nums[i], minNums[i + 1]);
            }
            i++;
        }
        return oprations;
    }
}
