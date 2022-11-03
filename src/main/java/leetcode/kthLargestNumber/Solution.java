package leetcode.kthLargestNumber;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(kthLargestNumber2(new String[] {"3", "6", "7", "10"}, 4));
        System.out.println(kthLargestNumber2(new String[] {"2", "21", "12", "1"}, 3));
        System.out.println(kthLargestNumber2(new String[] {"0", "0"}, 2));
        System.out.println(kthLargestNumber2(
                new String[] {"623986800", "3", "887298", "695", "794", "6888794705", "269409", "59930972",
                        "723091307",
                        "726368", "8028385786", "378585"}, 11));
        System.out.println(kthLargestNumber2(new String[] {"12", "21"}, 1));
    }

    public static String kthLargestNumber(String[] nums, int k) {
        List<BigInteger> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            BigInteger bigInteger = new BigInteger(String.valueOf(0));
            for (int j = 0; j < nums[i].length(); j++) {
                bigInteger = bigInteger.multiply(BigInteger.valueOf(10))
                        .add(new BigInteger(String.valueOf(nums[i].charAt(j))));
                list.add(bigInteger);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        //        System.out.println(list);
        return list.get(k - 1).toString(10);
    }

    public static String kthLargestNumber2(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 默认小的在前
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) > o2.charAt(i)) {
                            return 1;
                        } else if (o1.charAt(i) < o2.charAt(i)) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        });
        List<String> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(nums[i]);
        }

        return list.get(k - 1);
    }
}
