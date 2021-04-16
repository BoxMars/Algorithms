package dev.boxz;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">MinimumDepthofBinaryTree</a>
 */
public class MinimumDepthofBinaryTree {

    public static void main (String[] args) {

    }
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode () {
        }

        TreeNode (int val) {
            this.val = val;
        }

        TreeNode (int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root) {


        return 0;
    }
}
