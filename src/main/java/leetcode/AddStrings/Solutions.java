package leetcode.AddStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by luyan on 17/1/28.
 */
public class Solutions {

    public static void main(String[] args) {

        //        System.out.println(addStrings("1111111111", "33333333333333333333333"));
        //        System.out.println(addStrings("11111", "99999"));
        //        System.out.println(oddString(new String[] {"adc", "wzy", "abc"}));
        //        System.out.println(oddString(new String[] {"aaa", "bob", "ccc", "ddd"}));
        //        System.out.println(twoEditWords(new String[] {"word", "note", "ants", "wood"},
        //                new String[] {"wood", "joke", "moat"}));
        //
        //        System.out.println(twoEditWords(new String[] {"yes"},
        //                new String[] {"no"}));
        //
        //        System.out.println(twoEditWords(new String[] {"tsl", "sri", "yyy", "rbc", "dda", "qus", "hyb",
        //        "ilu", "ahd"},
        //                new String[] {"uyj", "bug", "dba", "xbe", "blu", "wuo", "tsf", "tga"}));
        //        System.out.println(destroyTargets(new int[] {3, 7, 8, 1, 1, 5}, 2));
        //        System.out.println(destroyTargets(new int[] {1, 3, 5, 2, 4, 6}, 2));
        //        System.out.println(destroyTargets(new int[] {6, 2, 5}, 100));
        //        System.out.println(destroyTargets(
        //                new int[] {625879766, 235326233, 250224393, 501422042, 683823101, 948619719, 680305710,
        //                733191937,
        //                        182186779, 353350082}, 4));
        System.out.println(secondGreaterElement(new int[] {2, 4, 0, 9, 6}));
        System.out.println(secondGreaterElement(new int[] {3,3}));
    }

    public static String addStrings(String num1, String num2) {
        int num1_index = 0;
        int num2_index = 0;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (num1_index = num1.length() - 1, num2_index = num2.length() - 1;
                num1_index >= 0 || num2_index >= 0 || carry > 0; num1_index--, num2_index--) {
            int x = num1_index < 0 ? 0 : num1.charAt(num1_index) - '0';
            int y = num2_index < 0 ? 0 : num2.charAt(num2_index) - '0';
            int value = (x + y + carry);
            res.append(value % 10);
            carry = value / 10;
        }
        return res.reverse().toString();
    }

    public static String oddString(String[] words) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String value = "";
            for (int j = 1; j < words[i].length(); j++) {
                value = value + "|" + (words[i].charAt(j) - words[i].charAt(j - 1));
            }
            map.put(value, map.getOrDefault(value, "") + words[i]);
        }
        //        System.out.println(map);
        List<String> list = map.values().stream().collect(Collectors.toList());
        if (list.get(0).length() > list.get(1).length()) {
            return list.get(1);
        } else {
            return list.get(0);
        }
    }

    public static boolean editTimesAllow(String s1, String target) {
        if (s1.length() != target.length()) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != target.charAt(i)) {
                cnt++;
            }
        }
        if (cnt > 2) {
            return false;
        }
        return true;
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            set.add(dictionary[i]);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (set.contains(queries[i])) {
                res.add(queries[i]);
            } else {
                for (int j = 0; j < dictionary.length; j++) {
                    if (editTimesAllow(queries[i], dictionary[j])) {
                        res.add(queries[i]);
                        break;
                    }
                }
            }

        }

        return res;

    }


    public static int destroyTargets(int[] nums, int space) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i] % space;
            if (map.keySet().contains(value)) {
                map.get(value).add(nums[i]);
            } else {
                map.put(value, new ArrayList<>());
                map.get(value).add(nums[i]);
            }
        }
        //        System.out.println(map);
        final int[] maxNum = {0};
        map.entrySet().stream().forEach(entry -> {
            Collections.sort(entry.getValue());
            //            System.out.println(entry);
            maxNum[0] = Math.max(maxNum[0], entry.getValue().size());
        });
        final int[] minValue = {Integer.MAX_VALUE};

        map.entrySet().stream().forEach(entry -> {
            if (maxNum[0] == entry.getValue().size()) {
                minValue[0] = Math.min(entry.getValue().get(0), minValue[0]);
            }
        });
        return minValue[0];
    }

    public static int findValue(List<Integer> list, int target) {
        Collections.reverse(list);
        int value = -1;
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > target) {
                cnt++;
            }
            if (cnt == 2) {
                value = list.get(i);
                break;
            }
        }
//        System.out.println("value:" + value + " list:" + list + " target:" + target);
        Collections.reverse(list);
        return value;

    }

    public static int[] secondGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        List<Integer> list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (list.size() < 2) {
                list.add(nums[i]);
                res[i] = -1;
            } else {
                res[i] = findValue(list, nums[i]);
                list.add(nums[i]);
            }
        }
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + ",");
//        }
//        System.out.println();
        return res;
    }
}
