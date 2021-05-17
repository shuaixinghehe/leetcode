package leetcode.findTheDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luyan on 17/1/18.
 */
public class Solutions {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
        System.out.println(findTheDifference1(s, t));
    }

    public static char findTheDifference1(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        char c = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < sarr.length; i++) {
            if (map.containsKey(sarr[i])) {
                int count = map.get(sarr[i]);
                map.put(sarr[i], ++count);
            } else {
                map.put(sarr[i], 1);
            }

            if (map.containsKey(tarr[i])) {
                int count = map.get(tarr[i]);
                map.put(tarr[i], --count);
            } else {
                map.put(tarr[i], -1);
            }
        }
        for (int i = sarr.length; i < tarr.length; i++) {
            if (map.containsKey(tarr[i])) {
                int count = map.get(tarr[i]);
                map.put(tarr[i], --count);
            } else {
                map.put(tarr[i], -1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        return c;

    }

    public static char findTheDifference(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        char c = 0;
        quickSort(sarr);
        quickSort(tarr);

        for (int i = 0; i < sarr.length; i++) {
            if (sarr[i] != tarr[i]) {
                return tarr[i];
            }
        }
        c = tarr[tarr.length - 1];
        return c;
    }

    public static void quickSort(char[] array) {
        if (array != null) {
            quickSort(array, 0, array.length - 1);
        }
    }

    private static void quickSort(char[] array, int beg, int end) {
        if (beg >= end || array == null) return;
        int p = partition(array, beg, end);
        quickSort(array, beg, p - 1);
        quickSort(array, p + 1, end);
    }

    private static int partition(char[] array, int beg, int end) {
        char first = array[beg];
        int i = beg, j = end;
        while (i < j) {
            while (array[i] <= first && i < end) {
                i++;
            }
            while (array[j] > first && j >= beg) {
                j--;
            }
            if (i < j) {
                array[i] = (char) (array[i] ^ array[j]);
                array[j] = (char) (array[i] ^ array[j]);
                array[i] = (char) (array[i] ^ array[j]);
            }
        }
        if (j != beg) {
            array[j] = (char) (array[beg] ^ array[j]);
            array[beg] = (char) (array[beg] ^ array[j]);
            array[j] = (char) (array[beg] ^ array[j]);
        }
        return j;
    }
}
