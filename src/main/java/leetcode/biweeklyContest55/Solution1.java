package leetcode.biweeklyContest55;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(canBeIncreasing(new int[] {1, 2, 10, 1, 5, 7}));
        System.out.println(canBeIncreasing(new int[] {1, 2, 10, 5, 7}));
        System.out.println(canBeIncreasing(new int[] {2, 3, 1, 2}));
        System.out.println(canBeIncreasing(new int[] {1, 1, 1}));
        System.out.println(canBeIncreasing(new int[] {1, 2, 3}));
    }

    public static boolean canBeIncreasing(int[] nums) {
        //        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        //            @Override
        //            public int compare(Integer o1, Integer o2) {
        //                return o2 - o1;
        //            }
        //        });
        //        queue.add(nums[0]);
        //        queue.add(nums[1]);
        //        System.out.println("queue:" + queue);
        //        int n = 0;
        //        for (int i = 1; i < nums.length; i++) {
        //            if (nums[i] > nums[i - 1]) {
        //                n++;
        //            } else { // 决定要删除 i 还是 i-1  还是都可以
        //
        //            }
        //        }
        //        if (n >= nums.length - 2) {
        //            return true;
        //        }
        if (isIncreas(nums)) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            // 删除i
            int[] temp = new int[nums.length - 1];
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    temp[count] = nums[j];
                    count++;

                }
            }
            if (isIncreas(temp)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isIncreas(int[] nums) {
//        System.out.print("nums:");
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + ",");
//        }
//        System.out.println();
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            }
        }
        if (count == nums.length - 1) {
            return true;
        }
        return false;
    }
}
