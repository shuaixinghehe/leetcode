package leetcode.generateParenthesis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(8));
        System.out.println(generateParenthesis(8));
        System.out.println(generateParenthesis(8));
        System.out.println(generateParenthesis(8));
        System.out.println(generateParenthesis(8));
        System.out.println(generateParenthesis(8));
        System.out.println(generateParenthesis(8));
    }

    private static Map<Integer, List<String>> globalMap = new HashMap<>();

    public static List<String> generateParenthesis(int n) {
        if (globalMap.containsKey(n)) {
            return globalMap.get(n);
        }
        List<String> res = new ArrayList<>();
        res.add("()");
        if (n == 1) {
            return res;
        }
        Set<String> set = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add("()");
        for (int i = 2; i <= n; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String content = queue.poll();
                for (int k = 0; k <= content.length(); k++) {
                    for (int l = k; l <= content.length(); l++) {
                        String newContent = content.substring(0, k) + "(" + content.substring(k, l) + ")" + content
                                .substring(l, content.length());
                        //                        System.out.println("newContent:" + newContent);
                        if (isValid(newContent)) {
                            //                            System.out.println("valid newContent:" + newContent);
                            set.add(newContent);
                        }
                    }
                }
            }
            set.stream().forEach(e -> {
                queue.add(e);
            });
            set = new HashSet<>();
        }
        //        System.out.println("set:" + set);
        res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        globalMap.put(n, res);
        //        System.out.println("res:" + res);
        return res;
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
