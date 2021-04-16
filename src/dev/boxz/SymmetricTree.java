package dev.boxz;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/symmetric-tree/">SymmetricTree</a>
 */
public class SymmetricTree {

    public static void main (String[] args) {

    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode () {
        }

        TreeNode (int val) {
            this.val = val;
        }

        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean Solution(TreeNode root){
        return isMirror (root,root);
    }

    public boolean isMirror(TreeNode left,TreeNode right){
        if (left==null&&right==null){
            return true;
        }
        if (left==null||right==null){
            return false;
        }
        if (left.val!= right.val){
            return false;
        }
        else{
            return (isMirror (left.left,right.right))&&isMirror(left.right,right.left);
        }
    }
}
