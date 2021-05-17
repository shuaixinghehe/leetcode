package leetcode;

import java.util.List;

/**
 * Created by luyan on 17/12/24.
 */
public class IPtoCIDR {

    public static void main(String[] args) {
        //        IPtoCIDR iPtoCIDR = new IPtoCIDR();
        //        System.out.println(iPtoCIDR.ipToCIDR("255.0.0.7", 10));
        //        System.out.println(255 << 8);
        String text = "12345";
        System.out.println(text.charAt(1));
    }

    public List<String> ipToCIDR(String ip, int range) {
        String[] iparr = ip.split("\\.");
        int ipValue = 0;

        for (int i = 0; i < iparr.length; i++) {
            System.out.println("iparr" + iparr[i]);
            ipValue += Integer.valueOf(iparr[i]) << (3 - i) * 8;
        }
        print(ipValue);
        print(ipValue + 1);
        print(ipValue + 2);
        return null;
    }

    private void print(int ipValue) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((ipValue & 1 << i) == 0 ? 0 : 1);
            if (i % 8 == 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
