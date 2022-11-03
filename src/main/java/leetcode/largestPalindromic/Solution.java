package leetcode.largestPalindromic;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(largestPalindromic("444947137"));
        System.out.println(largestPalindromic("0099"));
        System.out.println(largestPalindromic("009"));
        System.out.println(largestPalindromic("00001105"));
        System.out.println(largestPalindromic("846853515384906866969100"));
        //        int n = 10;
        //        Character c = '0';
        //        for ( ;n >=0 ; n--) {
        //            System.out.println(c);
        //            c++;
        //        }
    }

    public static String largestPalindromic(String num) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            map.put(num.charAt(i), map.getOrDefault(num.charAt(i), 0) + 1);
        }

        String res = "";
        //  先找到偶数最大作为开头 非0
        final Character[] firstNum = {'0' - 1};
        map.entrySet().stream().forEach(e -> {
            if (e.getValue() >=2 && e.getKey() != '0') {
                if (e.getKey() > firstNum[0]) {
                    firstNum[0] = e.getKey();
                }
            }
        });
        if (firstNum[0] != '0' - 1) {
            int prelength = (int) Math.floor(map.get(firstNum[0]) / 2);
            for (int i = 0; i < prelength; i++) {
                res += firstNum[0];
            }
            map.put(firstNum[0], map.get(firstNum[0]) - prelength * 2);
        } else {
            map.put('0', 0);
        }

        while (getDoubleMap(map) != '0' - 1) {
            firstNum[0] = getDoubleMap(map);
            int prelength = (int) Math.floor(map.get(firstNum[0]) / 2);
            for (int i = 0; i < prelength; i++) {
                res += firstNum[0];
            }
            map.put(firstNum[0], map.get(firstNum[0]) - prelength * 2);
        }
        firstNum[0] = '0' - 1;
        map.entrySet().stream().forEach(e -> {
            if (e.getValue() % 2 == 1) {
                if (e.getKey() > firstNum[0]) {
                    firstNum[0] = e.getKey();
                }
            }
        });
        String s = "";
        for (int i = res.length() - 1; i >= 0; i--) {
            s += res.charAt(i);
        }
        if (firstNum[0] == '0' - 1) {
            res = res + s;
        } else {
            res = res + firstNum[0] + s;

        }
        if (res.equals("")) {
            res = "0";
        }

        return res;
    }

    // 返回double的map num
    private static Character getDoubleMap(Map<Character, Integer> map) {
        final Character[] firstNum = {'0' - 1};
        map.entrySet().stream().forEach(e -> {
            if ((e.getValue() % 2 == 0 && e.getValue() > 0) || e.getValue() >= 2) {
                if (e.getKey() > firstNum[0]) {
                    firstNum[0] = e.getKey();
                }
            }
        });
        return firstNum[0];
    }
}
