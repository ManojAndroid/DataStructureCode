package com.learning;

import java.util.PriorityQueue;

public class MergKSortedLinkedList {
    /*Time Complexity: O(n log k)
    Space Complexity: O(k)*/
    public static ListNode sort(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode res = new ListNode();
        ListNode p = res;

        for (ListNode list : lists) {
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode temp = pq.remove();
            if (temp.next != null) {
                pq.add(temp.next);
            }
            p.next = temp;
            p = p.next;
        }
        return res.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int k = 3; // Number of linked lists

        // an array of pointers storing the head nodes
        // of the linked lists
        ListNode arr[] = new ListNode[k];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);

        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);

        arr[2] = new ListNode(1);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);
        ListNode head = sort(arr);
        printList(head);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode() {
    }

}
