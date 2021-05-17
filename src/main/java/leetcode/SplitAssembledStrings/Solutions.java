package leetcode.SplitAssembledStrings;

import java.util.ArrayList;

/**
 * Created by luyan on 17/4/16.
 */
public class Solutions {

    public static void main(String[] args) {
        System.out.println("abc".compareTo("abe"));
        System.out.println(reverse("abc"));
        System.out.println("#########################");
        System.out.println(splitLoopedString(new String[] { "abc", "xyz", "abn" }));
        System.out.println(splitLoopedString(new String[] { "a", "b", "c" }));

    }

    private static String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String splitLoopedString(String[] strs) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i].compareTo(reverse(strs[i])) > 0 ? strs[i] : reverse(strs[i]));
        }
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(list.get(i));
            for (int j = i + 1; j % list.size() != i; j++) {
                stringBuilder.append(list.get(j % list.size()));
            }
            res = res.compareTo(stringBuilder.toString()) > 0 ? res : stringBuilder.toString();
        }

        return res;
    }
}
