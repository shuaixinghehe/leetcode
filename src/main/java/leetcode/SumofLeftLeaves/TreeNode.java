package leetcode.SumofLeftLeaves;

/**
 * Created by luyan on 17/1/20.
 */
public class TreeNode {

    private static long sum = 0;
    public  int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);

        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        sumOfLeftLeaves(node1);
        System.out.println(sum);
        sum = 0;
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        TreeNode node14 = new TreeNode(4);
        TreeNode node15 = new TreeNode(5);

        node11.left = node12;
        node11.right = node13;
        node12.left = node14;
        node12.right = node15;

        sumOfLeftLeaves(node11);
        System.out.println(sum);

    }

    private static int calc(TreeNode root) {
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += calc(root.left);

            } else {
                calc(root.left);
            }
        }
        if (root.right != null) {
            calc(root.right);
        }
        return root.val;
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        calc(root);
        return (int) sum;
    }
}
