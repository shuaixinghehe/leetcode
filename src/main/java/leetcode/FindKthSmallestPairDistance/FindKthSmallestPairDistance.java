package leetcode.FindKthSmallestPairDistance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by luyan on 17/10/29.
 */
public class FindKthSmallestPairDistance {

    public static void main(String[] args) {
        FindKthSmallestPairDistance findKthSmallestPairDistance = new FindKthSmallestPairDistance();
        System.out.println(
                findKthSmallestPairDistance.smallestDistancePair(new int[] { 1, 3, 1 }, 1));
    }

    public int smallestDistancePair(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                list.add(Math.abs(nums[j] - nums[i]));
            }
        }
        //        System.out.println(list);
        Collections.sort(list);
        //        System.out.println(list);

        return list.get(k - 1);
    }
}
