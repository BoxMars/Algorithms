package dev.boxz;

import java.util.*;

public class Test {

    private int residualNetwork[][];
    private int flowNetwork[][];
    int[] parent;
    int[][] graph;
    public static void main (String[] args) {

    }

    void edmondsKarpMaxFlow(int[][] graph,int s,int t){
        int length=graph.length;
        parent=new int[length];
        Arrays.fill (parent,-1);

        int[][] f=new int[length][length];


    }



    public void bfs(int s,int t){
        parent=new int[graph.length];
        Queue<Integer> queue=new LinkedList<> ();
        queue.add (s);
        int min=Integer.MAX_VALUE;
        while (!queue.isEmpty ()){
            int cur=queue.peek ();
            for (int i = 0; i < graph.length; i++) {
                if (graph[cur][i]>0){
                    queue.add (i);
                    min=Math.min (min,graph[cur][i]);
                }
            }
        }

    }


}
