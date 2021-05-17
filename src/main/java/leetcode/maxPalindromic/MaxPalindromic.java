package leetcode.maxPalindromic;

/**
 * Created by luyan on 2021/5/12.
 */
public class MaxPalindromic {

    private static boolean checkCondition(int mid, int midplus1, String str) {
        if (mid < 0 || mid >= str.length()) {
            return false;
        }
        if (midplus1 < 0 || midplus1 >= str.length()) {
            return false;
        }
        if (str.charAt(mid) == str.charAt(midplus1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //        System.out.println("test");
                System.out.println(getMaxPalindromic(
                        "teesasdfasdfasdfaaaaaaaaaaaaaaaasdffffffffffffffasdfasdfasssssssssssssasdfw3qerfasefasdfasdf13123zsdfasdfasdfet"));
                System.out.println(getMaxPalindromic("babad"));
                System.out.println(getMaxPalindromic("bb"));
                System.out.println(getMaxPalindromic("aaaa"));
        System.out.println(getMaxPalindromic("aacabdkacaa"));
        //        System.out.println(checkCondition(1, 1, "aaaa"));
    }

    private static String getMaxPalindromic(String str) {
        if (null == str) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        // length>1
        String maxResult = "";
        for (int i = 0; i < str.length(); i++) {
            String result = "";
            // 分两种情况，mid=mid+1， or mid-1 = mid+1
            for (int j = 0; j <= i; j++) {
                if (checkCondition(i - j, i + j + 1, str)) {
                    char midChar = str.charAt(i - j);
                    result = midChar + "" + result + str.charAt(i + j + 1);
//                    System.out.println("condition1 " + " i=" + i + " j=" + j + " result:" + result);

                } else {
                    break;
                }
            }
            maxResult = maxResult.length() < result.length() ? result : maxResult;
            result = "" + str.charAt(i);
            for (int j = 1; j <= i; j++) {
                if (checkCondition(i - j, i + j, str)) {
                    result = str.charAt(i - j) + result + str.charAt(i + j);
//                    System.out.println("condition2 " + " i=" + i + " j=" + j + " result:" + result);
                } else {
                    break;
                }
            }
            maxResult = maxResult.length() < result.length() ? result : maxResult;
        }
        return maxResult;
    }
}
