package leetcode.getLucky;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
        System.out.println(getLucky("leetcode", 2));
        System.out.println(getLucky("zbax", 2));
    }

    public static int getLucky(String s, int k) {
        String nums = new String();
        for (int i = 0; i < s.length(); i++) {
            nums += ((s.charAt(i) - 'a') + 1) + "";
        }
//        System.out.println("nums:" + nums);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = 0;
            for (int j = 0; j < nums.length(); j++) {
                res += (nums.charAt(j) - '0');
            }
            nums = res + "";
//            System.out.println("nums:" + nums);
        }
        return res;
    }
}
