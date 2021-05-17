package leetcode.IntersectionofTwoArraysII;

import java.util.ArrayList;
import java.util.HashMap;

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
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> target = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                int value = map.get(nums1[i]);
                map.put(nums1[i], ++value);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                int value = map.get(nums2[i]);
                if (value > 0) {
                    target.add(nums2[i]);
                    map.put(nums2[i], --value);
                }

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
