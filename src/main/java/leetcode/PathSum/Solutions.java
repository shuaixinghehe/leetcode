package leetcode.PathSum;

import java.util.ArrayList;
import java.util.List;

import leetcode.SumofLeftLeaves.TreeNode;

/**
 * Created by luyan on 17/3/13.
 */
public class Solutions {

    private static boolean result = false;
    private static List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(5);

        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode3.left = treeNode7;
        treeNode3.right = treeNode8;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        treeNode6.right = treeNode12;
        treeNode6.left = treeNode11;
        System.out.println(hasPathSum(treeNode0, 22));
        System.out.println(pathSum(treeNode0, 22));
    }

    private static void dfs(TreeNode root, int sum) {
        if (root != null) {
            if (root.left == null && root.right == null && sum == root.val) {
                result = result == false ? true : result;
            }
            if (root.left != null) {
                dfs(root.left, sum - root.val);
            }
            if (root.right != null) {
                dfs(root.right, sum - root.val);
            }

        }
    }

    private static void dfs(TreeNode root, int sum, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.left == null && root.right == null && sum == root.val) {

                lists.add((ArrayList<Integer>) list.clone());
            }
            if (root.left != null) {
                dfs(root.left, sum - root.val, list);
                list.remove(list.size() - 1);
            }
            if (root.right != null) {
                dfs(root.right, sum - root.val, list);
                list.remove(list.size() - 1);
            }

        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        dfs(root, sum);
        return result;
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return lists;
        }
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, sum, list);
        return lists;
    }
}
