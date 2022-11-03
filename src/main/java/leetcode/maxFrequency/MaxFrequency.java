package leetcode.maxFrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxFrequency {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[] {3, 6, 9}, 2));
        System.out.println(maxFrequency(new int[] {1, 2, 4}, 5));
        System.out.println(maxFrequency(new int[] {1, 6, 7, 8}, 3));
        //        System.out.println(maxFrequency(
        //                new int[] {9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985,
        //                9902, 9975,
        //                        9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933,
        //                        9916, 9930,
        //                        9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924,
        //                        9988, 9923, 9910,
        //                        9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985,
        //                        9954, 9938,
        //                        9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936,
        //                        9975, 9954,
        //                        9932, 9964, 9972, 9935, 9946, 9966}, 3056));
        //        System.out.println(maxFrequency(
        //                new int[] {9940, 9995, 9944, 9937, 9941, 9952, 9907, 9952, 9987, 9964, 9940, 9914,
        //                        9941,
        //                        9933, 9912,
        //                        9934, 9980, 9907, 9980, 9944, 9910, 9997}, 7925));
    }

    public static int maxFrequency(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println("nums.length" + nums.length);
        int maxFreq = 1;
        for (int i = k; i > 0; i--) {
            Collections.sort(list); // 最小的排在前面
            System.out.println("sort list " + list);
            int minValue = list.get(0);
            list.set(0, minValue + 1);
            for (int j = 1; i > 0 && j < list.size() && list.get(j) == minValue; j++) {
                list.set(j, list.get(j) + 1);
                i--;
            }
            minValue = list.get(0);
            int freq = 1;
            for (int j = 1; j < list.size() && list.get(j) == minValue; j++) {
                freq++;
            }
            maxFreq = Math.max(freq, maxFreq);

        }
        System.out.println("final list " + list);
        return maxFreq;
        //        Map<Integer, Integer> map = new HashMap<>();
        //        list.stream().forEach(e -> {
        //            if (map.containsKey(e)) {
        //                map.put(e, map.get(e) + 1);
        //            } else {
        //                map.put(e, 1);
        //            }
        //        });
        //        return map.values().stream().max((a, b) -> a - b).get();
    }
}
