package leetcode.WeeklyContest108;

public class Solution3 {
    public static void main(String[] args) {
        //        System.out.println(minFlips("011"));
        //        System.out.println(minFlips("111000"));
        //        System.out.println(minFlips("1110"));
        System.out.println(minFlips("10001100101000000"));
    }

    public static String getCommonOneString(String s) {
        StringBuilder target = new StringBuilder();
        target.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (target.charAt(target.length() - 1) == s.charAt(i) && s.charAt(i) == '1') {
                StringBuilder oneString = new StringBuilder();
                while (i < s.length()) {
                    oneString.append(s.charAt(i));
                    i++;
                }
                target = new StringBuilder(oneString.toString() + target.toString());
                break;
            } else {
                target.append(s.charAt(i));
            }
        }
        System.out.println("getCommonOneString origin:" + s + " target:" + target.toString());
        return target.toString();
    }

    public static String getCommonZeroString(String s) {
        StringBuilder target = new StringBuilder();
        target.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (target.charAt(target.length() - 1) == s.charAt(i) && s.charAt(i) == '0') {
                StringBuilder oneString = new StringBuilder();
                while (i < s.length()) {
                    oneString.append(s.charAt(i));
                    i++;
                }
                target = new StringBuilder(oneString.toString() + target.toString());
                break;
            } else {
                target.append(s.charAt(i));
            }
        }
        System.out.println("getCommonZeroString origin:" + s + " target:" + target.toString());
        return target.toString();
    }

    public static int getMinFlips(String s) {
        StringBuilder target = new StringBuilder();
        target.append(s.charAt(0));
        int res1 = 0;
        for (int i = 1; i < s.length(); i++) {

            if (target.charAt(target.length() - 1) == s.charAt(i)) {
                res1++;
                if (target.charAt(target.length() - 1) == '0') {
                    target.append('1');
                } else {
                    target.append('0');
                }
            } else {
                target.append(s.charAt(i));
            }
        }
//        System.out.println("s:" + s + " res:" + res1);
        return res1;
    }

    public static int minFlips(String originStr) {
        int res = getMinFlips(originStr);
        for (int i = 0; i < originStr.length(); i++) {
            int res1 = getMinFlips(originStr.substring(i, originStr.length()) + originStr.substring(0, i));
            res = Math.min(res1, res);
        }
        return res;
    }
}
