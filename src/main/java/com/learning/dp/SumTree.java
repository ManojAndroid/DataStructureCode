package com.learning.dp;

public class SumTree {

  Node root;

/*  Time Complexity: The solution involves a simple traversal of the given tree. So the time complexity is O(n) where n is the number of nodes in the given Binary Tree.
  Auxiliary Space : O(1) since using constant variables*/
  int sumTree(Node node) {
    if (node == null) {
      return 0;
    }
    int olddate = node.data;
    node.data = sumTree(node.left) + sumTree(node.right);
    return olddate + node.data;
  }

  void printInorder(Node node) {
    if (node == null) {
      return;
    }
    printInorder(node.left);
    System.out.print(node.data + " ");
    printInorder(node.right);
  }

  public static void main(String[] args) {
    SumTree tree = new SumTree();
    tree.root = new Node(10);
    tree.root.left = new Node(-2);
    tree.root.right = new Node(6);
    tree.root.left.left = new Node(8);
    tree.root.left.right = new Node(-4);
    tree.root.right.left = new Node(7);
    tree.root.right.right = new Node(5);

    tree.sumTree(tree.root);

    // Print inorder traversal of the converted tree to test result
    // of toSumTree()
    System.out.println("Inorder Traversal of the resultant tree is:");
    tree.printInorder(tree.root);
  }


}

class Node {

  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}
