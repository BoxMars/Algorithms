package dev.boxz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">BinaryTreeLevelOrderTraversal</a>
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main (String[] args) {
        TreeNode treeNode1=new TreeNode (1);
        TreeNode treeNode2=new TreeNode (2);
        TreeNode treeNode=new TreeNode (3,treeNode1,treeNode2);
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal=new BinaryTreeLevelOrderTraversal ();
        System.out.println (binaryTreeLevelOrderTraversal.levelOrder (treeNode).toString ());
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<> ();
        if (root==null){
            return ans;
        }
        Queue<TreeNode> queue=new LinkedList<> ();
        queue.add (root);
        while (!queue.isEmpty ()){
            List<Integer> tAns=new ArrayList<> ();
            int length= queue.size ();
            for (int i=0;i<length;i++){
                TreeNode treeNode=queue.poll ();
                tAns.add (treeNode.val);
                if (treeNode.left!=null){
                    queue.add (treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.add (treeNode.right);
                }
            }
            ans.add (tAns);
        }
        return ans;
    }
}
