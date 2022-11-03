package leetcode.evaluateTree;


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public static boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    public static boolean dfs(TreeNode root) {
        if (root.val > 1) {
            boolean leftValue = dfs(root.left);
            boolean rightValue = dfs(root.right);
            if (root.val == 2) {
                return leftValue || rightValue;
            } else {
                return leftValue && rightValue;
            }

        }
        return root.val == 0 ? false : true;
    }

    public static void main(String[] args) {

    }
}
