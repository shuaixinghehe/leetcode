package leetcode.countVowelStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountVowelStrings {
    public static void main(String[] args) {
        System.out.println(countVowelStrings2(42));
    }

//    public static int countVowelStrings(int n) {
//        Set<String> set = new HashSet<>();
//        set.add("a");
//        set.add("e");
//        set.add("i");
//        set.add("o");
//        set.add("u");
//        set = dfs(set, n - 1);
//        return set.size();
//    }

    private static Map<String, Integer> globalMap = new HashMap<>();

    public static int countVowelStrings2(int n) {
        globalMap.put("1_1", 1);
        globalMap.put("1_2", 1);
        globalMap.put("1_3", 1);
        globalMap.put("1_4", 1);
        globalMap.put("1_5", 1);
        int res = 0;
        for (int i = 1; i <= 5; i++) {
            res += dfs(n, i);
        }
        return res;
    }

    // n 是轮次，k是当次的第几个
    private static int dfs(int n, int k) {
        if (n <= 0) {
            return 0;
        }
        if (globalMap.containsKey(n + "_" + k)) {
            return globalMap.get(n + "_" + k);
        } else {
            int res = 0;
            for (int i = k; i <= 5; i++) {
                res += dfs(n - 1, i);
            }
            globalMap.put(n + "_" + k, res);
            return globalMap.get(n + "_" + k);
        }
    }

//    private static Set dfs(Set<String> set, int n) {
//
//        if (n == 0) {
//            System.out.println("set:" + set);
//            return set;
//        } else {
//            Set<String> newSet = new HashSet<>();
//            set.stream().forEach(e -> {
//                if (e.charAt(e.length() - 1) <= 'a') {
//                    newSet.add(e + "a");
//                }
//                if (e.charAt(e.length() - 1) <= 'e') {
//                    newSet.add(e + "e");
//                }
//                if (e.charAt(e.length() - 1) <= 'i') {
//                    newSet.add(e + "i");
//                }
//                if (e.charAt(e.length() - 1) <= 'o') {
//                    newSet.add(e + "o");
//                }
//                if (e.charAt(e.length() - 1) <= 'u') {
//                    newSet.add(e + "u");
//                }
//            });
//            return dfs(newSet, n - 1);
//        }
//    }
}
