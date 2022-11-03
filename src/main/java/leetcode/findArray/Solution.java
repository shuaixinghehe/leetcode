package leetcode.findArray;

public class Solution {
    public static void main(String[] args) {

        System.out.println(5 ^ 2);
        System.out.println(5 ^ 7);
        System.out.println(findArray(new int[] {5, 2, 0, 3, 1}));
        System.out.println(findArray(new int[] {13}));
    }

    public static int[] findArray(int[] pref) {
        int[] res = new int[pref.length];

        res[0] = pref[0];
        int n = res[0];
        for (int i = 1; i < pref.length; i++) {
            res[i] = n ^ pref[i];
            n = n ^ res[i];
        }
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + ",");
//        }
//        System.out.println();
        return res;
    }
}
