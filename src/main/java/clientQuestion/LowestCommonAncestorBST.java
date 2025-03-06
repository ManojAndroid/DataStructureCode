package clientQuestion;

public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {// if root is grt means present in left side
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {// if root is less means present in right side
                root = root.right;
            } else {
                return root;//return result
            }
        }
        return null;
    }

    public static void main(String[] args) {
       /* Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        Output: 6
        Explanation: The LCA of nodes 2 and 8 is 6.*/
    }
}
