package leetcode.isStrictlyPalindromic;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        func(9,list,2);
        System.out.println(list);
        System.out.println(Integer.toString(9,2));
        System.out.println(Integer.toString(9,3));
        System.out.println(Integer.toString(9,4));
        System.out.println(isPalindromic("1011"));
    }

    private static void func(int n, List<Integer> list, int decimal) {

        if (n >= decimal) {
            list.add(1);
            func(n - decimal, list, decimal);
        } else {
            list.add(n);
        }
    }

    public static boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <=n-2 ; i++) {
            String str = Integer.toString(n,i);
            if(!isPalindromic(str)){
                return false;
            }

        }
        return true;
    }
    public static boolean isPalindromic(String str){
        int i =0 ;
        int j = str.length()-1;
        while (i<j){
            if (str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
