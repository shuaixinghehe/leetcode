package leetcode.FindModeBinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by luyan on 17/2/10.
 */
public class Solutions {

    private static ArrayList<Integer> arrayList = new ArrayList<>();
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode20 = new TreeNode(3);
        TreeNode treeNode21 = new TreeNode(3);
        treeNode1.left = null;
        treeNode1.right = treeNode20;
        treeNode20.left = treeNode21;
        System.out.println(findMode(treeNode1));
        int t = 1;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            t = t * 4;
            System.out.println("t=" + t + " i=" + i);
        }

    }

    public static ArrayList findMode(TreeNode root) {
        midTravel(root);
        for (Integer value : map.values()) {
            arrayList.add(value);
        }
        Collections.sort(arrayList);
        int max = arrayList.get(arrayList.size() - 1);
        List<Integer> list = new LinkedList<>();
        for (int i = arrayList.size() - 1; i >= 0 && arrayList.get(i) == max; i--) {}
        return arrayList;
    }

    private static void qsort(Integer[] integers) {
        qsort(integers, 0, integers.length - 1);
    }

    private static void qsort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high); //将数组分为两部分
            qsort(arr, low, pivot - 1); //递归排序左子数组
            qsort(arr, pivot + 1, high); //递归排序右子数组
        }
    }

    private static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[low]; //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot)
                --high;
            arr[low] = arr[high]; //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot)
                ++low;
            arr[high] = arr[low]; //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }

    public static void midTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        midTravel(root.left);
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        midTravel(root.right);
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
