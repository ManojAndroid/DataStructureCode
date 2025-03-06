package com.learning;

import java.util.HashSet;
import java.util.Set;

public class RemoveloopinLinkedList {
    public static void removeLoop(NodeLinkedList head) {
        Set<NodeLinkedList> s = new HashSet<>();
        NodeLinkedList prev = null;
        while (head != null) {
            // If we have already has this node
            // in hashmap it means there is a cycle and we
            // need to remove this cycle so set the next of
            // the previous pointer with null.

            if (s.contains(head)) {
                prev.next = null;
                return;
            }

            // If we are seeing the node for
            // the first time, insert it in hash
            else {
                s.add(head);
                prev = head;
                head = head.next;
            }
        }

        return;
    }
}

class NodeLinkedList {
    int data;
    NodeLinkedList next;

    public NodeLinkedList(int item) {
        data = item;
        next = null;
    }
}

