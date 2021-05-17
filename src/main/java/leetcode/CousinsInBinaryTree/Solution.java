package leetcode.CousinsInBinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by luyan on 2021/5/17.
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root.val==x || root.val==y){
            return false;
        }


        TreeNode xParent = null;
        TreeNode yParent = null;
        int xDepth = 0;
        int yDepth = 0;

        Queue<TreeNode> nodeQueue = new ArrayDeque();
        nodeQueue.add(root);
        int qLength = nodeQueue.size();
        int depth = 0;
        while (!nodeQueue.isEmpty()) {
            for (int i = 0; i < qLength; i++) {
                TreeNode node = nodeQueue.poll();
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    if (node.left.val == x) {
                        xParent = node;
                        xDepth = depth + 1;
                    } else if (node.left.val == y) {
                        yParent = node;
                        yDepth = depth + 1;
                    }
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    if (node.right.val == x) {
                        xParent = node;
                        xDepth = depth + 1;
                    } else if (node.right.val == y) {
                        yParent = node;
                        yDepth = depth + 1;
                    }
                }
            }
            depth += 1;
            qLength = nodeQueue.size();
        }
        if (null == xParent || null == yParent){
            return false;
        }
        if (xParent.val != yParent.val && xDepth == yDepth) {
            return true;
        }
        return false;
    }
}
