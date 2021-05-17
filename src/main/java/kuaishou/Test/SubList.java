package kuaishou.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by luyan on 2019/2/25.
 */
public class SubList {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(-1);
        System.out.println(list.subList(0, 1));
        System.out.println(list.subList(0, 2));
        System.out.println(list.subList(0, 3));
        System.out.println(list.subList(1, list.size()));
        System.out.println(TimeUnit.HOURS.toSeconds(1));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
