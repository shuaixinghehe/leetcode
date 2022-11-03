package leetcode.substringsSizeThreeDistinctCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aa"));
    }

    public static int countGoodSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 3 && i + j < s.length(); j++) {
                set.add(s.charAt(i + j));
            }
            if (set.size() == 3) {
                res++;
            }
        }
        return res;
    }
}
