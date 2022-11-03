package leetcode.monotoneIncreasingDigits;

import java.util.ArrayList;
import java.util.List;

public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(10));
    }

    public static int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(Integer.valueOf(str.charAt(i) - '0'));
        }
        int validCnt = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) <= list.get(i + 1)) {
                validCnt++;
            }
        }
        if (validCnt == list.size() - 1) {
            return n;
        }
        System.out.println("list" + list);
        return 0;
    }
}
