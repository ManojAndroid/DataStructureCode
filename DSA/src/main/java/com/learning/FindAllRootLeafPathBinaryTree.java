package com.learning;

import java.util.ArrayList;
import java.util.List;

public class FindAllRootLeafPathBinaryTree {

    public static List<Integer> ans = new ArrayList<>();

    public static List<List<Integer>> Paths(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        List<Integer> arr = new ArrayList<>();
        helper(root, arr, ans);
        return ans;
    }

    public static void helper(Node root, List<Integer> arr, List<List<Integer>> ans) {
        if (root == null)
            return;
        arr.add(root.data);
        if (root.left == null && root.right == null) {
            ans.add(arr);
        }
        helper(root.left, new ArrayList<>(arr), ans);
        helper(root.right, new ArrayList<>(arr), ans);
    }

    public static List<Integer> printAllLeafNode(Node root) {
        if (root == null)
            return ans;
        if (root.left == null && root.right == null) {
            ans.add(root.data);
        }
        printAllLeafNode(root.left);
        printAllLeafNode(root.right);
        return  ans;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        System.out.println(Paths(root));

        System.out.println("print leaf node");

        System.out.println(printAllLeafNode(root));

    }

}
