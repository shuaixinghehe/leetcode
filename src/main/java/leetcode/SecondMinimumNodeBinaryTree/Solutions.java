package leetcode.SecondMinimumNodeBinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import leetcode.SumofLeftLeaves.TreeNode;

/**
 * Created by luyan on 17/9/3.
 */
public class Solutions {

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(2);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        node0.left = node1;
        node0.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(findSecondMinimumValue(node0));
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(-3);
        arrayList.add(4);
        Collections.sort(arrayList);
        System.out.println(arrayList);

    }

    public static boolean minRoot(int rootValue, int leftValue, int rightValue) {
        if (rightValue >= rootValue && leftValue >= rootValue) {
            return true;
        }
        return false;
    }

    public static int findSecondMinimumValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (!set.contains(root.val)) {
                arrayList.add(root.val);
                set.add(root.val);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        Collections.sort(arrayList);
        //        System.out.println(arrayList);
        if (arrayList.size() < 2) {
            return -1;
        }
        return arrayList.get(1);

    }
}
