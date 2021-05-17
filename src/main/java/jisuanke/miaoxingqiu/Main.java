package jisuanke.miaoxingqiu;

import java.util.Scanner;

/**
 * Created by luyan on 2020/9/19.
 */
public class Main {

    public static void main(String[] args) {
        int X;
        int Y;
        int N;
        Scanner input = new Scanner(System.in);
        X = input.nextInt();
        Y = input.nextInt();
        N = input.nextInt();
        float ans = Float.MAX_VALUE;
        ans = dfs(X, Y, N, ans);
        System.out.printf("%.6f", ans);
    }

    public static float dfs(float x, float y, int n, float tempAns) {
        if (n == 1) {
            return x > y ? x / y : y / x;
        } else {
            tempAns = Float.MAX_VALUE;
            for (int i = 1; i <= n / 2; i++) {
                float nextX = x / n * i;
                float nextY = y / n * i;
                tempAns = Math.min(tempAns,
                        Math.max(dfs(nextX, y, i, tempAns), dfs(x - nextX, y, n - i, tempAns)));
                tempAns = Math.min(tempAns,
                        Math.max(dfs(x, nextY, i, tempAns), dfs(x, y - nextY, n - i, tempAns)));

            }
        }
        return tempAns;
    }
}
