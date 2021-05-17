package leetcode.maxDistToClosest;

import java.util.ArrayList;

/**
 * Created by luyan on 2018/6/10.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//                System.out.println(solution.maxDistToClosest(new int[] { 1, 0, 0, 0, 1, 0, 1 }));
//                System.out.println(solution.maxDistToClosest(new int[] { 1, 0, 0, 0 }));
//        System.out.println(solution.maxDistToClosest(new int[] { 1, 1, 1, 0, 1 }));
        System.out.println(solution.maxDistToClosest(new int[] { 0,0,1,0,1,1 }));
    }

    public int maxDistToClosest(int[] seats) {
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                arrayList.add(i);
            }
        }
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; seats[i] != 1 && j < arrayList.size(); j++) {
                if (j + 1 < arrayList.size() && arrayList.get(j) < i && arrayList.get(j + 1) > i) { //两侧
                    seats[i] = Math.min(Math.abs(arrayList.get(j) - i),
                            Math.abs(arrayList.get(j + 1) - i));
                    break;
                } else if(j + 1 == arrayList.size() && arrayList.get(j) < i) { // 右侧
                    seats[i] = Math.abs(arrayList.get(j) - i);
                    break;
                }
                else if(i<arrayList.get(j))
                {
                    seats[i]=Math.abs(arrayList.get(j)-i);
                    break;
                }
            }
        }
        int maxDistance = 0;
        for (int i = 0; i < seats.length; i++) {
            maxDistance = Math.max(maxDistance, seats[i]);
            System.out.print(seats[i] + " ");
        }
        System.out.println();
        return maxDistance;
    }
}
