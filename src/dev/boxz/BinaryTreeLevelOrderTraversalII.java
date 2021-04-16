package dev.boxz;

import java.util.*;

/**
 * @author Box
 * @see <a hrefr="https://leetcode.com/problems/binary-tree-level-order-traversal-ii">BinaryTreeLevelOrderTraversalII</a>
 */
public class BinaryTreeLevelOrderTraversalII {
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
        Collections.reverse (ans);
        return ans;
    }
}
