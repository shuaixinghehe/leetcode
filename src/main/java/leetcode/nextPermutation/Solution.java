package leetcode.nextPermutation;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();

        arr = new int[] {1, 2, 1};
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();

        arr = new int[] {1, 1, 1};
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();

        arr = new int[] {1, 1, 5};
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();

        arr = new int[] {1, 2, 3, 5, 2, 8, 1, 3, 1};
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        boolean isOrdered = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i + 1]) {
                isOrdered = false;
            }
        }

        if (isOrdered) {
            Arrays.sort(nums);
            return;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i - 1 >= 0 && nums[i] > nums[i - 1]) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
                return;
            }
        }
    }
}
