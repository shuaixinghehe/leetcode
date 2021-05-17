package leetcode.maximumProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by luyan on 17/6/25.
 */
public class Main {

    public static int maximumProduct(int[] nums) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
//        System.out.println(list);

        int length = list.size();
        result = Math.max(list.get(0) * list.get(1) * list.get(length - 1),
                list.get(length - 1) * list.get(length - 2) * list.get(length - 3));

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[] { 1, 2, 3 }));
        System.out.println(maximumProduct(new int[] { 1, 2, 3, 4 }));
        System.out.println(maximumProduct(new int[] { -11, -1, 2, 3, 4 }));
        System.out.println(maximumProduct(new int[] { -11, -2, -1, 3 }));
    }
}
