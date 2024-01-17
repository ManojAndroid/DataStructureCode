package com.learning;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopAndBottomOfTree {
   /* Time Complexity: O(N), Since we only perform level-order traversal and print some part of the N nodes which at max will be 2N in case of skew tree
    Auxiliary Space: O(N), Since we store the nodes in the map and queue.*/
    public static void bottomView(NodeView node) {
        if (node == null) {
            return;
        }
        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<NodeView> queue = new LinkedList<>();
        node.hd = hd;
        queue.add(node);
        while (!queue.isEmpty()) {
            NodeView temp = queue.poll();
            hd = temp.hd;
            map.put(hd, temp.data);

            if (temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }
        map.forEach((k, v) -> {
            System.out.print(v + ",");
        });
    }

    public static void topView(NodeView node) {
        if (node == null) {
            return;
        }
        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<NodeView> queue = new LinkedList<>();
        node.hd = hd;
        queue.add(node);
        while (!queue.isEmpty()) {
            NodeView temp = queue.poll();
            hd = temp.hd;
            if (!map.containsKey(hd)) {
                map.put(hd, temp.data);
            }

            if (temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }
        map.forEach((k, v) -> {
            System.out.print(v + ",");
        });
    }

    public static void main(String[] args) {
        NodeView root = new NodeView(20);
        root.left = new NodeView(8);
        root.right = new NodeView(22);
        root.left.left = new NodeView(5);
        root.left.right = new NodeView(3);
        root.right.left = new NodeView(4);
        root.right.right = new NodeView(25);
        root.left.right.left = new NodeView(10);
        root.left.right.right = new NodeView(14);
        System.out.println("Bottom view of the given binary tree:");//5 10 4 14 25
        bottomView(root);
        NodeView root1 = new NodeView(1);
        root1.left = new NodeView(2);
        root1.right = new NodeView(3);
        root1.left.right = new NodeView(4);
        root1.left.right.right = new NodeView(5);
        root1.left.right.right.right = new NodeView(6);
        System.out.println("print top view");
        topView(root1);//2 1 3 6
    }
}

class NodeView {
    int data;
    int hd;
    NodeView left, right;

    NodeView(int data) {
        this.left = right = null;
        this.data = data;
        this.hd = Integer.MAX_VALUE;
    }

}
