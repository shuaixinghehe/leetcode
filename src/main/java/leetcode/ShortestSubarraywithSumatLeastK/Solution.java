package leetcode.ShortestSubarraywithSumatLeastK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by luyan on 2018/7/1.
 */
public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(arrayList.subList(0, 2));
        System.out.println(arrayList);
        Long l = 0L;
    }

    public int shortestSubarray(int[] A, int K) {
        int[] preArray = new int[A.length];
        int[] endArray = new int[A.length];
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            preArray[i] = total;
        }
        total = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            total += A[i];
            endArray[i] = total;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < preArray.length; i++) {
            if (preArray[i] >= K) {
                result.add(i + 1);
                break;
            }
        }
        for (int i = endArray.length - 1; i >= 0; i--) {
            if (endArray[i] >= K) {
                result.add(endArray.length - i);
                break;
            }
        }
        if (result.contains(1)) {
            return 1;
        }
        for (int i = 0; i < preArray.length; i++) {
            for (int j = endArray.length - 1; j >= 0 && j > i; j--) {
                if (total - preArray[i] - endArray[j] >= K) {
                    //                    System.out.println(total + "-" + preArray[i] + "-" + endArray[j] + " --" + i
                    //                            + " " + j + " length=" + (j - i));
                    result.add(j - i - 1);
                }
            }
        }

        if (result.size() == 0) {
            return -1;
        } else {
            Collections.sort(result);
            return result.get(0);
        }
    }
}
