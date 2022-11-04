package leetcode.reachNumber;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(reachNumber(2));
//        System.out.println(reachNumber(3));
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"},
                new String[]{"a", "bc"}));
    }

    public static int reachNumber(int target) {
        int total = 0;
        int i = 0;
        for (; total < target; i++) {
            total += i;
            System.out.println("i:" + i + " total:" + total);
        }

        if (total == target) {
            return i;
        } else {
            return i + Math.abs(total - target);
        }

    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < word1.length; i++) {
            str1 +=word1[i];
        }
        for (int i = 0; i < word2.length; i++) {
            str2 +=word2[i];
        }
        System.out.println(str1);
        System.out.println(str2);
        return str1.equals(str2);
    }
}
