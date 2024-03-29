package leetcode.nextGreaterElementI;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {


    public static int findNextGreater(int[] nums2, int index, int value) {

        for (int i = index; i < nums2.length; i++) {
            if (nums2[i] > value) {
                return nums2[i];
            }
        }
        return -1;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = findNextGreater(nums2, map.get(nums1[i]) + 1, nums1[i]);
        }
        //        for (int i = 0; i < res.length; i++) {
        //            System.out.print(res[i] + ",");
        //        }
        //        System.out.println();
        return res;
    }

    public static int[] nextGreaterElementI(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()) {
                stack.add(nums2[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                    map.put(stack.pop(), nums2[i]);
                }
                stack.add(nums2[i]);
            }
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + ",");
//        }
//        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElementI(new int[] {4, 1, 2},
                new int[] {1, 3, 4, 2}));

        System.out.println(nextGreaterElementI(new int[] {2, 4},
                new int[] {1, 2, 3, 4}));
    }
}
