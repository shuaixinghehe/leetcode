package leetcode.ComboKey;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by luyan on 2018/5/4.
 */
public class CombineMap {

    //
    // A-1 B-2 C-3 D-4  ... Z-26
    // 12 AB L
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 15 16 17 18 19 20 21 22 23 24 25 26 27
    // 123123
    private static Map<String, String> map = new HashMap<String, String>() {

        {
            put("1", "A");
            put("2", "B");
            put("3", "C");
            put("4", "D");
            put("5", "E");
            put("6", "F");
            put("7", "G");
            put("8", "H");
            put("9", "I");
            put("10", "J");
            put("11", "K");
            put("12", "L");
            put("13", "M");
            put("14", "N");
            put("15", "O");
            put("16", "P");
            put("17", "Q");
            put("18", "R");
            put("19", "S");
            put("20", "T");
            put("21", "U");
            put("22", "V");
            put("23", "W");
            put("24", "X");
            put("25", "Y");
            put("26", "Z");
        }
    };
    private static int count = 0;

    private static void dfs(String input, int start) {
        // 先走一位
        if (start + 1 <= input.length() && map.containsKey(input.substring(start, start + 1))) {
            if (start + 1 == input.length()) {
                count++;
                return;
            } else {
                dfs(input, start + 1);
            }
        }
        // 再走两位
        if (start + 2 <= input.length() && map.containsKey(input.substring(start, start + 2))) {
            if (start + 2 == input.length()) {
                count++;
                return;
            } else {
                dfs(input, start + 2);
            }
        }
        if (start > input.length()) {
            return;
        }
    }

    public static void main(String[] args) {
        String input = "111111";
        dfs(input, 0);
        System.out.println("result:" + count);
        double rate = 1.0;
        for (int i = 0; i < 365; i++) {
            rate *= (365 - i) / 365.0;
            System.out.println("loop :" + i + " " + (1 - rate));
        }
        Queue queue = new PriorityQueue();
        queue.add(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);


    }
}
