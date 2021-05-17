package leetcode.AddStrings;

/**
 * Created by luyan on 17/1/28.
 */
public class Solutions {

    public static void main(String[] args) {

        System.out.println(addStrings("1111111111","33333333333333333333333"));;
        System.out.println(addStrings("11111","99999"));;
    }

    public static String addStrings(String num1, String num2) {
        int num1_index = 0;
        int num2_index = 0;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (num1_index = num1.length() - 1, num2_index = num2.length() - 1;
             num1_index >= 0 || num2_index >= 0 || carry > 0; num1_index--, num2_index--) {
            int x = num1_index < 0 ? 0 : num1.charAt(num1_index) - '0';
            int y = num2_index < 0 ? 0 : num2.charAt(num2_index) - '0';
            int value = (x + y + carry);
            res.append(value % 10);
            carry = value / 10;
        }
        return res.reverse().toString();
    }
}
