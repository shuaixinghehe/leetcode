package leetcode.robotWithString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(robotWithString2("bac"));
        System.out.println(robotWithString2("zza"));
        System.out.println(robotWithString2("bdda"));
        System.out.println(robotWithString2("bddabddabdda"));
        System.out.println(robotWithString2("vzhofnpo"));
    }

    public static String robotWithString(String s) {

        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i) + "");
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) + "").equals(list.get(index))) {
                index++;
                res.append(s.charAt(i));
                while (index < list.size() &&
                        !stack.isEmpty() && list.get(index).equals(stack.peek())) {
                    res.append(stack.pop());
                    index++;
                }
            } else {
                stack.add(s.charAt(i) + "");
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }


        return res.toString();
    }


    public static String robotWithString2(String s) {

        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();

        // 倒着遍历，
        String[] strings = new String[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i + 1 < s.length() && (s.charAt(i) + "").compareTo(strings[i + 1]) < 0) {
                strings[i] = s.charAt(i) + "";
            } else if (i == s.length() - 1) {
                strings[i] = s.charAt(i) + "";
            } else {
                strings[i] = strings[i + 1];
            }
        }
//        for (int i = 0; i < strings.length; i++) {
//            System.out.print(strings[i] + ",");
//        }
//        System.out.println();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i)+"");
            while (!stack.isEmpty() && i+1<strings.length
            && strings[i+1].compareTo(stack.peek())>=0){
                res.append(stack.pop());
            }
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }


}