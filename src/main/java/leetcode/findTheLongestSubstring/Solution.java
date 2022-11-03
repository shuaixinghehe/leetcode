package leetcode.findTheLongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(findTheLongestSubstring("bcbcbc"));
    }

    public static int findTheLongestSubstring(String s) {
        Map<String, Integer> mem = new HashMap<>();
        Map<Character, Integer> vowelMap = new HashMap<>();
        vowelMap.put('a', 0);
        vowelMap.put('e', 0);
        vowelMap.put('i', 0);
        vowelMap.put('o', 0);
        vowelMap.put('u', 0);
        mem.put("0_0_0_0_0", 0);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowelMap.containsKey(s.charAt(i))) {
                vowelMap.put(s.charAt(i), vowelMap.get(s.charAt(i)) ^ 1);
            }
            String key = map2key(vowelMap);
            if (mem.containsKey(key)) {
                res = Math.max(res, i - mem.get(key));
            } else {
                mem.put(key, i);
            }
            System.out.println(
                    "i:" + i + "charAt(i):" + s.charAt(i) + "  key:" + key + " res:" + res + " map:" + mem);


        }
        return res + 1;
    }

    private static String map2key(Map<Character, Integer> map) {
        //  a e i o u 是否是偶数 1 是  0 不是
        return map.getOrDefault('a', 1) + "_"
                + map.getOrDefault('e', 1) + "_"
                + map.getOrDefault('i', 1) + "_"
                + map.getOrDefault('o', 1) + "_"
                + map.getOrDefault('u', 1);

    }
}
