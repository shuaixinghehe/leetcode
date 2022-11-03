package leetcode.findTheDifference;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        System.out.println(findRotation(new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
                new int[][] {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(findRotation(new int[][] {{0, 0}, {0, 1}},
                new int[][] {{0, 0}, {1, 0}}));
        System.out.println(findRotation(new int[][] {{0, 1}, {1, 1}},
                new int[][] {{1, 0}, {0, 1}}));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        List<String> originList = new ArrayList<>();
        List<String> targetList = new ArrayList<>();
        //  原始的相同
        boolean res = true;
        for (int i = 0; i < mat.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < mat[0].length; j++) {
                builder.append(mat[i][j]);
            }
            originList.add(builder.toString());
        }
        for (int i = 0; i < target.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < target[0].length; j++) {
                builder.append(target[i][j]);
            }
            targetList.add(builder.toString());
        }
        for (int i = 0; i < originList.size(); i++) {
            if (!targetList.get(i).equals(originList.get(i))) {
                res = false;
            }
        }
        if (res) {
            return res;
        }


        // 转90度
        originList = new ArrayList<>();
        res = true;
        for (int i = 0; i < mat.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < mat[0].length; j++) {
                builder.append(mat[j][i]);
            }
            originList.add(builder.reverse().toString());
        }
        for (int i = 0; i < originList.size(); i++) {
            if (!targetList.get(i).equals(originList.get(i))) {
                res = false;
            }
        }
        if (res) {
            return res;
        }

        // 转180度
        List<String> originList180 = new ArrayList<>();
        res = true;
        for (int i = 0; i < originList.size(); i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < originList.get(0).length(); j++) {
                builder.append(originList.get(j).charAt(i));
            }
            originList180.add(builder.reverse().toString());
        }
        for (int i = 0; i < originList180.size(); i++) {
            if (!targetList.get(i).equals(originList180.get(i))) {
                res = false;
            }
        }
        if (res) {
            return res;
        }

        // 转270度
        List<String> originList270 = new ArrayList<>();
        res = true;
        for (int i = 0; i < originList180.size(); i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < originList180.get(0).length(); j++) {
                builder.append(originList180.get(j).charAt(i));
            }
            originList270.add(builder.reverse().toString());
        }
        for (int i = 0; i < originList270.size(); i++) {
            if (!targetList.get(i).equals(originList270.get(i))) {
                res = false;
            }
        }
        if (res) {
            return res;
        }


        return res;
    }
}
