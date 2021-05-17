package leetcode.RectangleAreaII;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luyan on 2018/6/10.
 */
public class Solutions {

    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        System.out.println(solutions
                .rectangleArea(new int[][] { { 0, 0, 2, 2 }, { 1, 0, 2, 3 }, { 1, 0, 3, 1 } }));
        System.out
                .println(solutions.rectangleArea(new int[][] { { 0, 0, 1000000000, 1000000000 } }));
    }

    public int rectangleArea(int[][] rectangles) {
        int maxX = 0;
        int maxY = 0;
        int smallX = 0;
        int smallY = 0;
        for (int i = 0; i < rectangles.length; i++) {
            maxX = Math.max(rectangles[i][2], maxX);
            maxY = Math.max(rectangles[i][3], maxY);
            smallX = Math.min(rectangles[i][0], smallX);
            smallY = Math.min(rectangles[i][1], smallY);
        }
        Set<java.lang.String> set = new HashSet<>();
        for (int i = smallX; i < maxX; i++) {
            for (int j = smallY; j < maxY; j++) {
                if (!set.contains(i + "_" + j)) {
                    for (int k = 0; k < rectangles.length; k++) {
                        if (i >= rectangles[k][0] && i < rectangles[k][2] && j >= rectangles[k][1]
                                && j < rectangles[k][3]) {
                            set.add(i + "_" + j);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}
