package leetcode.eraseOverlapIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by luyan on 17/10/22.
 */
public class EraseOverlapIntervals {

    public static void main(String[] args) {
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        Interval[] intervals = new Interval[] { new Interval(1, 2), new Interval(3, 4),
                new Interval(2, 4), new Interval(2, 3), new Interval(2, 5) };
        eraseOverlapIntervals.eraseOverlapIntervals(intervals);
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new myComparator());
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i]);
        }
        int end = intervals[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                System.out.print(intervals[i] + " ");
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }

    class myComparator implements Comparator<Interval> {

        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}
