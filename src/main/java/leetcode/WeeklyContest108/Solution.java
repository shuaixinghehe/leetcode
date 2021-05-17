package leetcode.WeeklyContest108;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by luyan on 2018/10/28.
 */
public class Solution {

    public static void main(String[] args) {
        String[] emails = new String[] { "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" };
        int[] A = new int[] { 0, 0, 0, 0, 0 };
        int S = 0;
        int[][] B = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Solution solution = new Solution();
        //        solution.numUniqueEmails(emails);
        System.out.println(solution.numSubarraysWithSum3(A, S));
        A = new int[] { 1, 0, 1, 0, 1 };
        System.out.println(solution.numSubarraysWithSum3(A, 2));
        A = new int[] { 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1 };
        System.out.println(solution.numSubarraysWithSum3(A, 5));
        A = new int[] { 0, 1, 0, 1, 0, 1, 0 };
        System.out.println(solution.numSubarraysWithSum3(A, 2));

        //        solution.numSubarraysWithSum(A, S);
        //        solution.minFallingPathSum(B);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.stream().filter(integer -> integer % 7 == 0);

        System.out.println(list);
        List<Long> authors = Arrays.asList(66093001L, 1313093740L, 73045569L, 967478155L,
                1138438282L, 1445222343L, 768384658L, 17283428L, 912516388L, 1542723340L,
                677571189L, 1166713360L, 1285530747L, 368281255L, 1384978806L, 1701126126L,
                959659436L, 58624021L, 385360776L, 602635032L);
        authors = new ArrayList<>(authors);
        for (long i = 0; i < 10000; i++) {
            authors.add(i);
        }
        System.out.println(authors);

        for (int i = 0; i < 32; i++) {
            //            System.out.println(5 & (1 << i));
            //            System.out.println((1 << i) - 1);
            System.out.println(i + " " + Integer.bitCount(i));

        }

        System.out.println(Integer.bitCount(1073741823));
        System.out.println(Integer.bitCount(3));
        System.out.println(Integer.bitCount(5));
        System.out.println(Integer.bitCount(5));
        String needFields = "1,2,3,4,5";
        List<Integer> fileldsList = Arrays.asList(needFields.split(",")).stream()
                .map(e -> Integer.valueOf(e)).collect(Collectors.toList());
        System.out.println(fileldsList);
        System.out
                .println(fileldsList.stream().filter(e -> e % 2 == 0).collect(Collectors.toList()));


        System.out.println("并行测试");

    }

    public static int num4min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> emailAddressSet = new HashSet<>();
        for (String email : emails) {
            String name = email.split("@")[0];
            String domain = email.split("@")[1];
            name = name.substring(0, name.indexOf("+"));
            name = name.replaceAll("\\.", "");
            emailAddressSet.add(name + "@" + domain);
        }
        //        emailAddressSet.stream().forEach(e -> {
        //            System.out.println(e);
        //        });
        return emailAddressSet.size();
    }

    public int numSubarraysWithSum(int[] A, int S) {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while (left < A.length && right < A.length) {
            if (sum < S) {
                sum += A[right];
                right++;
            }
            if (sum > S) {
                sum -= A[left];
                left++;
            }
            if (sum == S) {
                System.out.println("left:" + left + " right:" + right);
                count++;
                sum -= A[left];
                left++;

            }
        }
        System.out.println(count);
        return count;
    }

    public int numSubarraysWithSum2(int[] A, int S) {
        int count = 0;
        int[] leftSum = new int[A.length + 1];
        int[] rightSum = new int[A.length + 1];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            leftSum[i] = i == 0 ? A[0] : leftSum[i - 1] + A[i];
            sum += A[i];
        }
        for (int i = leftSum.length - 2; i >= 0; i--) {
            leftSum[i + 1] = leftSum[i];
        }
        leftSum[0] = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            rightSum[i] = i == A.length - 1 ? A[A.length - 1] : rightSum[i + 1] + A[i];
        }
        rightSum[rightSum.length - 1] = 0;
        //        for (int i = 0; i < leftSum.length; i++) {
        //            System.out.print(leftSum[i] + " ");
        //        }
        //        System.out.println();
        //        for (int i = 0; i < rightSum.length; i++) {
        //            System.out.print(rightSum[i] + " ");
        //        }
        for (int i = 0; i < leftSum.length; i++) {
            for (int j = i + 1; j < rightSum.length; j++) {
                if (sum - (rightSum[j] + leftSum[i]) == S) {
                    //                    System.out.println("left:" + i + " right:" + j);
                    count++;
                }
            }
        }
        System.out.println();
        System.out.println(count);
        return count;
    }

    public int numSubarraysWithSum3(int[] A, int S) {
        int count = 0;
        int[] preSum = new int[A.length];
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            preSum[i] = sum;
            if (map.getOrDefault(preSum[i] - S, -1) != -1) {
                count += map.get(preSum[i] - S);
            }
            if (preSum[i] == S) {
                count += 1;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return count;
    }

    public int minFallingPathSum(int[][] A) {
        int[][] result = new int[A.length + 2][A[0].length + 2];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < result.length - 1; i++) {
            for (int j = 1; j < result[0].length - 1; j++) {
                result[i][j] = A[i - 1][j - 1];
            }
        }
        //        for (int i = 0; i < result.length; i++) {
        //            for (int j = 0; j < result[0].length; j++) {
        //                System.out.print(result[i][j] + " ");
        //            }
        //            System.out.println();
        //        }
        //        System.out.println();
        for (int i = 2; i < result.length - 1; i++) {
            for (int j = 1; j < result[0].length - 1; j++) {
                result[i][j] += num4min(result[i - 1][j - 1], result[i - 1][j],
                        result[i - 1][j + 1]);
            }
        }
        //        for (int i = 0; i < result.length; i++) {
        //            for (int j = 0; j < result[0].length; j++) {
        //                System.out.print(result[i][j] + " ");
        //            }
        //            System.out.println();
        //        }
        //        System.out.println();
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < result[0].length; j++) {
            res = Math.min(result[result.length - 2][j], res);
        }
        //                System.out.println("res:" + res);
        return res;
    }
}
