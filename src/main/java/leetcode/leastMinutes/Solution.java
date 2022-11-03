package leetcode.leastMinutes;

public class Solution {
    public static void main(String[] args) {
        System.out.println(leastMinutes(1));
        System.out.println(leastMinutes(2));
        System.out.println(leastMinutes(3));
        System.out.println(leastMinutes(4));
        System.out.println(leastMinutes(5));
        System.out.println(leastMinutes(10));
        System.out.println(leastMinutes(100));
    }

    public static int leastMinutes(int n) {
        int res = n;
        for (int i = 0; i < 20; i++) {
            res = Math.min(res, i + (int) Math.ceil(n * 1.0 / (1 << i)));
        }
        return res;
    }
}
