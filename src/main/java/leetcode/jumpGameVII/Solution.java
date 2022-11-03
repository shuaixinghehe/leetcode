package leetcode.jumpGameVII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != '0') {
            return false;
        }
        Set<Integer> set = new HashSet<>(); // 存储的是可到达的 0的位置
        set.add(0);
        List<Integer> zeroPos = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroPos.add(i);
            }
        }
        for (int i = 1; i < zeroPos.size(); i++) {
            int currentZeroPos = zeroPos.get(i);
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') { // 到达了i点
                // 判断i前之前的 minJump 到maxJump中是否可以有到达的
                //                System.out.println("reach " + i + " current scope:" + (i - maxJump) + " " + (i +
                //                maxJump));
                for (int current = Math.max(i - maxJump, 0); current <= i; current++) {
                    if (current < 0) {
                        continue;
                    }
                    if (set.contains(current)) {
                        if (i - current >= minJump && i - current <= maxJump) {
                            set.add(i);
                            break;
                        }
                    }
                }
                //                if (i - stack.peek() >= minJump && i - stack.peek() <= maxJump) {
                //                    stack.push(i);
                //                System.out.println("reach " + i + " set:" + set);
                //                }
            }
        }
        if (set.contains(s.length() - 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canReach("0000000000", 2, 5));
        System.out.println(canReach("011010", 2, 3));
        System.out.println(canReach("01101110", 2, 3));
    }
}
