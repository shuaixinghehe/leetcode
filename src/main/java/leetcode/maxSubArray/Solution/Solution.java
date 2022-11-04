package leetcode.maxSubArray.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (value + nums[i] >= 0) {
                if (value <= 0) {
                    value = nums[i];
                    continue;
                }
                max = Math.max(max, value + nums[i]);
                value = value + nums[i];
            } else {
                max = Math.max(max, nums[i]);
                value = nums[i];

            }
        }
        return max;
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int arrive = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (arrive >= i) {
                arrive = Math.max(arrive, i + nums[i]);
            }
        }
        if (arrive >= nums.length - 1) {
            return true;
        }
        return false;
    }

    public static int getC2i(Character c) {
        if (c.equals('(')) {
            return 0;
        }
        return 1;
    }

    public static int longestValidParentheses(String s) {
        Stack<List<Integer>> stack = new Stack<>();

        // ( 代表0  ）代表1
        boolean[] arr = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                list.add(getC2i(s.charAt(i)));
                list.add(i);
                stack.add(list);
            } else {
                if (stack.peek().get(0) == 0 && s.charAt(i) == ')') {
                    arr[stack.peek().get(1)] = true;
                    arr[i] = true;
                    stack.pop();
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(getC2i(s.charAt(i)));
                    list.add(i);
                    stack.add(list);
                }
            }
        }
        int maxTrueCnt = 0;
        int trueCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                trueCnt++;
            } else {
                maxTrueCnt = Math.max(maxTrueCnt, trueCnt);
                trueCnt = 0;

            }
//            System.out.print(arr[i] + ",");
        }
//        System.out.println();
        maxTrueCnt = Math.max(maxTrueCnt, trueCnt);
        return maxTrueCnt;
    }

    public static void main(String[] args) {
        //        System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        //        System.out.println(maxSubArray(new int[] {1, -1, 1}));
        //        System.out.println(maxSubArray(new int[] {8, -19, 5, -4, 20}));
        //        System.out.println(maxSubArray(new int[] {5, 4, -1, 7, 8}));
        //        System.out.println(canJump(new int[] {2, 3, 1, 1, 4}));
        //        System.out.println(canJump(new int[] {3, 2, 1, 0, 4}));
        //        System.out.println(canJump(new int[] {1,}));
        //        System.out.println(canJump(new int[] {1, 2}));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("((("));
    }
}
