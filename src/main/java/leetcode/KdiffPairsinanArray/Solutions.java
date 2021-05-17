package leetcode.KdiffPairsinanArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luyan on 17/3/5.
 */
public class Solutions {

    public static void main(String[] args) {

        int[] a = { 3, 1, 4, 1, 5 };
        System.out.println(findPairs(a, 2));
        a = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(findPairs(a, 1));
        a= new int [] {1,3,1,5,4};
        System.out.println(findPairs(a,0));
    }

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        Map<String, Boolean> map = new HashMap<>();

        int p1 = 0;
        int p2 = 1;
        int res = 0;
        while (p1 < nums.length && p2 < nums.length) {
            if (nums[p2] - nums[p1] == k
                    && !map.containsKey(String.valueOf(nums[p1]) + String.valueOf(nums[p2]))) {

                map.put(String.valueOf(nums[p1]) + String.valueOf(nums[p2]), true);
                res++;
                if (p1 + 1 == p2) {
                    p1++;
                    p2++;
                } else {
                    p1++;
                }
            } else if (nums[p2] - nums[p1] > k) {
                if (p1 + 1 == p2) {
                    p1++;
                    p2++;
                } else {
                    p1++;
                }
            } else {
                p2++;
            }
        }
        return res;
    }
}
