package leetcode.idealArrays;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int idealArrays(int n, int maxValue) {
        List list = dfs(n, maxValue);
        //        System.out.println(list);
        System.out.println(list.size() % (10000_0000_0 + 7));
        return list.size() % (10000_0000_0 + 7);
    }

    public static List<List<Integer>> dfs(int n, int maxValue) {
        if (n == 1) {
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 1; i <= maxValue; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                lists.add(list);
            }
            return lists;
        } else {
            List<List<Integer>> list = dfs(n - 1, maxValue);
            List<List<Integer>> newList = new ArrayList<>();
            for (int i = 1; i <= maxValue; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).size() < n) {
                        List<Integer> temp = new ArrayList<Integer>(list.get(j));
                        //                        temp.add(i);
                        if (i % temp.get(temp.size() - 1) == 0) {
                            temp.add(i);
                            newList.add(temp);
                        }
                    }

                }
            }
            return newList;
        }
    }


    public static void main(String[] args) {
        //        idealArrays(2, 5);
        //        idealArrays(5, 3);
        //        idealArrays(37, 71);
        long startTime = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100000; j++) {
                a = j;
            }
            a = a + i;
        }
        System.out.println(a);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
