package leetcode.MaximumLengthofRepeatedSubarray;

/**
 * Created by luyan on 17/10/29.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out
                .println(main.findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7 }));

    }

    public int findLength(int[] A, int[] B) {
        int[][] metrics = new int[A.length + 1][B.length + 1];
        /*        for (int i = 0; i < metrics.length; i++) {
            for (int j = 0; j < metrics[i].length; j++) {
                System.out.print(metrics[i][j] + " ");
            }
            System.out.println();
        }*/
        int maxCnt = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    metrics[i + 1][j + 1] = metrics[i][j] + 1;
                    maxCnt = Math.max(maxCnt, metrics[i + 1][j + 1]);
                }
            }
        }
        //        System.out.println("---");
        //        for (int i = 0; i < metrics.length; i++) {
        //            for (int j = 0; j < metrics[i].length; j++) {
        //                System.out.print(metrics[i][j] + " ");
        //            }
        //            System.out.println();
        //        }
        return maxCnt;
    }
    /*    public int findLength(int[] A, int[] B) {
        int[] longArray = A.length > B.length ? A : B;
        int[] shortArray = A.length <= B.length ? A : B;
        int maxCnt = 0;
        for (int i = 0; i < longArray.length; i++) {
            int cnt = 0;
            for (int j = 0; j < shortArray.length; j++) {
                if (longArray[i + j] == shortArray[j]) {
                    cnt++;
                } else {
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 0;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }*/

}
