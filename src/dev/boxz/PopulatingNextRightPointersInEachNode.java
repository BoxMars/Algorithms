package dev.boxz;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">PopulatingNextRightPointersInEachNode</a>
 */
public class PopulatingNextRightPointersInEachNode {

    public static void main (String[] args) {

    }

    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        Queue<Node> queue=new LinkedList<> ();
        queue.add (root);
        while (!queue.isEmpty ()){
            int length=queue.size ();
            for (int i=0;i<length-1;i++){
                Node node=queue.poll ();
                node.next=queue.element ();
                if (node.left!=null){
                    queue.add (node.left);
                    queue.add (node.right);
                }
            }
            Node node=queue.poll ();
            if (node.left!=null){
                queue.add (node.left);
                queue.add (node.right);
            }
        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
