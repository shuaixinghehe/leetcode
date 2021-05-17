package leetcode.FindLargestValueEachTreeRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.SumofLeftLeaves.TreeNode;

/**
 * Created by luyan on 17/3/15.
 */
public class Solutions {

    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(9);

        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.right = treeNode6;
        System.out.println(largestValues(treeNode0));

    }

    private static void bfs(Queue<TreeNode> queue) {
        int max = 0;
        if (queue != null && queue.size() > 0) {
            max = queue.peek().val;
        } else {
            return;
        }
        Queue<TreeNode> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()) {

            max = Math.max(max, queue.peek().val);
            if (queue.peek().left != null) {
                nextQueue.add(queue.peek().left);
            }
            if (queue.peek().right != null) {
                nextQueue.add(queue.peek().right);
            }
            queue.poll();

        }
        result.add(max);
        bfs(nextQueue);

    }

    public static List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        bfs(queue);

        return result;

    }
}
