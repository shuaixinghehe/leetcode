package leetcode.FindBottomLeftTreeValue;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.SumofLeftLeaves.TreeNode;

/**
 * Created by luyan on 17/3/7.
 */
public class Solutions {

    private static Queue<TreeNode> queue;
    private static int res = 0;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
        System.out.println(findBottomLeftValue(node1));
    }

    private static void bfs(Queue<TreeNode> queue) {
        Queue<TreeNode> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode visitNode = queue.poll();
            if (visitNode.left != null) {
                nextQueue.offer(visitNode.left);
            }
            if (visitNode.right != null) {
                nextQueue.offer(visitNode.right);
            }
        }
        if (!nextQueue.isEmpty()) res = nextQueue.peek().val;
        if (nextQueue.size() > 0) bfs(nextQueue);
    }

    public static int findBottomLeftValue(TreeNode root) {
        res = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        bfs(queue);
        return res;
    }

    //    public static int findBottomLeftValue(TreeNode root) {
    //        Stack<Integer> stack = new Stack<>();
    //        Queue<TreeNode> queue = new LinkedList<>();
    //        TreeNode visitNode = root;
    //        queue.offer(visitNode);
    //        while (!queue.isEmpty()) {
    //            visitNode = queue.poll();
    //            if (visitNode.left != null) {
    //                stack.push(visitNode.left.val);
    //                queue.offer(visitNode.left);
    //            }
    //            if (visitNode.right != null) {
    //                queue.offer(visitNode.right);
    //            }
    //        }
    //
    //        return stack.peek();
    //    }

}
