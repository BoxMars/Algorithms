package dev.boxz;

import java.util.Scanner;
import java.util.StringTokenizer;

public class JollyJumpers   {

    public static void main (String[] args) {
        Scanner in= new Scanner (System.in);

        while (in.hasNext()){
            StringTokenizer tokenizer=new StringTokenizer (in.nextLine ());
            int len=Integer.parseInt (tokenizer.nextToken ());
            int[] num=new int[len];
            for (int i=0;i<len;i++){
                num[i]=Integer.parseInt (tokenizer.nextToken ());
            }
            System.out.println (Solution (num)?"Jolly":"Not jolly");

        }
    }
    /**
     * @see <a href="https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=12&page=show_problem&problem=979">JollyJumpers</a>
     * @return
     */
    public static boolean Solution (int[] a) {
        int len=a.length;
        boolean[] diff=new boolean[len];
        diff[0]=true;
        for (int i=0;i<len-1;i++){
            if (Math.abs (a[i]-a[i+1])==0||Math.abs (a[i]-a[i+1])>len-1){
                return false;
            }
            else {
                diff[Math.abs (a[i]-a[i+1])]=true;
            }
        }
        for (boolean d : diff){
            if (!d){
                return false;
            }
        }
        return true;
    }
}
