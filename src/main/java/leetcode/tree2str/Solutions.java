package leetcode.tree2str;

import java.util.Stack;

import leetcode.SumofLeftLeaves.TreeNode;

/**
 * Created by luyan on 17/6/4.
 */
public class Solutions {

    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);

        treeNode0.right = treeNode2;
        treeNode0.left = treeNode1;
        treeNode1.right = treeNode3;

        System.out.println(tree2str(treeNode0));

    }
    // "1(2(4))(3)"
    // 1(2(4)())(3()())

    public static String tree2str(TreeNode t) {
        preOrder(t);
        String str = "";
        Stack<String> strings = new Stack<>();
        while (!stack.isEmpty()) {
            strings.push((String) stack.pop());

        }
        while (!strings.isEmpty()) {
            str += (String) strings.pop();
        }
        return str;
    }

    private static void preOrder(TreeNode t) {

        if (t != null) {
            stack.push(String.valueOf(t.val));
            if (t.left != null || (t.left == null && t.right != null)) {
                stack.push("(");
                preOrder(t.left);
                stack.push(")");
            }
            if (t.right != null) {
                stack.push("(");
                preOrder(t.right);
                stack.push(")");

            }
        }
    }
}
