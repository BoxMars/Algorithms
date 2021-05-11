package dev.boxz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SoftwareAllocation {

    int[] job;
    int[][] workMachine;
    ArrayList<Integer> path;
    int[][] res;
    public static void main (String[] args) {

    }

    public char[] Sloution(int[] job,boolean[][] workMachine) {

        return null;
    }

    int bfs(int s, int t){

        Queue<Integer> queue=new LinkedList<> ();
        int min=Integer.MAX_VALUE;
        queue.add (s);
        path.add (s);
        while (!queue.isEmpty ()){
            int cur=queue.peek ();
            if (cur==t){
                for (int i = 1; i < path.size (); i++) {
                    res[path.get (i-1)][path.get (i)]-=min;
                    res[path.get (i)][path.get (i-1)]+=min;
                }
                return min;
            }
            for (int i = 0; i < res.length; i++) {
                if (res[cur][i]>0&&!path.contains (i)){
                    path.add (i);
                    queue.add (i);
                    min=Math.min (min,res[cur][i]);
                }
            }
        }

        return 0;
    }
}