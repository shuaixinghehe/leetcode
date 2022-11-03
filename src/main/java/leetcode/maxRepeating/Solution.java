package leetcode.maxRepeating;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static int maxRepeating(String sequence, String word) {
        int res = 0;
        String target = "";
        for (int i = 0; i <= 50; i++) {
            target += word;
            int n = sequence.indexOf(target);
            if (n >= 0) {
                res = i + 1;
            }
        }
        return res;

    }

    public static void main(String[] args) {
//        System.out.println(maxRepeating("ababc", "ab"));
//        System.out.println(maxRepeating("ababc", "ba"));
//        System.out.println(maxRepeating("ababc", "ac"));
        System.out.println(intersection(new int[]{1,2,2,1},new int[]{2,2}));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<Integer> res = new ArrayList<>();
        List<Integer> list = set1.stream().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (set2.contains(list.get(i))){
                res.add(list.get(i));
            }
        }
        int [] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
