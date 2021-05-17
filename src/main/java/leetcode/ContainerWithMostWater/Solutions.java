package leetcode.ContainerWithMostWater;

import java.util.ArrayList;
import java.util.List;

/**
 * |
 * | |
 * | | |
 * | | | |
 * Created by luyan on 17/4/20.
 */
public class Solutions {

    public static void main(String[] args) {
    }

    public static int maxArea1(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }
        //        System.out.println("height length" + height.length);
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }
        for (int i = 0; i < height.length; i++) {
            if (height[i] < leftMax[i] && height[i] < rightMax[i]) {
                height[i] = 0;
            }
        }
        int maxArea = 0;
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            if (height[i] != 0) {
                list.add(new Point(i, height[i]));
            }
        }
        //        System.out.println("list .size" + list.size());
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                maxArea = Math.max(maxArea, getArea(list.get(i), list.get(j)));
            }
        }
        return maxArea;

    }

    public static int maxArea0(int[] height) {
        int maxArea = 0;
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            list.add(new Point(i, height[i]));
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                maxArea = Math.max(maxArea, getArea(list.get(i), list.get(j)));
            }
        }
        return maxArea;
    }

    //    private static int calculateStack(Stack<Point> stack, Point point, int maxArea) {
    //        while (stack.size() > 1 && stack.peek().y > point.y) {
    //            Point currentPoint = stack.pop();
    //            maxArea = Math.max(maxArea, getArea(currentPoint, stack.peek()));
    //        }
    //        if (stack.size() == 1) {
    //            maxArea = Math.max(maxArea, getArea(point, stack.peek()));
    //        }
    //        if (stack.peek().y < point.y) {
    //            stack.push(point);
    //        }
    //        return maxArea;
    //
    //    }
    //
    //    public static int maxArea(int[] height) {
    //        int maxArea = 0;
    //        Stack<Point> stack = new Stack<>();
    //        for (int i = 0; i < height.length; i++) {
    //            if (stack.isEmpty() || stack.peek().y < height[i]) {
    //                stack.push(new Point(i, height[i]));
    //            }
    //            if (stack.peek().y > height[i]) {
    //                maxArea = calculateStack(stack, new Point(i, height[i]), maxArea);
    //            }
    //        }
    //        Point lastPoint = new Point(height.length - 1, height[height.length - 1]);
    //        if (lastPoint.y == stack.peek().y && lastPoint.x != stack.peek().x) {
    //            stack.push(lastPoint);
    //        }
    //        while (!stack.isEmpty()) {
    //            Point point = stack.pop();
    //            while (!stack.isEmpty() && stack.peek().y <= point.y) {
    //                maxArea = Math.max(maxArea, getArea(point, stack.peek()));
    //                if (!stack.isEmpty()) stack.pop();
    //            }
    //        }
    //        return maxArea;
    //    }
    //
    private static int getArea(Point x, Point y) {
        return Math.abs(x.x - y.x) * Math.min(x.y, y.y);
    }

    public int maxArea(int[] height) {
        int water = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            water = Math.max(water, (j - i) * h);
            while (height[i] <= h && i < j)
                i++;
            while (height[j] <= h && i < j)
                j--;
        }
        return water;
    }

    //
    //    private static int getArea(int x1, int x2, int y) {
    //        return (x2 - x1) * y;
    //    }
    //
    private static class Point {

        public int x;
        public int y;

        public Point(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }

}
