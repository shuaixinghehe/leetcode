package leetcode.RomanToInt;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luyan on 17/1/24.
 */
public class Solutions {

    public static void main(String[] args) {

        //        System.out.println(romanToInt("IIV"));
        //        System.out.println(romanToInt("XII"));
        //        System.out.println(romanToInt1("IIV"));
        //        System.out.println(romanToInt1("XII"));
        System.out.println(romanToInt("DCXXI"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int[] num = new int[s.length()];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
//            System.out.println(map.get(s.charAt(i)));
            num[i] = map.get(s.charAt(i));
        }
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] < num[i + 1]) {
                sum -= num[i];
            } else {
                sum += num[i];
            }
        }

        sum += num[num.length - 1];

        return sum;
    }

    public static int romanToInt1(String s) {
        int nums[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) sum -= nums[i];
            else sum += nums[i];
        }
        return sum + nums[nums.length - 1];
    }
}
