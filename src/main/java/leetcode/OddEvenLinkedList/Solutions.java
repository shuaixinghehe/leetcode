package leetcode.OddEvenLinkedList;

/**
 * Created by luyan on 17/9/5.
 */
public class Solutions {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode1 = oddEvenList(listNode1);
        while (listNode1 != null) {
            System.out.print(listNode1.val + "=>");
            listNode1 = listNode1.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p1.next != null && p2.next != null && p1.next.next != null && p2.next.next != null) {
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p2.next == null) {
            p1.next = evenHead;
            return oddHead;
        }
        if (p2.next.next == null) {
            p1.next = p1.next.next;
            p1 = p1.next;
            p2.next = null;
            p1.next = evenHead;
            return oddHead;
        }
        return null;

    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
