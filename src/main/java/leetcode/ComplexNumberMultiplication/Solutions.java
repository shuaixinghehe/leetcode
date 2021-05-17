package leetcode.ComplexNumberMultiplication;

/**
 * Created by luyan on 17/3/26.
 */
public class Solutions {

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }

    public static String complexNumberMultiply(String a, String b) {
        int ashishu = getShishu(a);
        int axushu = getXushu(a);
        int bshishu = getShishu(b);
        int bxushu = getXushu(b);

        int shishu = ashishu * bshishu + axushu * bxushu * (-1);
        int xushu = ashishu * bxushu + bshishu * axushu;
        String res = "";
        return res + String.valueOf(shishu) + "+" + String.valueOf(xushu) + "i";
    }

    private static int getShishu(String a) {
        String shishustr = a.substring(0, a.indexOf('+'));
        int shishu = Integer.valueOf(shishustr);
        return shishu;
    }

    private static int getXushu(String a) {
        String xushustr = a.substring(a.indexOf('+') + 1, a.indexOf('i'));
        int xushu = Integer.valueOf(xushustr);
        return xushu;
    }
}
