package dev.boxz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/">BinaryTreeRightSideView</a>
 */
public class BinaryTreeRightSideView {

    public static void main (String[] args) {

    }

    public List<Integer> rightSideView (TreeNode root) {
        List<Integer> ans=new ArrayList<> ();
        if (root==null){
            return ans;
        }

        Queue<TreeNode> queue=new LinkedList ();


        queue.add (root);

        while (!queue.isEmpty ()){
            int length=queue.size ();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode=queue.poll ();
                if (treeNode.left!=null){
                    queue.add (treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.add (treeNode.right);
                }
                if (i==length-1){
                    ans.add (treeNode.val);
                }
            }
        }


        return ans;
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
}
