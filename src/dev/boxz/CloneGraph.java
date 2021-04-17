package dev.boxz;

import java.util.*;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/clone-graph/">CloneGraph</a>
 */
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node> ();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public static void main (String[] args) {

    }

    public Node cloneGraph(Node node) {
        if (node==null){
            return null;
        }
        Queue<Node> queue=new LinkedList<> ();
        HashMap<Node,Node> copyList=new HashMap<> ();
//        HashSet<Node> hasVisited=new HashSet<> ();
        queue.add (node);
        copyList.put (node,new Node (node.val));
//        hasVisited.add (node);
        while (!queue.isEmpty ()){
            Node n=queue.poll ();
            for (Node neighbor : n.neighbors) {
                if (!copyList.containsKey (neighbor)){
                    copyList.put (neighbor,new Node (neighbor.val));
                    queue.add (neighbor);
                }
                copyList.get (n).neighbors.add (copyList.get (neighbor));
            }

        }
        return copyList.get (node);
    }
}
