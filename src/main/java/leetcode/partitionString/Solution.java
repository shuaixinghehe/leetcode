package leetcode.partitionString;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                set = new HashSet<>();
                res++;
                set.add(s.charAt(i));
            }
        }
        if (set.size()>0){
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionString("abacaba"));
        System.out.println(partitionString("ssssss"));
    }
}
