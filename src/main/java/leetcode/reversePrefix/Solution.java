package leetcode.reversePrefix;

public class Solution {

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
        System.out.println(reversePrefix("xyxzxe", 'z'));
        System.out.println(reversePrefix("abcd", 'z'));
    }

    public static String reversePrefix(String word, char ch) {
        if (word.indexOf(ch) != -1) {
            int i = word.indexOf(ch);
            StringBuilder builder = new StringBuilder();
            for (int j = i; j >= 0; j--) {
                builder.append(word.charAt(j));
            }
            for (int j = i + 1; j < word.length(); j++) {
                builder.append(word.charAt(j));
            }
            return builder.toString();
        } else {
            return word;
        }
    }
}
