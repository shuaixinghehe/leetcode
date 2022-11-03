package leetcode.countArrangement;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(f(2, 6, 7));
        System.out.println(f(1, 2, 3));
        System.out.println(f(1, 1, 1));
        System.out.println(f(20, 6, 100));
        System.out.println(f(30, 30, 500));
        System.out.println("10E9+7" + (10E9 + 7));
    }

    public static int f(int d, int f, int target) {
        Map<Integer, Map<Integer, Long>> map = new HashMap<>(); // 保存几个骰子时，得到结果有几个；
        // 比如 Map {1:{1:1,2:1}} 有一个骰子时， 等于1的有一个情况

        Map<Integer, Long> initMap = new HashMap<>();
        for (int i = 1; i <= f; i++) {
            int finalI = i;
            initMap.put(finalI, 1L);
        }
        map.put(1, initMap);
        //        System.out.println("init map:" + map);

        for (int diceNum = 2; diceNum <= d; diceNum++) {
            Map<Integer, Long> currentMap = new HashMap<>();
            int finalDiceNum = diceNum;
            for (int i = 1; i <= f; i++) {
                Map<Integer, Long> preMap = map.get(diceNum - 1);
                int finalI = i;
                preMap.keySet().forEach(e -> {
                    int value = e + finalI;
                    long num = preMap.get(e);
                    if (value > target) {
                        return;
                    }
                    currentMap.put(value, currentMap.getOrDefault(value, 0L) + num);
                    currentMap.put(value, (long) (currentMap.get(value) % (10_0000_0000 + 7)));
                });
            }
            map.put(finalDiceNum, currentMap);
            map.remove(finalDiceNum - 1);
            //            System.out.println("dictNum:" + diceNum + " map:" + map);
        }
        //        System.out.println("total map:" + map);

        if (map.get(d).containsKey(target)) {
            long value = map.get(d).get(target);
            //            System.out.println("value:" + value);
            value = (int) (value % (10_0000_0000 + 7));
            //            System.out.println("value mod:" + value);
            //            value = (int) (value % (10E9 + 7));
            //            System.out.println("value mod int:" + value);
            //            value = (long) (value % (10E9 + 7));
            return (int) value;
        }
        return 0;
    }
}
