package leetcode.findContentChildren;

/**
 * Created by luyan on 17/1/19.
 */
public class Solutions {

    public static void main(String[] args) {
        int[] g = { 10,9,8,7};
        int[] s = { 5,6,7,8};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        quickSort(g, 0, g.length - 1);
        quickSort(s, 0, s.length - 1);

        int minLength = Math.min(g.length, s.length);
        int minCount = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    minCount++;
                    s[j] = -1;
                    break;
                }
            }
        }
        return minCount;
    }

    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）   
            int temp; // 记录临时中间值   
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j) quickSort(numbers, start, j);
            if (end > i) quickSort(numbers, i, end);
        }
    }
}
