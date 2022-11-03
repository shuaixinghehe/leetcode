package leetcode.smallestChair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.util.Pair;

public class Solution {
    public static void main(String[] args) {
        //                        System.out.println(smallestChair(new int[][] {{1, 4}, {2, 3}, {4, 6}}, 1));
        //                        System.out.println(smallestChair(new int[][] {{3, 10}, {1, 5}, {2, 6}}, 0));
        //                        System.out.println(smallestChair(
        //                                new int[][] {{33889, 98676}, {80071, 89737}, {44118, 52565}, {52992, 84310},
        //                                {78492, 88209},
        //                                        {21695, 67063}, {84622, 95452}, {98048, 98856}, {98411, 99433},
        //                                        {55333,
        //                                        56548},
        //                                        {65375, 88566},
        //                                        {55011, 62821}, {48548, 48656}, {87396, 94825}, {55273, 81868},
        //                                        {75629,
        //                                        91467}}, 6));
        System.out.println(smallestChair(
                new int[][] {{82057, 89365}, {32519, 49655}, {7573, 20592}, {8336, 11514}, {638,
                        70162},
                        {39511, 44262},
                        {70399, 79785}, {8702, 63564}, {66644, 68330}, {75156, 90448}, {11884, 87096},
                        {99068, 99875},
                        {32555, 54053}, {5910, 77572}, {87649, 94390}, {40084, 56483}, {7911, 28699},
                        {93308, 96154},
                        {25562, 39605}, {73966, 93173}, {63450, 88007}, {58811, 80045}, {56160,
                        71952},
                        {14333, 79867},
                        {40342, 76876}, {69943, 82175}}, 5));
        System.out.println(smallestChair(
                new int[][] {{24710, 60469}, {25295, 76256}, {11088, 34742}, {92605, 97746}, {68272, 68682},
                        {44286, 70033}, {88703, 92573}, {37394, 87075}, {47741, 73042}, {5603, 9454},
                        {88970, 96339},
                        {62904, 98525}, {42743, 69814}, {28999, 80490}, {76263, 90116}, {78042, 90721},
                        {27856, 69492},
                        {20067, 54704}, {72177, 81840}, {34951, 76201}, {59089, 65862}, {61102, 76554},
                        {32726, 48272},
                        {57683, 99972}, {74537, 85162}, {88161, 90916}, {50114, 88989}, {5170, 11173},
                        {87698, 90284},
                        {78856, 84320}, {14517, 51015}, {30757, 54925}, {28234, 45768}, {73177, 89666}}, 3));
        System.out.println(smallestChair(
                new int[][] {{24710, 60469}, {25295, 76256}, {11088, 34742}, {92605, 97746}, {68272, 68682},
                        {44286, 70033}, {88703, 92573}, {37394, 87075}, {47741, 73042}, {5603, 9454}, {88970, 96339},
                        {62904, 98525}, {42743, 69814}, {28999, 80490}, {76263, 90116}, {78042, 90721}, {27856, 69492},
                        {20067, 54704}, {72177, 81840}, {34951, 76201}, {59089, 65862}, {61102, 76554}, {32726, 48272},
                        {57683, 99972}, {74537, 85162}, {88161, 90916}, {50114, 88989}, {5170, 11173}, {87698, 90284},
                        {78856, 84320}, {14517, 51015}, {30757, 54925}, {28234, 45768}, {73177, 89666}}, 3));
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        int targetArriveTime = times[targetFriend][0];
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Queue<Pair<Integer, Integer>> chairs = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        }); // chair index，几号椅子，什么时候离开

        //        for (int i = 0; i < times.length; i++) {
        //            System.out.print("(" + times[i][0] + "," + times[i][1] + "), ");
        //        }
        //        System.out.println();
        for (int i = 0; i < times.length; i++) {
            int arriveTime = times[i][0]; // 到达时间

            List<Pair<Integer, Integer>> newList = new ArrayList<>();
            chairs.stream().forEach(e -> {
                if (e.getValue() > arriveTime) {
                    newList.add(e);
                }
            });
            chairs = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o1.getKey() - o2.getKey();
                }
            }); // chair index，几号椅子，什么时候离开
            for (int j = 0; j < newList.size(); j++) {
                chairs.add(newList.get(j));
            }
            int currentChairIndex = 0;
            //            System.out
            //                    .println("i:" + i + " times[i]:(" + times[i][0] + "," + times[i][1] + "), start
            //                    chairs:" + chairs);
            if (chairs.isEmpty()) {
                chairs.add(new Pair<>(0, times[i][1])); // 加入第一个chair，和结束时间
                currentChairIndex = 0;
            } else {
                if (chairs.peek().getKey() > 0) { // 如果最小的不是0
                    chairs.add(new Pair<>(0, times[i][1]));
                    currentChairIndex = 0;
                } else {
                    List<Integer> chairIndexTemp = new ArrayList<>();
                    chairs.forEach(e -> {
                        chairIndexTemp.add(e.getKey());
                    });
                    Collections.sort(chairIndexTemp);

                    int start = chairIndexTemp.get(0);
                    for (int j = 0; j < chairIndexTemp.size(); j++) {
                        if (start == chairIndexTemp.get(j)) {
                            start++;
                        } else {
                            break;
                        }
                    }
                    chairs.add(new Pair<>(start, times[i][1]));
                    currentChairIndex = start;
                }
            }
            //            System.out
            //                    .println("i:" + i + " times[i]:(" + times[i][0] + "," + times[i][1] + "), after
            //                    chairs:" + chairs);
            if (arriveTime == targetArriveTime) {
                return currentChairIndex;
            }
        }
        return 0;
    }
}
