package leetcode.week248;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public static void main(String[] args) {
        //        System.out.println(countGoodNumbers(1));
        System.out.println(countGoodNumbers(4));
        System.out.println(countGoodNumbers(5));
        System.out.println(countGoodNumbers(10));
        System.out.println(countGoodNumbers(50));
        System.out.println(countGoodNumbers(55));
        System.out.println(countGoodNumbers(1000));
        //                System.out.println(countGoodNumbers(806166225460393L));
        //        System.out.println(dfs(1));
        System.out.println(dfs(4));
        System.out.println(dfs(5));
        System.out.println(dfs(10));
        System.out.println(dfs(50));
        System.out.println(dfs(55));
        System.out.println(dfs(1000));
        System.out.println(dfs(806166225460393L));
    }

    private static Map<Long, Long> map = new HashMap<>();
    private static Integer MOD = 1000_000_007;


    public static int countGoodNumbersII(long n) {
        int odd = 4;
        int even = 5;
        long res = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res = (res * even) % MOD;
            } else {
                res = (res * odd) % MOD;
            }
        }
        return Math.toIntExact(res);
    }

    public static int countGoodNumbers(long n) {
        return Math.toIntExact(dfs(n));
    }


    private static long dfs(long n) { // n 代表第几位
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 1) {
            return 5;
        } else if (n == 2) {
            return 4 * 5;
        } else if (n % 2 == 0) {

            long index = n / 2;
            long value1 = (dfs(n / 2) % MOD);
            if (index % 2 == 0) {
                long value = (value1 * value1) % MOD;
                map.put(n, value);
                map.put(n / 2, value1);
                return value;
            } else {
                long value2 = ((dfs(n / 2 - 1)) * 4) % MOD;
                long value = (value1 * value2) % MOD;
                map.put(n, value);
                return value;
            }

        } else {
            long value1 = (dfs((long) Math.floor(n * 1.0 / 2)) % MOD);
            long value2 = (dfs((long) Math.ceil(n * 1.0 / 2)) % MOD);
            long value = (value1 * value2) % MOD;
            //            System.out.println("n:" + n + " value1:" + value1 + " value2:" + value2);
            map.put((long) Math.floor(n * 1.0 / 2), value1);
            map.put((long) Math.ceil(n * 1.0 / 2), value2);
            map.put(n, value);
            return value;
        }
    }
}
