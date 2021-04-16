package dev.boxz;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">MinimumDepthofBinaryTree</a>
 */
public class MinimumDepthofBinaryTree {

    public static void main (String[] args) {
        TreeNode root4=new TreeNode (4);
        TreeNode root5=new TreeNode (5);
        TreeNode root3=new TreeNode (3);
        TreeNode root2=new TreeNode (2,root4,root5);
        TreeNode root1=new TreeNode (1,root2,root3);
        MinimumDepthofBinaryTree minimumDepthofBinaryTree=new MinimumDepthofBinaryTree ();
        minimumDepthofBinaryTree.minDepth (root1);
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
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<> ();
        queue.add (root);
        int depth=1;
        while (!queue.isEmpty ()){
            int length=queue.size ();
            for (int i=0;i<length;i++){
                TreeNode treeNode=queue.poll ();
                if (treeNode.left==null&&treeNode.right==null){
                    return depth;
                }
                if (treeNode.left!=null){
                    queue.add (treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.add (treeNode.right);
                }
            }
            depth+=1;
        }
        return depth;
    }
}
