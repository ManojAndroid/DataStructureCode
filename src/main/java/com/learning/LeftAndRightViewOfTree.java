package com.learning;

public class LeftAndRightViewOfTree {

   /* Time Complexity: O(N), The function does a simple traversal of the tree, so the complexity is O(n).
    Auxiliary Space: O(h), due to the stack space during recursive call. ‘h’ here is the height of the binary tree.*/
    static int maxLevelForLeft=0;
    static int maxLevelForRight=0;

    public static void leftView(Node node,int level){
        if(node==null){
            return;
        }
        if(maxLevelForLeft<level){
            System.out.print(node.data+" ");
            maxLevelForLeft=level;
        }
        leftView(node.left,level+1);
        leftView(node.right,level+1);
    }

    public static void rightView(Node node,int level){
        if(node==null){
            return;
        }
        if(maxLevelForRight<level){
            System.out.print(node.data+" ");
            maxLevelForRight=level;
        }
        rightView(node.right,level+1);//first call right
        rightView(node.left,level+1);//then left other are same like left view
    }

    public static void main(String[] args) {
        Node root= new Node(10);
        root.left=new Node(5);
        root.right=new Node(4);
        root.left.left=new Node(12);
        root.right.right=new Node(11);

        System.out.println("print left view");//10,5,12

       leftView(root,1);
        System.out.println("");

        Node root1= new Node(10);
        root1.left=new Node(5);
        root1.right=new Node(4);
        root1.left.left=new Node(12);
        root1.right.right=new Node(11);

        System.out.println("print right view");//10,4,11

        rightView(root1,1);

    }
}
