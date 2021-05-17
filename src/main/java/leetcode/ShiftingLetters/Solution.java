package leetcode.ShiftingLetters;

import java.util.Arrays;

/**
 * Created by luyan on 2018/6/10.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.shiftingLetters("ruu", new int[] { 26,9,17 });
        System.out.println(s);
    }

    public String shiftingLetters(String S, int[] shifts) {
        if (shifts.length == 0) {
            return S;
        }
        int total = 0;
        for (int i = 0; i < shifts.length; i++) {
            shifts[i] = shifts[i] % 26;
            total += shifts[i];
        }
        int[] shifsCopy = new int[shifts.length];
        for (int i = 0; i < shifts.length; i++) {
            shifsCopy[i] = shifts[i];
        }
        shifts[0] = total%26;
        for (int i = 1; i < shifts.length; i++) {
            shifts[i] = (total - shifsCopy[i - 1]) % 26;
            total = total - shifsCopy[i - 1];
        }
//        System.out.println(Arrays.asList(shifts).toString());
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < S.length(); i++) {
            if (i < shifts.length) {

                stringBuffer.append((char) ( 'a'+ (S.charAt(i) -'a' + shifts[i])%26 ) );
            } else {
                stringBuffer.append((char) (S.charAt(i)));

            }
        }
        return stringBuffer.toString();
    }
}
