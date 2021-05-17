package leetcode.findComplement;

/**
 * Created by luyan on 17/1/18.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }

    public  static  int findComplement(int num) {
        int number = num;
        int first1Index = 0;
        int calculateNum = 0;
        while (num > 0) {
            first1Index++;
            num = num >> 1;
            calculateNum = calculateNum << 1;
            calculateNum = (calculateNum | 1);
        }

        number = (~number) & calculateNum;
        return number;

    }
}
