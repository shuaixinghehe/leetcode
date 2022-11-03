package leetcode.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println("threeSum:" + threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println("threeSum:" + threeSum(new int[] {}));
        System.out.println("threeSum:" + threeSum(new int[] {0}));
        System.out.println("threeSum:" + threeSum(new int[] {0, 0, 0}));
        System.out.println("threeSum:" + threeSum(new int[] {0, 1, 2, 3, 4, 5}));
        System.out.println("threeSum:" + threeSum(new int[] {-1, 0, 1, 2, 3, 4, 5}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
//        System.out.println("map:" + map);
        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + ",");
//        }
//        System.out.println();
        Set<String> validNums = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int num1 = nums[i];
                int num2 = nums[j];
                int num3 = (0 - num1 - num2);
                if (map.containsKey(num3)) {
                    // 判断存在的情况下，数量是否合理
                    int containsNum = map.get(num3);
                    containsNum--;
                    if (num1 == num3) {
                        containsNum--;
                    }
                    if (num2 == num3) {
                        containsNum--;
                    }
                    if (containsNum >= 0) {
                        // 存在合理的3个数
                        int[] tempArray = new int[] {num1, num2, num3};
                        Arrays.sort(tempArray);
                        validNums.add(tempArray[0] + "_" + tempArray[1] + "_" + tempArray[2]);
                    }
                }
            }
        }
        if (validNums.size() == 0) {
            return new ArrayList<>();
        }
        validNums.forEach(e -> {
            List<String> temp = Arrays.asList(e.split("_"));
            res.add(temp.stream().map(t -> Integer.valueOf(t)).collect(Collectors.toList()));
        });
//        System.out.println("validNums:" + validNums);
//        System.out.println("res:" + res);
        return res;
    }
}
