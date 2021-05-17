package leetcode.NumArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyan on 17/10/26.
 */
public class NumArray {

    private List<Long> inOrderList = new ArrayList<>();

    public NumArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            inOrderList.add((long) nums[i]);
        }
        for (int i = 1; i < inOrderList.size(); i++) {
            inOrderList.set(i, inOrderList.get(i) + inOrderList.get(i - 1));
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(2, 2);
        System.out.println(param_1);

    }

    public int sumRange(int i, int j) {
        //        inOrderList.stream().forEach(e -> System.out.print(e + " "));
        //        System.out.println();
        //        reverseOrderList.stream().forEach(e -> System.out.print(e + " "));
        //        System.out.println();
        if (i == 0) {
            return Math.toIntExact(inOrderList.get(j));
        }
        return (int) (inOrderList.get(j) - inOrderList.get(i - 1));
    }
}
