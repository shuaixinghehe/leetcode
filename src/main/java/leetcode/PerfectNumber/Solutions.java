package leetcode.PerfectNumber;

/**
 * Created by luyan on 17/3/26.
 */
public class Solutions {
    public static boolean checkPerfectNumber(int num) {
        boolean res = false;
        int sum = num-1;

        for (int i = 2; i < Math.sqrt(num * 1.0) ; i++) {
            if (num % i == 0) {
                sum = sum - i - (num / i);
            }
        }
        if (sum == 0) {
            res = true;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(6));
    }
}
