package leetcode.LongestStringChain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by luyan on 2019/5/19.
 */
public class Solution {

    private Map<String, Integer> tmpRes = new HashMap<>();
    private Map<String, Integer> finalRes = new HashMap<>();
    private int maxRes = 1;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.longestStrChain(new String[] { "a", "b", "ba", "bca", "bda", "bdca" }));
        solution = new Solution();
        System.out.println(solution.longestStrChain(new String[] { "a", "b" }));
        solution = new Solution();
        System.out.println(solution.longestStrChain(new String[] { "a", "b", "ba" }));
        solution = new Solution();
        System.out.println(solution.longestStrChain(new String[] { "ksqvsyq", "ks", "kss", "czvh",
                "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq",
                "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru" }));
    }

    // str1长度大于str2长度
    // aa aba right
    // aa aaa
    // aa baa
    // aa aab
    // ba bda
    // ab cba wrong
    // ab cab right
    // ab abc right
    // ab acb right
    // str2 通过添加一个字符 等于str1
    private int distance(String str1, String str2) {
        Set<Character> set = new HashSet();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            set.add(str1.charAt(i));
        }
        set.stream().forEach(key -> {
            characters.add(key);
        });
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < characters.size(); j++) {
                StringBuilder stringBuilder = new StringBuilder(str2);
                stringBuilder.insert(i, characters.get(j));
                if (str1.equals(stringBuilder.toString())) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private int calc(List<String> smallList, List<String> bigList) {
        if (smallList == null || bigList == null) {
            return 0;
        }
        for (int i = 0; i < bigList.size(); i++) {
            for (int j = 0; j < smallList.size(); j++) {
                if (distance(bigList.get(i), smallList.get(j)) > 0
                        && finalRes.get(smallList.get(j)) == smallList.get(i).length()) {
                    tmpRes.put(bigList.get(i), 1);
                    tmpRes.put(smallList.get(i), 1);
                }
            }
        }
        tmpRes.keySet().stream().forEach(key -> {
            if (tmpRes.get(key) > 0) {
                finalRes.put(key, key.length());
                maxRes = key.length();
            }
        });
        tmpRes.keySet().stream().forEach(key -> {
            tmpRes.put(key, 0);
        });
        System.out.println(finalRes.toString());
        return 0;
    }

    public int longestStrChain(String[] words) {
        Map<Integer, List<String>> baseMap = new HashMap<>();

        int maxLengthStr = 0;
        for (int i = 0; i < words.length; i++) {
            finalRes.put(words[i], 1);
            maxLengthStr = Math.max(maxLengthStr, words[i].length());
            if (baseMap.containsKey(words[i].length())) {
                baseMap.get(words[i].length()).add(words[i]);
            } else {
                baseMap.put(words[i].length(), new ArrayList<>());
                baseMap.get(words[i].length()).add(words[i]);
            }
        }
        System.out.println("baseMap:" + baseMap);
        for (int i = 0; i < maxLengthStr; i++) {
            calc(baseMap.get(i), baseMap.get(i + 1));
        }

        return maxRes;
    }
}
