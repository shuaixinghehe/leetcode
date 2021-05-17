package kuaishou.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by luyan on 2020/9/17.
 */
public class ParallelTest {

    public static void main(String[] args) {
        System.out.println("Stream并行测试");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        Long startTime = System.currentTimeMillis();

        ArrayList result1 = (ArrayList) list.stream().filter(i -> costTime(i))
                .collect(Collectors.toList());
        System.out.println("result1 cost " + (System.currentTimeMillis() - startTime) + " size "
                + result1.size());

        startTime = System.currentTimeMillis();

        ArrayList result2 = (ArrayList) list.parallelStream().filter(i -> costTime(i))
                .collect(Collectors.toList());
        System.out.println("result2 cost " + (System.currentTimeMillis() - startTime) + " size "
                + result2.size());

    }

    public static boolean costTime(int i) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i % 7 == 0;
    }
}
