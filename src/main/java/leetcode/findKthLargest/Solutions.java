package leetcode.findKthLargest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by luyan on 17/7/5.
 */
public class Solutions {

    private static int swapTimes = 0;

    private static void swap(int[] nums, int left, int right) {
//        swapTimes++;
//        if (swapTimes % 10 == 0) {
//            System.out.println("swapTimes:" + swapTimes);
//        }
//        System.out.print("swap nums[" + left + "]:" + nums[left] + "   nums[" + right + "]:"
//                + nums[right] + " #  ");
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + " ");
//        }
//        System.out.println();
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

    //System.out.println(quickSort(new int[] { 3, 2, 1, 5, 6, 4 }));
    private static int partition(int[] nums, int left, int right) {
        if (left < 0 || right >= nums.length || left >= right) {
            return 0;
        }
        int p = nums[left];
        int start = left;
        int end = right;
        System.out.print("partition:nums[" + left + "]:" + nums[left] + " # ");
        while (left < right) {
            while (left < right && nums[left] < p) {
                left++;
            }
            while (left < right && nums[right] > p) {
                right--;
            }
            swap(nums, left, right);
        }
        swap(nums, start, left);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        partition(nums, start, left - 1);
        partition(nums, left + 1, end);

        return left;
    }

    //System.out.println(quickSort(new int[] { 3, 2, 1, 5, 6, 4 }));
    private static int partitionI(int[] nums, int left, int right) {

        int p = nums[left];
        left--;
        right++;
        while (true) {
            do {
                left++;
            } while (nums[left] < p);
            do {
                right--;
            } while (nums[right] > p);
            if (left >= right) {
                return right;
            }
            swap(nums, left, right);
        }
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
                return right;
            }
            swap(nums, left, right);
        }
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partitionI(nums, low, high);
            quickSort(nums, low, p);
            quickSort(nums, p + 1, high);
        }
    }

    private static int quickSortII(int[] nums, int low, int high, int k) {
        if (low < high) {
            int p = partitionII(nums, low, high);
            if (k - 1 == p) {
                return nums[p];
            } else if (k > p) {
                return quickSortII(nums, p + 1, high, k);
            } else {
                return quickSortII(nums, low, p, k);
            }
        }
        return 0;
    }

    private static int quickSortI(int[] nums, int low, int high, int k) {
        if (low < high) {
            int p = partitionI(nums, low, high);
            if (k == p) {
                return nums[nums.length - p];
            } else if (k > p) {
                return quickSortI(nums, p + 1, high, k);
            } else {
                return quickSortI(nums, low, p - 1, k);
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

    public static int findKthLargestI(int[] nums, int k) {
        return quickSortI(nums, 0, nums.length - 1, k);

    }

    public static int findKthLargestII(int[] nums, int k) {
        return quickSortII(nums, 0, nums.length - 1, k);

    }

    public static void main(String[] args) {
        //        System.out.println(findKthLargest(new int[] { 1, 4, 2, 6, 3, 5 }, 4));
        //        System.out.println(findKthLargestI(new int[] { 1, 4, 2, 6, 3, 5 }, 4));
        int[] nums = new int[] { 3, 2, 1, 5, 6, 4, -1, 4, 2, 9, 2, -2, 1, 0 };
        //        quickSort(nums, 0, nums.length - 1);
        System.out.println(findKthLargest(nums, 4));
        System.out.println(findKthLargestII(nums, 4));
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        quickSortII(nums, 0, nums.length - 1, 4);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        //        System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
    }
}
