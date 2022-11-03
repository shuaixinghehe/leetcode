package leetcode.letterCombinations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("3"));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("3467"));
    }

    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        Queue<String> queue = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int num = Integer.valueOf(digits.charAt(i) + "");
            int size = queue.size();
            if (size == 0) {
//                System.out.println("num:" + num + " map:" + map);
                for (int k = 0; k < map.get(num).length(); k++) {
                    queue.add(map.get(num).charAt(k) + "");
                }
            } else {
                for (int j = 0; j < size; j++) {
                    String s = queue.poll();
                    for (int k = 0; k < map.get(num).length(); k++) {
                        queue.add(s + map.get(num).charAt(k));
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }
}
