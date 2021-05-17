package leetcode.RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;

/**
 * Created by luyan on 2019/5/19.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));

    }

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == S.charAt(i)) {
//                    System.out.println("pop:" + S.charAt(i));
                    stack.pop();
                    continue;
                } else {
//                    System.out.println("add:" + S.charAt(i));
                    stack.add(S.charAt(i));
                }
            } else {
//                System.out.println("add:" + S.charAt(i));
                stack.add(S.charAt(i));
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
//        System.out.println("res " + res);
        String reverse = new StringBuffer(res).reverse().toString();
        return reverse;
    }

}
