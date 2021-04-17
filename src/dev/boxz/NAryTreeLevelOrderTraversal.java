package dev.boxz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/n-ary-tree-level-order-traversal/">N-ary Tree Level Order Traversal</a>
 */
public class NAryTreeLevelOrderTraversal {

    public static void main (String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<> ();
        if (root==null){
            return ans;
        }

        Queue<Node> queue=new LinkedList<> ();
        queue.add (root);

        while (!queue.isEmpty ()){
            int size=queue.size ();
            List<Integer> temp=new ArrayList<> ();
            for (int i = 0; i < size; i++) {
                Node node=queue.poll ();
                temp.add (node.val);

                if (node.children!=null){
                    for (Node child : node.children) {
                        queue.add (child);
                    }
                }
            }
            ans.add (temp);
        }
        return ans;

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
