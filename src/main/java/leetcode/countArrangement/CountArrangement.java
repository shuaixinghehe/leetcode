package leetcode.countArrangement;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountArrangement {
    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[] {1, 2, 4, -4, 3, 4}, 7));
        testDeque();
    }

    public static int countArrangement(int n) {

        return 0;
    }

    public static int shortestSubarray(int[] A, int K) {
        long[] arr = new long[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            arr[i + 1] = arr[i] + A[i];
            if (A[i] >= K) {
                return 1;
            }
        }//得到前缀和数组
        int res = Integer.MAX_VALUE;
        // for(int i=0;i<=A.length-1;i++){  //暴力破解 N^2 超时
        //     for(int j = i+1;j<=A.length;j++){
        //         if(arr[j]-arr[i]>=K){
        //             res = Math.min(j-i,res);
        //         }
        //     }
        // }
        System.out.print("preSum:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[i] <= arr[queue.getLast()]) {
                queue.removeLast();
            }
            while (!queue.isEmpty() && arr[i] - arr[queue.peek()] >= K) {
                res = Math.min(res, i - queue.poll());
            }
            queue.add(i);
            System.out.println("i:" + i + " queue:" + queue + " res:" + res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static void testDeque() {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("queue:" + queue);
        System.out.println("queue.getLast" + queue.getLast());
    }
}
