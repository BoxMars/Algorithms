package dev.boxz;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/perfect-squares/">Perfect Squares</a>
 */
public class PerfectSquares {

    public static void main (String[] args) {
        System.out.println (new PerfectSquares ().Solution (7168));
    }
    public int Solution(int n){
        Queue<Integer> queue=new LinkedList ();
        queue.add (n);
        int ans=0;
        while (!queue.isEmpty ()){
            int length=queue.size ();
            for (int i = 0; i < length; i++) {
                int num=queue.poll ();
                for (int j=1;j<=Math.sqrt (num);j++){
                    if (num-j*j==0){
                        return ans+1;
                    }
                    queue.add (num-j*j);
                }
            }
            ans++;
        }


        return 0;
    }

}
