package com.learning.LinkedList;

public class FindMiddleElement {
  //Time Complexity: O(N), As we are traversing the list only once.
  //Auxiliary Space: O(1), As constant extra space is used.
  static void findTheMiddleElement(Node node) {
    Node slowPointer = node;
    Node fastPointer = node;
    while (fastPointer != null && fastPointer.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;
    }
    System.out.println(slowPointer.data);
  }

  public static void main(String[] args) {
    Node node = new Node(1);
    node.next = new Node(3);
    node.next.next = new Node(6);
    node.next.next.next = new Node(7);
    node.next.next.next.next = new Node(8);

    findTheMiddleElement(node);

  }

  static class Node {

    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

}
