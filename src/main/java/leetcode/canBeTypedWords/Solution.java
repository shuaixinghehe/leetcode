package leetcode.canBeTypedWords;

public class Solution {
    public static void main(String[] args) {
        System.out.println(canBeTypedWords("hello world", "ad"));
        System.out.println(canBeTypedWords("leet code", "lt"));
        System.out.println(canBeTypedWords("leet code", "e"));
        System.out.println(canBeTypedWords(" ", ""));
        System.out.println(canBeTypedWords("a", ""));
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isValid = true;
            for (int j = 0; j < brokenLetters.length(); j++) {
                if (arr[i].indexOf(brokenLetters.charAt(j)) > -1) {
                    isValid = false;
                }
            }
            if (isValid) {
                res++;
            }
        }
        return res;
    }
}
