package leetcode.numFactoredBinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by luyan on 2021/5/17.
 */
public class NumFactoredBinaryTrees {

    public static void main(String[] args) {
        int[] arr = {45, 42, 2, 18, 23, 1170, 12, 41, 40, 9, 47, 24, 33, 28, 10, 32, 29, 17, 46,
                11, 759, 37, 6, 26, 21, 49, 31, 14, 19, 8, 13, 7, 27, 22, 3, 36, 34, 38, 39, 30, 43,
                15, 4, 16, 35, 25, 20, 44, 5, 48};
        //
        System.out.println(numFactoredBinaryTrees(arr));
    }

    public static int numFactoredBinaryTrees(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            set.add(arr[i]);
        }
        Collections.sort(list);
        //        System.out.println(list);

        Map<Integer, Integer> nodeValueMap = new HashMap<>();
        for (int i = 1; i < list.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 并且除完，另一个数还在set里面 // 整除
                if (list.get(i) % list.get(j) == 0 && set.contains(list.get(i) / list.get(j))) {
                    // 所以 list[j] 和 list[i]/list[j] 是两个因子
                    int factor1 = list.get(j);
                    int factor2 = list.get(i) / list.get(j);
                    //                    System.out.println("factor1:" + factor1 + " factor2:" + factor2);
                    if (factor1 == factor2) {
                        if (nodeValueMap.keySet().contains(factor1)) { //  如果已经计算过factor可以由
                            nodeValueMap.put(list.get(i), nodeValueMap.get(factor1)
                                    + nodeValueMap.get(factor1) * nodeValueMap.get(factor1) + 1);
                        } else {
                            nodeValueMap.put(list.get(i), 1);
                        }
                    } else {
                        int value1 = nodeValueMap.getOrDefault(factor1, 1);
                        int value2 = nodeValueMap.getOrDefault(factor2, 1);
                        if (nodeValueMap.keySet().contains(list.get(i))) {
                            //                            System.out.println(
                            //                                    "i=" + i + " list.get(i):" + list.get(i) + "
                            //                                    nodemap.get"
                            //                                            + "(list.getIi):" + nodeValueMap.get(list
                            //                                            .get(i)));
                            nodeValueMap.put(list.get(i), nodeValueMap.get(list.get(i)) + 1);
                            if (value1 > 1 && value2 == 1) {
                                nodeValueMap.put(list.get(i),
                                        nodeValueMap.get(list.get(i)) + value1);
                            } else if (value2 > 1 && value1 == 1) {
                                nodeValueMap.put(list.get(i),
                                        nodeValueMap.get(list.get(i)) + value2);

                            } else if (value1 > 1 && value2 > 1) {
                                nodeValueMap.put(list.get(i),
                                        nodeValueMap.get(list.get(i)) + value1 * value2);
                            }
                        } else {
                            nodeValueMap.put(list.get(i), 1);
                            if (value1 > 1 && value2 == 1) {
                                nodeValueMap.put(list.get(i),
                                        nodeValueMap.get(list.get(i)) + value1);
                            } else if (value2 > 1 && value1 == 1) {
                                nodeValueMap.put(list.get(i),
                                        nodeValueMap.get(list.get(i)) + value2);

                            } else if (value1 > 1 && value2 > 1) {
                                nodeValueMap.put(list.get(i),
                                        nodeValueMap.get(list.get(i)) + value1 * value2);
                            }
                        }
                    }
                    int finalI = i;
                    //                    nodeValueMap.forEach((integer, integer2) -> {
                    //                        System.out.println("i:" + finalI + " list.get(i):" + list.get(finalI)
                    //                                + " integer " + integer + " value:" + integer2);
                    //                    });
                }
            }
        }
        //        nodeValueMap.forEach((integer, integer2) -> {
        //            System.out.println("key:" + integer + " value:" + integer2);
        //        });
        AtomicInteger result = new AtomicInteger();
        nodeValueMap.values().stream().forEach(e -> {
            result.addAndGet(e);
        });
        return result.get() + set.size();

    }
}
