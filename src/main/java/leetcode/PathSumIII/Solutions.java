package leetcode.PathSumIII;

import java.util.Stack;

import leetcode.SumofLeftLeaves.TreeNode;

/**
 * Created by luyan on 17/3/14.
 */
public class Solutions {


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

        System.out.println(pathSum(treeNode0, 8));


    }

    private static void dfs(TreeNode root, Stack<Integer> stack, int sum) {
        if (root != null) {
            stack.push(root.val);
            calcStack((Stack<Integer>) stack.clone(), sum);
            if (root.left == null && root.right == null) {

            }
            if (root.left != null) {
                dfs(root.left, stack, sum);
                stack.pop();
            }
            if (root.right != null) {
                dfs(root.right, stack, sum);
                stack.pop();
            }

        }

    }
    private static int result = 0;

    private static int calcStack(Stack<Integer> stack, int sum) {

        int res = 0;
        while (!stack.isEmpty()) {
            sum -= stack.pop();
            if (sum == 0) {
                res++;
            }
        }
        result+=res;
        return res;
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        dfs(root, stack, sum);
        return result;
    }
}
