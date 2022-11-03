package leetcode.mergeKLists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;
        System.out.println(mergeKLists(new ListNode[] {node1, node4, node7}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for (int i = 0; i < lists.length; i++) {
            head = mergeTwo(head, lists[i]);
//            System.out.println("head:" + p(head));
        }
        return head;
    }

    private static String p(ListNode root) {
        String str = "";
        while (root != null) {
            str += root.val + ",";
            root = root.next;
        }
        return str;
    }

    private static ListNode mergeTwo(ListNode root1, ListNode root2) {
        ListNode head = null;
        ListNode current = null;
        while (root1 != null && root2 != null) {
            if (root1.val < root2.val) {
                if (head == null) {
                    head = root1;
                    current = head;
                    root1 = root1.next;
                } else {
                    current.next = root1;
                    current = current.next;
                    root1 = root1.next;
                }
            } else {
                if (head == null) {
                    head = root2;
                    current = head;
                    root2 = root2.next;
                } else {
                    current.next = root2;
                    current = current.next;
                    root2 = root2.next;
                }
            }
        }
        while (root1 != null) {
            if (current != null) {
                current.next = root1;
                root1 = root1.next;
                current = current.next;
            } else {
                head = root1;
                current = root1;
                root1 = root1.next;
            }

        }
        while (root2 != null) {
            if (current != null) {
                current.next = root2;
                root2 = root2.next;
                current = current.next;
            } else {
                head = root2;
                current = root2;
                root2 = root2.next;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}