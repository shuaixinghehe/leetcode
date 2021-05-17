package leetcode.BestTimeBuySellStock;

/**
 * Created by luyan on 17/2/12.
 */
public class Solutions {

    public static void main(String[] args) {
        int[] a = { 7, 6, 5, 4, 3, 2, 1 };
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int sofarMin = prices[0];

        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < sofarMin) {
                sofarMin = prices[i];
            } else {
                profit = prices[i] - sofarMin;
                max = profit > max ? profit : max;
            }
        }
        return max;
    }
}
