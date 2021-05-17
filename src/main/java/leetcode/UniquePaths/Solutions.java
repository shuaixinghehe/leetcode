package leetcode.UniquePaths;

/**
 * Created by luyan on 17/4/23.
 */
public class Solutions {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
        System.out.println(getCombination(4, 2));
        long time = System.currentTimeMillis();
        System.out.println(uniquePaths(51, 9));
        System.out.println(System.currentTimeMillis() - time);

    }

    private static int getCombination(int n, int m) {
        if (m <= 0) {
            return 1;
        }
        if (m == 1 || n - m == 1) {
            return n;
        }
        if (m == n) {
            return 1;
        }
        return getCombination(n - 1, m - 1) + getCombination(n - 1, m);
    }

    public static int uniquePaths(int m, int n) {
        int min = Math.min(m - 1, n - 1);
        return getCombination((n - 1) + (m - 1), min);

    }
}
