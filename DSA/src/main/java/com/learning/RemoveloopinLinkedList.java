package com.learning;

import java.util.HashSet;

public class RemoveloopinLinkedList {
    public static void removeLoop(Node head){
        HashSet<Node> s = new HashSet<Node>();
        Node prev = null;
        while (head != null) {
            // If we have already has this node
            // in hashmap it means there is a cycle and we
            // need to remove this cycle so set the next of
            // the previous pointer with null.

            if (s.contains(head)) {
              //  prev.next = null;
                return;
            }

            // If we are seeing the node for
            // the first time, insert it in hash
            else {
                s.add(head);
                prev = head;
                //head = head.next;
            }
        }

        return ;
    }
}

