package leetcode.WeeklyContest108;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.util.Pair;

public class Soluton2 {
    public static void main(String[] args) {
        System.out.println(reductionOperations2(new int[] {5, 1, 3}));
        System.out.println(reductionOperations2(
                new int[] {42672, 34976, 20556, 27368, 19551, 20893, 23110, 17870, 21319, 49070, 49055, 34086, 32838,
                        565, 34481, 7987, 9749, 20783, 47632, 21337, 21468, 37560, 4512, 29611, 18325, 31438, 29763,
                        23866, 48604, 24939, 5123, 37944, 3677, 8820, 3194, 34322, 32256, 37723, 16510, 16081, 46067,
                        37604, 48933, 22194, 23697, 42173, 24258, 26384, 20145, 30447, 39208, 22312, 34874, 33263,
                        10997, 1906, 9723, 16393, 45040, 14493, 36883, 8743, 7390, 12098, 26943, 47708, 40613, 3284,
                        6503, 35764, 44651, 17415, 46836, 7009, 13392, 17151, 4377, 41428, 37436, 34497, 42011, 5145,
                        4772, 14247, 42156, 11362, 33521, 28318, 1432, 38690, 24125, 31895, 46549, 18596, 14414, 13133,
                        39196, 32350, 15416, 27882, 29635, 44277, 24063, 35683, 12375, 31599, 47568, 4765, 16814, 26694,
                        13197, 543, 48942, 34865, 24951, 33705, 31922, 5008, 26460, 40360, 33428, 37899, 38313, 27892,
                        2630, 23058, 30046, 420, 12437, 19619, 45613, 45308, 42080, 361, 35441, 7868, 19835, 33587,
                        48947, 20681, 35588, 42274, 37485, 36136, 18515, 34448, 26964, 35524, 33939, 26759, 39504,
                        41286, 38081, 20170, 29657, 19786, 8582, 33183, 29110, 38422, 9197, 36045, 10681, 16564, 41725,
                        630, 27799, 48244, 43356, 37088, 2376, 24142, 27583, 26355, 18452, 43188, 49219, 43888, 1202,
                        5930, 5901, 316, 25128, 17622, 30433, 17824, 24421, 41671, 49111, 31551, 22056, 25459, 29895,
                        7636, 31702, 23233, 9483, 27211, 9717, 1191, 11278, 17055, 24102, 8331, 38639, 18819, 27061,
                        16904, 33672, 18827, 48466, 27575, 45307, 17936, 28411, 22014, 31838, 14121, 46889, 32203,
                        26340, 46936, 27861, 5989, 4224, 8485, 13510, 9805, 15023, 47853, 1713, 6768, 16596, 10205,
                        31444, 6485, 26158, 42577, 47416, 12284, 197, 5844, 28029, 40101, 3334, 36019, 14306, 35029,
                        27649, 22722, 3083, 42703, 6762, 48138, 36231, 44504, 27501, 44018, 48571, 7776, 17389, 44863,
                        18269, 11734, 31439, 46149, 3125, 14040, 44356, 42223, 5715, 25541, 8113, 43825, 29314, 19284,
                        44693, 33281, 32635, 25762, 7613, 39723, 31405, 6936, 9774, 25321, 40216, 46032, 13186, 10953,
                        34128, 16883, 27303, 48705, 35175, 18914, 32275, 41528, 35704, 14066, 49786, 40866, 22092,
                        31849, 6741, 562, 49662, 47795, 43076, 22734, 46452, 17534, 3699, 35425, 40990, 28853, 19652,
                        49798, 6604, 14979, 33294, 17994, 17717, 46286, 16145, 26978, 9722, 8533, 16798, 12800, 26721,
                        36756, 41290, 39223, 3830, 34917, 39911, 33382, 9756, 27119, 17706, 18337, 31467, 45576, 20041,
                        17502, 32200, 14051, 32687, 24097, 39257, 30838, 15838, 22178, 11545, 39698, 49737, 11876,
                        48445, 38047, 45494, 29565, 35047, 9794, 3812, 33027, 21366, 34635, 45227, 8852, 42275, 49900,
                        13972, 20668, 40800, 32358, 31484, 21630, 7760, 8384, 9183, 45767, 16808, 14748, 5770, 41633,
                        35313, 46067, 3279, 36902, 11278, 44877, 7612, 14828, 36914, 13069, 32966, 37197, 43248, 20177,
                        27674, 21473, 278, 1315, 20009, 40330, 14436, 5543, 48697, 14714, 18362, 44610, 41003, 22353,
                        17635, 39397, 47106, 33976, 24857, 1516, 7973, 21617, 22743, 9139, 7432, 16438, 9390, 44644}));
        System.out.println(reductionOperations2(new int[] {1, 1, 2, 2, 3}));
    }

    public static int reductionOperations(int[] nums) {
        System.out.println("nums.length:" + nums.length);
        Queue<Integer> queueBig = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Queue<Integer> queueSmall = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queueBig.add(nums[i]);
            queueSmall.add(nums[i]);
        }
        int res = 0;
        int smallest = queueSmall.peek();
        while (!queueBig.isEmpty() && queueBig.peek() != smallest) {
            int biggest = queueBig.poll();
            int nextBig = queueBig.peek();
            List<Integer> temp = new ArrayList<Integer>();
            while (nextBig == biggest && !queueBig.isEmpty()) {
                nextBig = queueBig.poll();
                temp.add(nextBig);
            }
            queueBig.add(nextBig);
            temp.forEach(e -> queueBig.add(e));
            res++;
            //            System.out.println("queue:" + queueBig);
        }
        System.out.println(queueBig);
        return res;
    }

    public static int reductionOperations2(int[] nums) {
        System.out.println("nums.length:" + nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        int smallest = nums[0];
        for (int i = 0; i < nums.length; i++) {
            smallest = Math.min(smallest, nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Pair<Integer, Integer>> bigQueue = new PriorityQueue<Pair<Integer, Integer>>(
                new Comparator<Pair<Integer, Integer>>() {
                    @Override
                    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                        return o2.getKey() - o1.getKey();
                    }
                });
        map.keySet().forEach(key -> {
            bigQueue.add(new Pair(key, map.get(key)));
        });
        int res = 0;
        while (!bigQueue.isEmpty() && smallest != bigQueue.peek().getKey()) {
            Pair<Integer, Integer> biggest = bigQueue.poll();
            if (!bigQueue.isEmpty()) {
                Pair<Integer, Integer> nextBiggest = bigQueue.poll();
                res += biggest.getValue();
                bigQueue.add(new Pair<>(nextBiggest.getKey(), nextBiggest.getValue() + biggest.getValue()));
            }
        }


        System.out.println("bigQueue:" + bigQueue);
        return res;
    }
}
