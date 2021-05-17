package leetcode.IntersectionofTwoArrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luyan on 17/1/19.
 */
public class Solutions {

    public static void main(String[] args) {
        int[] a = { 1, 2, 2, 1 };
        int[] b = { 2 };
        System.out.println(intersection(a, b).length);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> target = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                target.add(nums2[i]);
            }
        }
        int[] res = new int[target.size()];

        int i = 0;
        for (Integer key : target) {
            res[i] = key;
            i++;
        }

        return res;
    }

}
