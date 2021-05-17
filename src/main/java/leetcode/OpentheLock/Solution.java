package leetcode.OpentheLock;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luyan on 17/12/24.
 */
public class Solution {

    int length = Integer.MAX_VALUE;
    Set<String> set = new HashSet<>();
    String target;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202");
        System.out.println(a);
    }

    public int openLock(String[] deadends, String target) {
        for (int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
            this.target = target;
        }
        //        dfs(0, 0, 0, 0, 0);
        return this.length;
    }

    public void dfs(int a, int b, int c, int d, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        String nowCode = stringBuilder.append(a).append(b).append(c).append(d).toString();
        if (nowCode.equals(target)) {
            this.length = Math.min(this.length, length);
            return;
        }
        if (set.contains(nowCode)) {
            return;
        }
        if (String.valueOf(a).equals(target.charAt(0)) || String.valueOf(b).equals(target.charAt(1))
                || String.valueOf(c).equals(target.charAt(2))
                || String.valueOf(d).equals(target.charAt(3))) {
            return;
        }
        dfs((a + 1) % 10, b, c, d, length + 1);
        dfs((a - 1) + 10 % 10, b, c, d, length + 1);
        dfs(a, ((b - 1) + 10) % 10, c, d, length + 1);
        dfs(a, b, (c + 1) % 10, d, length + 1);
        dfs(a, b, c, (d + 1) % 10, length + 1);

    }
}
