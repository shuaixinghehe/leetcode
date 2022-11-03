package leetcode.validSquare;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(validSquare(new int[] {1, 0}, new int[] {-1, 0}, new int[] {0, 1}, new
                int[] {0, -1}));
        System.out.println("cal degree:" + calcDegree(1, 1, -1, 1));
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Point point1 = new Point(p1[0], p1[1]);
        Point point2 = new Point(p2[0], p2[1]);
        Point point3 = new Point(p3[0], p3[1]);
        Point point4 = new Point(p4[0], p4[1]);
        Set<Double> set = new HashSet<>();
        set.add(calcDistance(point1, point2));
        set.add(calcDistance(point1, point3));
        set.add(calcDistance(point1, point4));
        set.add(calcDistance(point2, point3));
        set.add(calcDistance(point2, point4));
        set.add(calcDistance(point3, point4));

        if (set.size() == 2) {
            List<Double> list = set.stream().collect(Collectors.toList());
            Collections.sort(list);
            if (list.get(0) * 2 == list.get(1)) {
                return true;
            }
        }
        return false;
    }

    private static double calcDistance(Point p1, Point p2) {
        //        System.out.println(
        //                p1.toString() + p2.toString() + " distance:" + ((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2
        //                .y) * (p1.y
        //                        - p2.y)));
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    private static double calcDegree(int x1, int y1, int x2, int y2) {
        return ((x1 * x2) + y1 * y2) / (Math.sqrt(x1 * x1 + y1 * y1) * Math.sqrt(x2 * x2 + y2 * y2));
    }

    static class Point {
        public int x;
        public int y;

        Point(int x1, int y1) {
            this.x = x1;
            this.y = y1;
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
