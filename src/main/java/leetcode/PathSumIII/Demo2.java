package leetcode.PathSumIII;

import java.util.ArrayList;
import java.util.List;

import leetcode.SumofLeftLeaves.TreeNode;

/**
 * Created by luyan on 17/3/17.
 */
public class Demo2 {

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(10);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(-3);

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(11);
        TreeNode treeNode7 = new TreeNode(3);
        TreeNode treeNode8 = new TreeNode(-2);
        TreeNode treeNode10 = new TreeNode(1);

        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.right = treeNode6;
        treeNode3.left = treeNode7;
        treeNode3.right = treeNode8;
        treeNode4.right = treeNode10;

        System.out.println(pathSum(treeNode0, 1));
        System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
        //        System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }

            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int findPath(TreeNode root, int sum) {
        int res = 0;
        if (root == null) return res;
        if (sum == root.val) {
            res++;
        }
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            nums[val] = -nums[val];

            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

}
