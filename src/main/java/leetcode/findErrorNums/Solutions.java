package leetcode.findErrorNums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by luyan on 17/7/23.
 */
public class Solutions {

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 2 };
        nums = findErrorNums(nums);
        Arrays.stream(nums).forEach(p -> System.out.println(p));
    }

    public static int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long total = 0;
        int[] res = new int[2];
        for (int i : nums) {
            if (set.contains(i)) {
                res[0] = i;
            } else {
                set.add(i);
            }
            total += i;
        }

        long fact = (1 + nums.length) * nums.length / 2;
        int missing = (int) (res[0] + (fact - total));
        res[1] = missing;
        return res;
    }
}
