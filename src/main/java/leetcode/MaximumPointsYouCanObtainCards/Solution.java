package leetcode.MaximumPointsYouCanObtainCards;

public class Solution {

    //    There are several cards arranged in a row, and each card has an
    //    associated number of points. The points are given in the integer array cardPoints.
    //
    //    In one step, you can take one card from the beginning or from the
    //    end of the row. You have to take exactly k cards.
    //
    //    Your score is the sum of the points of the cards you have taken.
    //
    //    Given the integer array cardPoints and the integer k, return the
    //    maximum score you can obtain.
    //
    //
    //
    //    Example 1:
    //
    //    Input: cardPoints = [1,2,3,4,5,6,1], k = 3
    //    Output: 12
    //    Explanation: After the first step, your score will always be 1. However,
    //    choosing the rightmost card first
    //    will maximize your total score. The optimal strategy is to take the
    //    three cards on the right, giving a
    //    final score of 1 + 6 + 5 = 12.
    //    Example 2:
    //
    //    Input: cardPoints = [2,2,2], k = 2
    //    Output: 4
    //    Explanation: Regardless of which two cards you take, your score will always be 4.
    //    Example 3:
    //
    //    Input: cardPoints = [9,7,7,9,7,7,9], k = 7
    //    Output: 55
    //    Explanation: You have to take all the cards. Your score is the sum of points of all cards.
    //    Example 4:
    //
    //    Input: cardPoints = [1,1000,1], k = 1
    //    Output: 1
    //    Explanation: You cannot take the card in the middle. Your best score is 1.
    //    Example 5:
    //
    //    Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
    //    Output: 202
    //1 <= cardPoints.length <= 105
    //            1 <= cardPoints[i] <= 104
    //            1 <= k <= cardPoints.length
    private static Long maxValue = 0L;

    public static void main(String[] args) {
        System.out.println(maxScore2(new int[] {1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(maxScore2(new int[] {1, 2, 3, 4, 5, 6, 1}, 7));
        System.out.println(maxScore2(new int[] {1, 1000, 1}, 1));
        System.out.println(maxScore2(new int[] {1, 1000, 1}, 2));
        System.out.println(maxScore2(new int[] {1, 1000, 1}, 3));
        System.out.println(maxScore2(new int[] {1,}, 1));
        System.out.println(maxScore2(new int[] {1, 79, 80, 1, 1, 1, 200, 1}, 3));
        System.out.println(maxScore2(
                new int[] {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24,
                        92, 67, 18,
                        37, 37, 60, 87, 28, 64, 7, 29}, 27));
    }

    public static int maxScore(int[] cardPoints, int k) {
        maxValue = 0L;
        dfs(0, cardPoints, k, 0, -1, cardPoints.length);
        return Math.toIntExact(maxValue);
    }

    public static int maxScore2(int[] cardPoints, int k) {
        maxValue = 0L;
        int[] preSum = new int[cardPoints.length + 1];
        int[] suffixSum = new int[cardPoints.length + 1];
        for (int i = 0; i < cardPoints.length; i++) {
            preSum[i + 1] = cardPoints[i] + preSum[i];
        }
        for (int i = cardPoints.length - 1; i >= 0; i--) {
            suffixSum[i] = cardPoints[i] + suffixSum[i + 1];
        }
        //        System.out.print("preSum:");
        //        for (int i = 0; i < preSum.length; i++) {
        //            System.out.print(preSum[i] + ",");
        //        }
        //        System.out.println();
        //        System.out.print("suffixSum:");
        //        for (int i = 0; i < preSum.length; i++) {
        //            System.out.print(suffixSum[i] + ",");
        //        }
        //        System.out.println();
        long maxVal = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (i <= k + 1 && k - i >= 0) {
                //                System.out.println("i:" + i + " suffixSum.length - 1 - (k - i)" + (suffixSum.length
                //                - 1 - (k - i)));
                maxVal = Math.max(maxVal, preSum[i] + suffixSum[suffixSum.length - 1 - (k - i)]);
            }
        }

        return Math.toIntExact(maxVal);
    }

    public static void dfs(int preSum, int[] cardPoints, int k, int times, int leftIndex, int rightIndex) {
        if (times > k) {
            return;
        } else if (leftIndex < rightIndex) {
            maxValue = Math.max(preSum, maxValue);
            if (leftIndex + 1 < cardPoints.length) {
                dfs(preSum + cardPoints[leftIndex + 1], cardPoints, k, times + 1, leftIndex + 1, rightIndex);
            }
            if (rightIndex - 1 >= 0) {
                dfs(preSum + cardPoints[rightIndex - 1], cardPoints, k, times + 1, leftIndex, rightIndex - 1);
            }
        }
    }
}
