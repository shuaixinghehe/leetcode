package leetcode.biweeklyContest55;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
        System.out.println(removeOccurrences("axxxxyyyyb", "xy"));
    }

    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replace(part, "");
        }
        return s;
    }
}
