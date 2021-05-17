package jisuanke.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Created by luyan on 2020/9/19.
 */
public class Main {

    public static void main(String[] args) {
        //        int A;
        //        int B;
        //        //        Scanner input = new Scanner(System.in);
        //        //        A = input.nextInt();
        //        //        B = input.nextInt();
        //        //        System.out.println(A + B);
        //        List<Integer> list = new ArrayList<>();
        //        list.add(0);
        //        System.out.println(list);
        //        test(list);
        //        System.out.println(list);
        //        String a = "abcd";
        //        String b = "abcd中国😁";
        //        System.out.println("a.length()=" + a.length() + " code point count="
        //                + a.codePointCount(0, a.length()));
        //        System.out.println("b.length()=" + b.length() + " code point count="
        //                + b.codePointCount(0, a.length()));
        //        a.codePoints().forEach(e -> {
        //            System.out.println(e);
        //        });
        //
        //        b.codePoints().forEach(e -> {
        //            System.out.println(e);
        //        });
        long m0 = Runtime.getRuntime().freeMemory();
        String s = new String("abcdef");
        long m1 = Runtime.getRuntime().freeMemory();
        System.out.println(m0 - m1);
        System.out.println(new StringJoiner(".").add("1").add("2").add(null).toString());
        Set<String> set = new HashSet<>();
        System.out.println(set);
        set.add("123");
        System.out.println(set);
        List<Integer> aaList = new ArrayList<>();
        aaList.add(1);
        aaList.add(2);
        aaList.add(3);
        aaList.add(4);
        System.out.println(aaList.size());
        System.out.println(aaList.subList(0, 4));

    }

    private static List test(List a) {
        a.add(1);
        return a;
    }
}
