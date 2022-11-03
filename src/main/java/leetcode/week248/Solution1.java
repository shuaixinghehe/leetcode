package leetcode.week248;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{0,2,1,5,3,4}));
        System.out.println(buildArray(new int[]{5,0,1,2,3,4}));
    }

    public static int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + ",");
//        }
//        System.out.println();
        return res;
    }
}
