package kuaishou.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by luyan on 2020/12/1.
 */
public class MultiThreadTest {

    private final static ExecutorService pool = Executors.newFixedThreadPool(50);//启用多线程
    private static final Map<Integer, Integer> m = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        //        List<Integer> l = new ArrayList<>();
        //        for (int i = 0; i < 500; i++) {
        //           l.add(i) ;
        //        }
        //        l.stream().forEach(e->{
        //            pool.submit(()->{
        //               call(e);
        //            });
        //        });
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("apple");
        System.out.println(set.contains(1));
        System.out.println(set.contains("1"));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        ArrayList<Integer> insertList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            insertList.add(i * 10);
        }
        list.add(5, 0);
        System.out.println(list);
        for (int i = 0; i < insertList.size(); i++) {
            list.add(4 + i, insertList.get(i));
        }
        System.out.println(list);
        //        for (int i = 0; i < 1000; i++) {
        //            int j = i; //关键是这一句代码，将 i 转化为  j，这样j 还是final类型的参与线程
        //            pool.submit(() -> {
        //                call(j);
        //                l.add(j);
        //            });
        //
        //        }
        //        try {
        //            Thread.sleep(200);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //        l.stream().forEach(e -> {
        //            System.out.println("list " + e);
        //        });
        //        pool.shutdown();

    }

    private static void call(int i) {
        try {
            if (m.containsKey(i)) {
                System.out.println("Error");
            } else {
                m.put(i, i);
            }
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i + " - " + Thread.currentThread());
    }

}
