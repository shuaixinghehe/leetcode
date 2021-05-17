package leetcode.BoundaryBinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.SumofLeftLeaves.TreeNode;

/**
 * Created by luyan on 17/3/26.
 */
public class Solutions {

    private static List<Integer> res = new ArrayList<>();
    private static List<Integer> nodes = new ArrayList<>();
    private static List<Integer> leftNodes = new ArrayList<>();
    private static List<Integer> rightNodes = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;


        System.out.println(boundaryOfBinaryTree(treeNode1));
    }

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root != null && root.right == null && root.left == null) {
            list.add(root.val);
            return list;
        }
        getLeftNode(root);
        getRightNode(root);
        dfs(root, root);
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < leftNodes.size(); i++) {
            if (!map.containsKey(leftNodes.get(i))) {
                res.add(leftNodes.get(i));
                map.put(leftNodes.get(i), true);
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (!map.containsKey(nodes.get(i))) {
                res.add(nodes.get(i));
                map.put(nodes.get(i), true);
            }
        }
        Collections.reverse(rightNodes);
        for (int i = 0; i < rightNodes.size(); i++) {
            if (!map.containsKey(rightNodes.get(i))) {
                res.add(rightNodes.get(i));
                map.put(rightNodes.get(i), true);
            }
        }
        return res;
    }

    private static void getLeftNode(TreeNode root) {
        if (root != null) {
            leftNodes.add(root.val);
            getLeftNode(root.left);
        }
    }

    private static void getRightNode(TreeNode root) {
        if (root != null) {
            rightNodes.add(root.val);
            if (root.right != null) {
                getRightNode(root.right);
            } else if (root.right == null && root.left != null) {
                getRightNode(root.left);
            } else {
            }

        }
    }

    private static void dfs(TreeNode root, TreeNode orginRoot) {
        if (root.left != null) {
            dfs(root.left, orginRoot);

        }
        if (root.right != null) {
            dfs(root.right, orginRoot);
        }
        if (root.left == null && root.right == null) {
            nodes.add(root.val);
        }
    }
}
