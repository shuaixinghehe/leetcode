package leetcode.NumberOfBoomerangs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by luyan on 17/1/24.
 */
public class Solutions {

    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        System.out.println(numberOfBoomerangs(points));
        System.out.println(numberOfBoomerangs1(points));
        points = new int[][] { { 0, 0 }, { 1, 0 }, { 2, 0 } };
        System.out.println(numberOfBoomerangs(points));
        System.out.println(numberOfBoomerangs1(points));
    }

    private static double distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                double distance = distance(points[i], points[j]);
                //                System.out.println(distance);
                for (int k = 0; k < points.length; k++) {
                    if (k == j || k == i) continue;
                    if (Math.abs(distance(points[j], points[k]) - distance) < 1e-6) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int numberOfBoomerangs1(int[][] points) {
        int count = 0;
        Map<Double, Set<String>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i ) continue;
                double distance = distance(points[i], points[j]);
                String startToEnd = String.valueOf(i) + "to" + String.valueOf(j);
                if (map.containsKey(distance)) {
                    Set set = map.get(distance);
                    set.add(startToEnd);
                    map.put(distance, set);
                } else {
                    Set<String> set = new HashSet();
                    set.add(startToEnd);
                    map.put(distance, set);
                }
            }
        }
        for (Double d : map.keySet()) {
            System.out.print("distance d:" + d + "  ");
            for (String s : map.get(d)) {
                System.out.print(s + " ");
            }
            System.out.println();
            Set set = map.get(d);
            count = Math.max(count, set.size());
        }
        return count;
    }
}
