package leetcode.NextGreaterElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luyan on 17/3/4.
 */
public class Solutions {

    public static void main(String[] args) {
        int[] findNums = {4, 1, 2};
        int[] nums = {1, 3, 4, 2};
        nextGreaterElement(findNums, nums);
        nextGreaterElements(nums);
    }

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < findNums.length; i++) {
            boolean flag = false;
            for (int j = numsMap.get(findNums[i]) + 1; j < nums.length; j++) {
                if (nums[j] > findNums[i]) {
                    list.add(nums[j]);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(-1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /***
     * Input: [1,2,1]
     Output: [2,-1,2]
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements(int[] nums) {

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            boolean find = false;
            for (int j = (i + 1) % nums.length; j != i; j = (j + 1) % nums.length) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    find = true;
                    break;
                }
            }
            if (!find) {
                res[i] = -1;
            }
        }
        return res;

    }
}
