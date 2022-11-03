package leetcode.week248;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {
    public static void main(String[] args) {
        //        System.out.println(longest("1243", "143"));
        //        System.out.println(longestInt(new int[] {0, 1, 2, 3, 4}, new int[] {4, 2, 3, 5}));
        System.out.println(longestInt(new int[] {1, 2, 3, 4}, new int[] {4, 1, 2, 3}));

    }

    public static int longestCommonSubpath(int n, int[][] paths) {
        int[] res = longestInt(paths[0], paths[1]);

        if (res == null || res.length == 0) {
            return 0;
        }

        for (int i = 0; i < paths.length; i++) {

        }
        LinkedList<List<Integer>> deque = new LinkedList<>();
        deque.addFirst(toIntegerList(paths[0]));
        for (int i = 1; i < paths.length; i++) {
            if (paths[i].length>=deque.getFirst().size()){
                deque.addFirst(toIntegerList(paths[i]));
            }
        }
        for (int i = 2; i < paths.length; i++) {
            res = longestInt(res, paths[i]);
            if (res == null || res.length == 0) {
                return 0;
            }
        }
        return res.length;
    }

    private static List<Integer> toIntegerList(int[] num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            list.add(num[i]);
        }
        return list;
    }

    public static String longest(String s1, String s2) {

        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();

        int length1 = ch1.length;
        int length2 = ch2.length;
        /*
        这里其实还可以考虑一下那个数组较长，在下面创建mat数组时可以节省一点空间，在两个数组长度相差较大时能节省较多空间。
        */
        int max = 0;
        int sign = 0;
        int[] mat = new int[length1];

        for (int i = 0; i < length2; i++) {
            for (int j = length1 - 1; j >= 0; j--) {
                if (ch2[i] == ch1[j]) {
                    if (i == 0 || j == 0) {
                        mat[j] = 1;
                        if (max == 0) {
                            max = 1;
                            sign = j;
                        }
                    } else {
                        mat[j] = mat[j - 1] + 1;
                        if (mat[j] > max) {
                            max = mat[j];
                            sign = j;
                        }
                    }
                } else {
                    mat[j] = 0;
                }
            }
        }
        return new String(ch1, sign - max + 1, max);
    }

    public static int[] longestInt(int[] s1, int[] s2) {

        int length1 = s1.length;
        int length2 = s2.length;
        /*
        这里其实还可以考虑一下那个数组较长，在下面创建mat数组时可以节省一点空间，在两个数组长度相差较大时能节省较多空间。
        */
        int max = 0;
        int sign = 0;
        int[] mat = new int[length1];

        for (int i = 0; i < length2; i++) {
            for (int j = length1 - 1; j >= 0; j--) {
                if (s2[i] == s1[j]) {
                    if (i == 0 || j == 0) {
                        mat[j] = 1;
                        if (max == 0) {
                            max = 1;
                            sign = j;
                        }
                    } else {
                        mat[j] = mat[j - 1] + 1;
                        if (mat[j] > max) {
                            max = mat[j];
                            sign = j;
                        }
                    }
                } else {
                    mat[j] = 0;
                }
            }
        }
        int[] res = new int[max];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            res[i] = s1[sign - max + 1 + i];
            list.add(res[i]);
        }
        System.out.println("list:" + list);
        return res;
    }
}
