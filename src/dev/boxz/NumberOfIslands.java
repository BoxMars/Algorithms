package dev.boxz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/number-of-islands/">NumberOfIslands</a>
 */
public class NumberOfIslands {

    public static void main (String[] args) {
        char[][] grid=new char[][]{
                new char[]{'1','1','1','1','0'},
                new char[]{'1','1','0','1','0'},
                new char[]{'1','1','1','1','0'},
                new char[]{'1','1','0','1','0'}
        };
        long startTime=System.currentTimeMillis();
        new NumberOfIslands ().numIslands (grid);
        long endTime=System.currentTimeMillis();
        System.out.println((endTime-startTime)+"ms");
    }

    public int numIslands(char[][] grid) {
        int num=0;
        boolean[][] hasVisited=new  boolean[grid.length][grid[0].length];
        int[] direction1=new int[]{-1,0};
        int[] direction2=new int[]{0,-1};
        int[] direction3=new int[]{1,0};
        int[] direction4=new int[]{0,1};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!hasVisited[i][j]&& grid[i][j]=='1'){
                    Queue<int[]> queue=new LinkedList<> ();
                    queue.add (new int[]{i,j});
                    hasVisited[i][j]=true;
                    num++;
                    while (!queue.isEmpty ()){
                        int[] t=queue.poll ();
                        int m=t[0];
                        int n=t[1];
                        ArrayList<int[]> directions=new ArrayList<> ();

                        if (m!=0){
                            directions.add (direction1);
                        }
                        if (n!=0){
                            directions.add (direction2);
                        }
                        if (m!= grid.length-1){
                            directions.add (direction3);
                        }
                        if (n!= grid[0].length-1){
                            directions.add (direction4);
                        }

                        for (int[] direction : directions) {
                            int x=direction[0];
                            int y=direction[1];
                            if (grid[m+x][n+y]=='1'&& !hasVisited[m+x][n+y]){
                                queue.add (new int[]{m+x,n+y});
                                hasVisited[m+x][n+y]=true;
                            }
                        }
                    }
                }
            }
        }

        return num;
    }
}
