package com.learning;

public class BSTInorderSuccessor {
    //time complexity of O(h)
    //space complexity of O(1)
    public static Node inorderSuccessor(Node root, Node p) {
        Node successor = null;
        while (root != null) {
            if (p.data < root.data) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        Node node = BSTInorderSuccessor.inorderSuccessor(root, root.left);

        System.out.println("Inorder Successor: " + (node != null ? node.data : "null"));
    }
}
