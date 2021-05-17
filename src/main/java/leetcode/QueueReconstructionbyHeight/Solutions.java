package leetcode.QueueReconstructionbyHeight;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by luyan on 17/3/8.
 */
public class Solutions {

    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) return new int[0][0];

        Arrays.sort(people, (a, b) -> {
            if (b[0] == a[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < tmp.size(); i++) {
            res[i][0] = tmp.get(i)[0];
            res[i][1] = tmp.get(i)[1];
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        people = reconstructQueue(people);
        for (int i = 0; i < people.length; i++) {
            System.out.println("[" + people[i][0] + "," + people[i][1] + "]");
        }
    }
}
