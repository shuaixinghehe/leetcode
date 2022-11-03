package leetcode.fillCups;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solutions {
    public static int fillCups(int[] amount) {
        int cnt = 0;
        while (!(amount[0] == 0 && amount[1] == 0 && amount[2] == 0)) {
            Arrays.sort(amount);
            if (amount[2] > 0) {
                amount[2] = amount[2] - 1;
            }
            if (amount[1] > 0) {
                amount[1] = amount[1] - 1;
            }
            cnt++;
        }
        //        System.out.println(cnt);
        return cnt;
    }

    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
        put(1, 1);
        put(2, 2);


    }};

    static {
        for (int i = 3; i <= 45; i++) {
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int value = fib(n - 1) + fib(n - 2);
        map.put(n, value);
        return value;
    }


    public static int tribonacci(int n) {
        return map.get(n);
    }

    public static int climbStairs(int n) {
        return map.get(n);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 0; i < cost.length; i++) {
            dp[i] = cost[i];
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + dp[i];
        }
        //        for (int i = 0; i < dp.length; i++) {
        //            System.out.print(dp[i]+" ");
        //        }
        //        System.out.println();
        return dp[cost.length];
    }

    public static int deleteAndEarn(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + arr[i]);
        }
//        map.entrySet().stream().forEach(e -> {
//            System.out.println(e);
//        });
        List<Entry<Integer, Integer>> list = map.entrySet().stream().collect(Collectors.toList());
        Collections.sort(list, Comparator.comparing(Entry::getKey));
        int[] dp = new int[list.size() + 1];
//        System.out.println(list);

        // 只有一个
        if (list.size() == 1) {
            return map.get(list.get(0).getKey());
        }

        // 只有两个
        if (list.size() == 2) {
            if (list.get(1).getKey() - list.get(0).getKey() == 1) {
                return Math.max(list.get(0).getValue(),
                        list.get(1).getValue());
            } else {
                return list.get(0).getValue() + list.get(1).getValue();
            }
        }
        dp[0] = map.get(list.get(0).getKey());

        if (list.get(1).getKey() - list.get(0).getKey() == 1) {
            dp[1] = Math.max(list.get(1).getValue(), list.get(0).getValue());
        } else {
            dp[1] = dp[0] + list.get(1).getValue();
        }
        // 3个及以上
        for (int i = 2; i < list.size(); i++) {
            int key = list.get(i).getKey();
            if (map.containsKey(key - 1)) {
                dp[i] = Math.max(dp[i - 1], map.get(key) + dp[i - 2]);
            } else {
                dp[i] = map.get(key) + dp[i - 1];
            }
        }
        return dp[list.size()-1];
    }

    public static void main(String[] args) {
        //        fillCups(new int[]{1,4,2});
        //        fillCups(new int[]{5,4,4});
        //        fillCups(new int[]{5,0,0});
        //        System.out.println(climbStairs(30));
        //        System.out.println(climbStairs(4));
        //        System.out.println(climbStairs(5));
        //        System.out.println(climbStairs(10));
        //        System.out.println(minCostClimbingStairs(new int[] {1, 100, 1}));
        System.out.println(deleteAndEarn(new int[] {1, 100, 1, 2, 3, 4, 2, 12, 3, 3, 1}));
        System.out.println(deleteAndEarn(new int[] {3,4,2}));
        System.out.println(deleteAndEarn(new int[] {2,3,3}));
        System.out.println(deleteAndEarn(new int[] {2,2,3,3,3,4}));
        System.out.println(deleteAndEarn(new int[] {3,}));
        System.out.println(deleteAndEarn(new int[] {3,3}));
        System.out.println(deleteAndEarn(new int[] {3,4}));
        System.out.println(deleteAndEarn(new int[] {3,5}));
        //        System.out.println(deleteAndEarn(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
