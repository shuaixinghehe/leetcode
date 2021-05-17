package leetcode.ConvertNumberHexadecimal;

/**
 * Created by luyan on 17/2/10.
 */
public class Solutions {

    public static void main(String[] args) {

        System.out.println(toHex(-3));
    }

    public static void printbit(int num) {
        System.out.println("printbit");
        int n = 32;
        while (n-- > 0) {
            System.out.print(num & 1);
            num = num >> 1;
        }
    }

    public static Character getChar(int n) {
        Character res = 'Z';
        switch (n) {
            case 0:
                res = '0';
                break;
            case 1:
                res =  '1';
                break;
            case 2:
                res =  '2';
                break;
            case 3:
                res =  '3';
                break;
            case 4:
                res = '4';
                break;
            case 5:
                res =  '5';
                break;
            case 6:
                res =  '6';
                break;
            case 7:
                res =  '7';
                break;
            case 8:
                res = '8';
                break;
            case 9:
                res =  '9';
                break;
            case 10:
                res = 'a';
                break;
            case 11:
                res = 'b';
                break;
            case 12:
                res = 'c';
                break;
            case 13:
                res = 'd';
                break;
            case 14:
                res = 'e';
                break;
            case 15:
                res = 'f';
                break;
            default:
                res = 'Z';
        }
        return res;
    }

    public static String toHex(int num) {

        if (num == 0) {
            return "0";
        }
//        if (num < 0) {
//            num = ~(num * -1) + 1;
//        }
        String res = null;
        int n = 8;
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        while (n-- > 0 &num!=0) {
            res = map[num & 0x000f] + res;
            num = num >> 4;
        }

        return res;
    }
}
