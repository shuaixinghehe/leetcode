package leetcode.ArithmeticSlices;

/**
 * Created by luyan on 17/3/8.
 */
public class Solutions {

    public static void main(String[] args) {
        int[] A = { 1, 3, 5, 7, 9};
        System.out.println(numberOfArithmeticSlices(A));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length<3)
        {
            return 0;
        }
        int[] gap = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            gap[i - 1] = A[i] - A[i - 1];
        }

        int sameCount = 1;
        int res = 0;
        for (int i = 1; i < gap.length; i++) {
            if (gap[i] == gap[i - 1]) {
                sameCount++;
            } else {
                res += (int) calc(sameCount);
                sameCount = 1;
            }
        }
        res += (int) calc(sameCount);
        return res;
    }



    private static int calc(int n) {
        int res = 0;
        n = n + 1;
        if (n < 3) {
            return res;
        }
        if (n == 3) {
            return 1;
        }

        for (int i = 1; i <= n - 2; i++) {
            res += i;
        }
        return res;
    }
}
