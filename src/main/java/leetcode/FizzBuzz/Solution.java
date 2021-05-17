package leetcode.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyan on 17/1/18.
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for(int i =0;i<=n;i++)
        {
            if(i%3 == 0 && i %15 != 0 )
            {
                list.add("Fizz");
            }
            else if(i%5 == 0 && i%15 != 0)
            {
                list.add("Buzz");
            }
            else if(i%15 ==0 )
            {
                list.add("leetcode/FizzBuzz");
            }
            else
            {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
