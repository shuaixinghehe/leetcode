package leetcode.findKthLargest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by luyan on 17/7/5.
 */
public class SolutionsII {

    private static int swapTimes = 0;

    private static void swap(int[] nums, int left, int right) {
        swapTimes++;
        if (swapTimes % 10 == 0) {
            System.out.println("swapTimes:" + swapTimes);
        }
        System.out.print("swap nums[" + left + "]:" + nums[left] + "   nums[" + right + "]:"
                + nums[right] + " #  ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

    private static int partitionII(int[] nums, int left, int right) {

        int p = nums[left];
        left--;
        right++;
        while (true) {
            do {
                left++;
            } while (nums[left] > p);
            do {
                right--;
            } while (nums[right] < p);
            if (left >= right) {
                System.out.println("return nums[" + right + "]:" + nums[right]);
                return right;
            }
            swap(nums, left, right);
        }
    }

    private static int quickSortII(int[] nums, int low, int high, int k) {
        if (low < high) {
            int p = partitionII(nums, low, high);
            if (k == p + 1) {
                return nums[p];
            } else if (k > p + 1) {
                return quickSortII(nums, p + 1, high, k);
            } else {
                return quickSortII(nums, low, p, k);
            }
        }
        return 0;
    }

    public static int findKthLargest(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            l.add(nums[i]);
        }
        Collections.sort(l);
        Collections.reverse(l);
        System.out.println("list:" + l);
        return l.get(k - 1);

    }

    public static int findKthLargestII(int[] nums, int k) {
        return quickSortII(nums, 0, nums.length - 1, k);

    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 1, 4, 2, 6, 3, 5 }, 4));
        System.out.println(findKthLargestII(new int[] { 1, 4, 2, 6, 3, 5 }, 4));
        int[] nums = new int[] { 3, 2, 1, 5, 6, -1, 4, 2, 9, 2, -2, 1, 0 };
        //        quickSort(nums, 0, nums.length - 1);
        System.out.println(findKthLargest(nums, 4));
        System.out.println(findKthLargestII(nums, 4));
        //        System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
    }
}
