package clientQuestion;

public class CountCompleteTreeNodes {
    //https://leetcode.com/problems/count-complete-tree-nodes/?envType=study-plan-v2&envId=top-interview-150
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        else if (root.left == null) {
            return countNodes(root.right) + 1;
        } else if (root.right == null) {
            return countNodes(root.left) + 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }

    }
}
