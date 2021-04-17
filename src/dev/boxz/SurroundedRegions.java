package dev.boxz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/surrounded-regions/">SurroundedRegions</a>
 */
public class SurroundedRegions {

    public static void main (String[] args) {
        long startTime=System.currentTimeMillis();
        new SurroundedRegions ().solve (new char[][]{new char[]{'O','O'},new char[]{'O','O'}});
        long endTime=System.currentTimeMillis();
        System.out.println((endTime-startTime)+"ms");
    }

    public void solve(char[][] board) {
        if (board==null){
            return;
        }
        boolean[][] isX=new boolean[board.length][board[0].length];
//        boolean[][] hasVisited=new boolean[board.length][board[0].length];

        Queue<int[]> queue=new LinkedList<> ();
        for (int i=0;i<board[0].length;i++){
            if (board[0][i]=='O'&&!isX[0][i]){
                isX[0][i]=true;
//                hasVisited[0][i]=true;
                queue.add (new int[]{0,i});
            }
        }
        for (int i=0;i<board[0].length;i++){
            if (board[board.length-1][i]=='O'&&!isX[board.length-1][i]){
                isX[board.length-1][i]=true;
//                hasVisited[0][i]=true;
                queue.add (new int[]{board.length-1,i});
            }
        }
        for (int i=0;i<board.length;i++){
            if (board[i][0]=='O'&&!isX[i][0]){
                isX[i][0]=true;
//                hasVisited[0][i]=true;
                queue.add (new int[]{i,0});
            }
        }
        for (int i=0;i<board.length;i++){
            if (board[i][board[0].length-1]=='O'&&!isX[i][board[0].length-1]){
                isX[i][board[0].length-1]=true;
//                hasVisited[0][i]=true;
                queue.add (new int[]{i,board[0].length-1});
            }
        }
         while (!queue.isEmpty ()){
             int[] location=queue.poll ();
             ArrayList<int[]> directions=new ArrayList<> ();
             if (location[0]!=0){
                 directions.add (new int[]{-1,0});
             }
             if (location[0]!=board.length-1){
                 directions.add (new int[]{1,0});
             }
             if (location[1]!=0){
                 directions.add (new int[]{0,-1});
             }
             if (location[1]!=board[0].length-1){
                 directions.add (new int[]{0,1});
             }

             for (int[] direction : directions) {
                 int x=location[0]+direction[0];
                 int y=location[1]+direction[1];
                 if (board[x][y]=='O'&&!isX[x][y]){
                     queue.add (new int[]{x,y});
                     isX[x][y]=true;
                 }
             }
         }

         for (int i=0;i<board.length;i++){
             for (int j=0;j<board[0].length;j++){
                 if (!isX[i][j]){
                     board[i][j]='X';
                 }
             }
         }
    }
}
