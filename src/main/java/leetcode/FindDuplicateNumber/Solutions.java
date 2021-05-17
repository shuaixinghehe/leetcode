package leetcode.FindDuplicateNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by luyan on 17/4/11.
 */
public class Solutions {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 1, 1 }));

    }

    public static int findDuplicateII(int[] nums) {
        long length = nums.length - 1;
        long sum = length * (length + 1) / 2;
        long sumNums = 0;
        for (int i = 0; i < nums.length; i++) {
            sumNums += nums[i];
        }
        return (int) (sumNums - sum);
    }

    public static int findDuplicate(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        Collections.sort(list);
        if (list.size() > 0) {
            int first = (Integer) list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (first == (Integer) list.get(i)) {
                    return first;
                } else {
                    first = (Integer) list.get(i);
                }
            }

        }
        return 0;
    }
}
