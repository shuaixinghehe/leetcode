package leetcode.BinaryWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyan on 17/1/22.
 */
public class Solutions {

    private static int bit1Num(int num) {
        int count = 0;
        while (num != 0 && num >= 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    private static String createTime(int hour, int minute) {
        String time = "";
        time += String.valueOf(hour);
        time += ":";
        if (minute < 10) {
            time += "0";
            time += String.valueOf(minute);
        } else {
            time += String.valueOf(minute);
        }
        return time;
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        for (int hour = 0; hour <= 11; hour++) {
            for (int minutes = 0; minutes <= 59; minutes++) {
                if (bit1Num(hour) + bit1Num(minutes) == num) {
                    list.add(createTime(hour, minutes));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(bit1Num(5));
        List<String> list = readBinaryWatch(1);
        for (String s : list) {
            System.out.println(s);
        }
        //["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

    }
}
