package leetcode.lcsMaxProduct;


public class Solution {
    public static void main(String[] args) {
        System.out.println(maxProduct("leetcodecom"));
        System.out.println(maxProduct("accbcaxxcxx"));
        System.out.println(maxProduct("bb"));
    }

    public static int maxProduct(String str) {
        int res = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }

        lcs(str, builder.toString());
        return res;
    }

    public static void lcs(String str1, String str2) {
        Node[][] dp = new Node[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = new Node(str2.charAt(j-1) + "", 0);

            }
        }
        System.out.println("str1:" + str1);
        System.out.println("str2:" + str2);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j].index = Math.max(dp[i][j].index, dp[i - 1][j - 1].index + 1);
                    dp[i][j].str += dp[i][j].index > dp[i - 1][j - 1].index ? dp[i][j].str : dp[i - 1][j - 1].str;
                } else {
                    dp[i][j].index = Math.max(dp[i - 1][j].index, dp[i][j - 1].index);
                    dp[i][j].str = dp[i - 1][j].index > dp[i][j - 1].index ? dp[i - 1][j].str : dp[i][j - 1].str;
                }

            }
        }
        System.out.println("dp:");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Node {
        public String str;
        public int index;

        public Node(String str, int index) {
            this.str = str;
            this.index = index;
        }

        public Node() {
            this.str = "";
            this.index = 0;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "str='" + str + '\'' +
                    ", index=" + index +
                    '}';
        }
    }
}
