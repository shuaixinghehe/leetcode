package leetcode.StringCompression;

/**
 * Created by luyan on 17/10/29.
 */
public class StringCompression {

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.compress(new char[] { 'a', 'b', 'c', 'd', 'd' }));
        System.out.println(stringCompression.compress(new char[] { 'a' }));
        System.out.println(stringCompression.compress(
                new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' }));
        System.out.println(
                stringCompression.compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
    }

    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        char a = chars[0];
        String res = "";
        int cnt = 1;
        for (int i = 1; i < chars.length; i++) {
            char b = chars[i];
            if (a == b) {
                cnt++;
            } else {
                res += String.valueOf(a) + (cnt == 1 ? "" : String.valueOf(cnt));
                cnt = 1;
                a = b;
            }
        }
        res += String.valueOf(a) + (cnt == 1 ? "" : String.valueOf(cnt));
        //        System.out.println(res);
        for (int i = 0; i < res.length(); i++) {
            chars[i] = res.charAt(i);
        }
        return res.length();
    }
}
