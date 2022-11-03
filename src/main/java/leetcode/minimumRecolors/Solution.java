package leetcode.minimumRecolors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(minimumRecolors("WBWBBBW", 2));
    }

    public static int minimumRecolors(String blocks, int k) {

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < blocks.length() - k + 1; i++) {
            int t = 0;
            for (int j = 0; j < k && i + j < blocks.length(); j++) {
                if (blocks.charAt(i + j) == 'W') {
                    t++;
                }
            }
            res = Math.min(t, res);
        }
        return res;
    }
}
