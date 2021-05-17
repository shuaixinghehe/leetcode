package leetcode.findDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyan on 17/1/18.
 */
public class Solutions {

    public static void main(String[] args) {
        int [] nums= {4,3,2,7,8,2,3,1};
        System.out.println(f(nums));
    }

    private static List<Integer> f(int[] nums) {
        int[] orderedArray = new int[nums.length + 1];
        List<Integer> disappearedList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            orderedArray[nums[i]] = nums[i];
        }
        for (int i = 1; i < orderedArray.length; i++) {
            if (orderedArray[i] == 0) {
                disappearedList.add(i);
            }
        }

        return disappearedList;
    }
}
