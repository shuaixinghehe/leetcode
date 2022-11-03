package leetcode.halfQuestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(halfQuestions(new int[] {2, 1, 6, 2}));
    }

    public static int halfQuestions(int[] questions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < questions.length; i++) {
            map.put(questions[i], map.getOrDefault(questions[i], 0) + 1);
        }
        List<Integer> value = map.values().stream().collect(Collectors.toList());
        Collections.sort(value);
        //        Collections.sort(map,new Comparator<>());
        int num = questions.length;
        int res = 0;
        for (int i = value.size() - 1; i >= 0; i--) {
            if (num <= 0) {
                break;

            }
            num = num - value.get(i);
            res++;

        }
        return res;
    }
}
