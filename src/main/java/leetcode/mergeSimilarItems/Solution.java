package leetcode.mergeSimilarItems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(mergeSimilarItems(new int[][] {
                {1, 1}, {4, 5}, {3, 8}
        }, new int[][] {
                {3, 1},
                {1, 5}
        }));
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            map1.put(items1[i][0], items1[i][1]);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < items2.length; i++) {
            map2.put(items2[i][0], items2[i][1]);
        }

        Set<Integer> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        List<Integer> keysLit = keys.stream().collect(Collectors.toList());
        Collections.sort(keysLit);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < keysLit.size(); i++) {
            Integer key = keysLit.get(i);
            List<Integer> l = new ArrayList<>();

            Integer value = map1.getOrDefault(key, 0) + map2.getOrDefault(key, 0);
            l.add(key);
            l.add(value);
            ret.add(l);
        }

        return ret;
    }
}
