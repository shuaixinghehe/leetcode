package leetcode.AllNodesDistanceKinBinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by luyan on 2018/7/1.
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        Solution solution = new Solution();
        System.out.println(solution.distanceK(node1, node2, 2));

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Set<Integer> targetTreeNodeVal = new HashSet<>();
        targetTreeNodeVal.add(target.val);
        List<Set<Integer>> list = new ArrayList<>();
        list.add(targetTreeNodeVal);
        for (int i = 0; i < K; i++) {
            targetTreeNodeVal = bfs(root, targetTreeNodeVal);
            list.add(targetTreeNodeVal);

        }
        for (int i = 0; i < list.size() - 1; i++) {
            targetTreeNodeVal.removeAll(list.get(i));
        }
        return targetTreeNodeVal.stream().collect(Collectors.toList());
    }

    private Set bfs(TreeNode root, Set<Integer> targetTreeNodeVal) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        Set<Integer> moreNode = new HashSet<>();
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root != null && root.left != null && targetTreeNodeVal.contains(root.left.val)) {
                moreNode.add(root.val);
            }
            if (root != null && root.right != null && targetTreeNodeVal.contains(root.right.val)) {
                moreNode.add(root.val);
            }
            if (targetTreeNodeVal.contains(root.val) && root.left != null) {
                moreNode.add(root.left.val);
            }
            if (targetTreeNodeVal.contains(root.val) && root.right != null) {
                moreNode.add(root.right.val);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return moreNode;

    }

    //  Definition for a binary tree node.
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
