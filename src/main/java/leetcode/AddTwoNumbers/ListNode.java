package leetcode.AddTwoNumbers;

/**
 * Created by luyan on 17/1/16.
 */

// Definition for singly-linked list.

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {

        ListNode listNode0 = new ListNode(8);
        //        ListNode listNode1 = new ListNode(9);
        //        ListNode listNode2 = new ListNode(9);

        //        listNode0.next = listNode1;
        //        listNode1.next = listNode2;
        //        System.out.println(listNode2.next == null);

        ListNode listNode4 = new ListNode(2);
        //        ListNode listNode5 = new ListNode(9);
        //        ListNode listNode6 = new ListNode(4);

        //        listNode4.next = listNode5;
        //        listNode5.next = listNode6;
        ListNode list = addTwoNumbers(listNode0, listNode4);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int l1Length = 0;
        ListNode list = l1;
        while (list != null) {
            l1Length++;
            list = list.next;
        }
        int l2Length = 0;
        list = l2;
        while (list != null) {
            l2Length++;
            list = list.next;
        }
        ListNode bigLengthList = null;
        ListNode smallLengthList = null;

        if (l1Length > l2Length) {
            bigLengthList = l1;
            smallLengthList = l2;
        } else {
            bigLengthList = l2;
            smallLengthList = l1;
        }
        int jinwei = 0;
        ListNode headListNode = bigLengthList;
        while (bigLengthList != null && smallLengthList != null) {
            int val = bigLengthList.val + smallLengthList.val + jinwei;
            jinwei = val / 10;
            bigLengthList.val = val % 10;
            bigLengthList = bigLengthList.next;
            smallLengthList = smallLengthList.next;
        }
        ListNode list1 = solve(headListNode, bigLengthList, jinwei);
        return list1;
    }

    private static ListNode solve(ListNode headListNode, ListNode bigListNode, int jinwei) {
        if (jinwei > 0) {
            if (bigListNode == null) {
                bigListNode = headListNode;
                while (bigListNode.next != null) {
                    bigListNode = bigListNode.next;
                }
                bigListNode.next = new ListNode(jinwei);
                return headListNode;
            } else {
                int val = bigListNode.val + jinwei;
                jinwei = val / 10;
                bigListNode.val = val % 10;
                bigListNode = bigListNode.next;
                return solve(headListNode, bigListNode, jinwei);
            }
        } else {
            return headListNode;
        }
    }
}
