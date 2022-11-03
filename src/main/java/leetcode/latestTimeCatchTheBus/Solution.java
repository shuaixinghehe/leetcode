package leetcode.latestTimeCatchTheBus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        //        [18,8,3,12,9,2,7,13,20,5]
        //[13,10,8,4,12,14,18,19,5,2,30,34]
        //        1
        int maxTime = latestTimeCatchTheBus(new int[] {18, 8, 3, 12, 9, 2, 7, 13, 20, 5},
                new int[] {13, 10, 8, 4, 12, 14, 18, 19, 5, 2, 30, 34}, 1);
        System.out.println(maxTime);

        maxTime = latestTimeCatchTheBus(new int[] {20, 30, 10},
                new int[] {19, 13, 26, 4, 25, 11, 21}, 2);
        System.out.println(maxTime);

        maxTime = latestTimeCatchTheBus(new int[] {10},
                new int[] {19, 13, 26, 4, 25, 11, 21}, 2);
        System.out.println(maxTime);

        maxTime = latestTimeCatchTheBus(new int[] {10, 20},
                new int[] {2, 17, 18, 19}, 3);
        System.out.println(maxTime);

        maxTime = latestTimeCatchTheBus(new int[] {20, 30, 10},
                new int[] {19, 13, 26, 4, 25, 11, 21}, 3);
        System.out.println(maxTime);

        maxTime = latestTimeCatchTheBus(new int[] {3},
                new int[] {2, 4}, 2);
        System.out.println(maxTime);
    }


    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        //        Arrays.stream(buses).forEach(value -> System.out.print(value + " "));
        //        System.out.println();
        //        Arrays.stream(passengers).forEach(value -> System.out.print(value + " "));
        //        System.out.println();
        int passengersIndex = 0;
        int onceMaxUsers = 0;
        Set<Integer> userTime = new HashSet<>();
        for (int i = 0; i < buses.length; i++) {
            while (passengersIndex < passengers.length &&
                    onceMaxUsers < capacity &&
                    passengers[passengersIndex] <= buses[i]) {
                // 可以上车
                userTime.add(passengers[passengersIndex]);
                passengersIndex++;
                onceMaxUsers++;

            }
            // case 1： 坐满了
            if (capacity == onceMaxUsers && i == buses.length - 1) {
                int maxTime = 0;
                int tempIndex = passengersIndex - 1;
                while (tempIndex >= 0) {
                    int maxTime1 = passengers[tempIndex];
                    if (!userTime.contains(maxTime1 - 1)) {
                        maxTime = Math.max(maxTime1 - 1, maxTime);
                        return maxTime;
                    }
                    tempIndex--;
                }
                //                for (int j = passengers[tempIndex]; ; j++) {
                //                    if (!userTime.contains(j)) {
                //                        maxTime = Math.max(j, maxTime);
                //                    }
                //                }
            }
            // case 2 没坐满，但是没有下一个乘客了 or 下一个乘客不满足要求
            if (i == buses.length - 1) {
                int maxTime = 0;

                for (int j = buses[i]; j >= 0; j--) {
                    if (!userTime.contains(j)) {
                        maxTime = Math.max(j, maxTime);
                        return maxTime;
                    }
                }
            }
            onceMaxUsers = 0;
            //            userTime = new HashSet<>();
        }


        return 0;
    }

}
