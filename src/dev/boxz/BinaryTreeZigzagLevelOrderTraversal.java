package dev.boxz;

import java.util.*;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">BinaryTreeZigzagLevelOrderTraversal</a>
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main (String[] args) {
        TreeNode treeNode1=new TreeNode (1);
        TreeNode treeNode2=new TreeNode (2);
        TreeNode treeNode=new TreeNode (3,treeNode1,treeNode2);
        BinaryTreeZigzagLevelOrderTraversal binaryTreeLevelOrderTraversal=new BinaryTreeZigzagLevelOrderTraversal ();
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

        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        boolean isReserve=true;
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
                    if (treeNode.left != null) {
                        queue.add (treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.add (treeNode.right);
                    }

            }
            if (isReserve){
                Collections.reverse (tAns);
            }
            ans.add (tAns);
            isReserve=!isReserve;
        }
        return ans;
    }


}
