package leetcode.StudentAttendanceRecordI;

/**
 * Created by luyan on 17/4/16.
 */
public class Solutions {

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
    }

    public static boolean checkRecord(String s) {
        int ATimes = 0;
        int LTimes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                ATimes++;

            } else if (s.charAt(i) == 'L' && i + 1 < s.length() && s.charAt(i + 1) == 'L'
                    && i + 2 < s.length() && s.charAt(i + 2) == 'L') {
                LTimes++;
            }
        }
        if (ATimes > 1 || LTimes > 0) {
            return false;
        }
        return true;

    }
}
