package com.learning.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class FindIntesactionPoint {
 /* The time complexity of this solution is O(n) where n is the length of the longer list. This is because we need to traverse both of the linked lists in order to find the intersection point.
  And space complexity is O(n) , because we are using unordered set.*/

  static Node getIntersectPoint(Node n1, Node n2) {
    Set<Node> set = new HashSet<>();
    while (n1 != null) {
      set.add(n1);
      n1 = n1.next;
    }
    while (n2 != null) {
      if (set.contains(n2)) {
        return n2;
      }
      n2 = n2.next;
    }
    return null;
  }

  static void print(Node node) {
    Node curr = node;
    while (curr != null) {
      System.out.print(curr.data);
      curr = curr.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // list 1
    Node n1 = new Node(1);
    n1.next = new Node(2);
    n1.next.next = new Node(3);
    n1.next.next.next = new Node(4);
    n1.next.next.next.next = new Node(5);
    n1.next.next.next.next.next = new Node(6);
    n1.next.next.next.next.next.next = new Node(7);
    // list 2
    Node n2 = new Node(10);
    n2.next = new Node(9);
    n2.next.next = new Node(8);
    n2.next.next.next = n1.next.next.next;
    print(n1);
    print(n2);
    System.out.println(getIntersectPoint(n1, n2).data);
  }

  static class Node {

    int data;
    Node next;

    Node(int data) {
      this.data = data;
      next = null;
    }
  }

}
